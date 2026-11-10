#!/usr/bin/env python3
"""Independent CI stages sharing one serialized Home Assistant build."""

import argparse
import hashlib
import importlib
import json
import os
from pathlib import Path
import subprocess
import sys
import tempfile
import time


planner = importlib.import_module("ci-plan")
CONFIGURATION = "homeassistant-x86"
TARGET = "core-image-homeassistant-full"
TEST_FRAGMENTS = (
    "homeassistant/enable-testing-base",
    "homeassistant/add-homeassistant-image-test-deps",
)


def write_json(path: Path, value: dict) -> None:
    with tempfile.NamedTemporaryFile(mode="w", dir=path.parent, delete=False) as stream:
        temporary = Path(stream.name)
    try:
        with temporary.open("w") as stream:
            json.dump(value, stream, indent=2, sort_keys=True)
            stream.write("\n")
            stream.flush()
            os.fsync(stream.fileno())
        temporary.replace(path)
    finally:
        temporary.unlink(missing_ok=True)


def owner() -> str:
    return json.dumps([
        os.environ["CI_REPOSITORY"], os.environ["CI_RUN_ID"],
        os.environ.get("CI_RUN_ATTEMPT", "1"),
    ])


def acquire(state: Path, timeout: float = 21600) -> None:
    state.mkdir(parents=True, exist_ok=True)
    deadline = time.monotonic() + timeout
    print("Waiting for exclusive access to the shared CI build", flush=True)
    while True:
        try:
            with (state / "build.lock").open("x") as stream:
                stream.write(owner())
            print("Acquired shared CI build", flush=True)
            return
        except FileExistsError:
            if time.monotonic() >= deadline:
                raise RuntimeError(
                    "Shared build is locked; check the owning workflow. "
                    "A terminated runner may require manual lock recovery."
                ) from None
            time.sleep(5)


def assert_owner(state: Path) -> None:
    if (state / "build.lock").read_text() != owner():
        raise RuntimeError("This workflow does not own the shared build lock")


def release(state: Path) -> None:
    path = state / "build.lock"
    if path.exists() and path.read_text() == owner():
        path.unlink()
        print("Released shared CI build", flush=True)


def scope() -> dict:
    return {
        "repository": os.environ["CI_REPOSITORY"],
        "ref": os.environ["CI_REF"],
        "configuration": CONFIGURATION,
    }


def baseline_path(state: Path) -> Path:
    key = hashlib.sha256(json.dumps(scope(), sort_keys=True).encode()).hexdigest()
    return state / "baselines" / f"{key}.json"


def ptest_state_path(state: Path) -> Path:
    key = hashlib.sha256(json.dumps(scope(), sort_keys=True).encode()).hexdigest()
    return state / "ptest-state" / f"{key}.json"


def make_plan(repo: Path, state: Path) -> None:
    revision = planner.checkout_revision(repo)
    baseline = planner.find_baseline(repo, state / "baselines", scope(), revision)
    report = planner.plan(repo, baseline, revision)
    test_state = ptest_state_path(state)
    if test_state.is_file():
        report["ptest_results"] = json.loads(test_state.read_text())
    report.update(scope=scope(), revision=revision, results={})
    write_json(state / "run.json", report)
    print(f"Change detection: {report['reason']}", flush=True)
    print(f"Changed recipes: {', '.join(report['recipes']) or '(none)'}", flush=True)


def prepare(repo: Path, state: Path, bootstrap: Path) -> Path:
    config = json.loads((repo / "configurations/homeassistant.conf.json").read_text())
    config["sources"]["meta-homeassistant"] = {"local": {"path": str(repo)}}
    selected = next(
        item for item in config["bitbake-setup"]["configurations"]
        if item["name"] == CONFIGURATION
    )
    for fragment in TEST_FRAGMENTS:
        if fragment not in selected["oe-fragments"]:
            selected["oe-fragments"].append(fragment)
    config_path = state / "configuration.conf.json"
    write_json(config_path, config)
    top = state / "bitbake-builds"
    top.mkdir(exist_ok=True)
    (top / "site.conf").write_text(
        'DL_DIR ?= "/cache/downloads/"\n'
        'SSTATE_DIR ?= "/cache/sstate-cache"\n'
        'BB_HASHSERVE_DB_DIR ?= "${SSTATE_DIR}"\n'
        'INHERIT += "rm_work"\n'
        'TEST_LOG_DIR = "${TOPDIR}/ci-test-logs/${PN}"\n'
    )
    setup = top / CONFIGURATION
    command = [
        str(bootstrap / "bin/bitbake-setup"),
        "--setting", "default", "top-dir-prefix", str(state),
        "--setting", "default", "dl-dir", "/cache/downloads/",
    ]
    if (setup / "build/init-build-env").is_file():
        command += ["update", "--setup-dir", str(setup), "--update-bb-conf", "yes"]
    else:
        if setup.exists():
            preserved = setup.with_name(f"{setup.name}.incomplete-{time.time_ns()}")
            setup.rename(preserved)
            print(f"Preserved incomplete setup at {preserved}; initializing a new wrapper", flush=True)
        command += [
            "init", "--non-interactive", "--setup-dir-name", CONFIGURATION,
            str(config_path), CONFIGURATION,
        ]
    subprocess.run(command, cwd=repo, check=True)
    if not (setup / "build/init-build-env").is_file():
        raise RuntimeError("Build configuration setup did not create an environment")
    return setup


def build_command(setup: Path, arguments: list[str]) -> list[str]:
    # init-build-env may replace the shell's positional arguments.
    return [
        "bash", "-c",
        'set -eo pipefail; readonly ci_env="$1"; shift; '
        'readonly -a ci_command=("$@"); source "$ci_env" >&2; "${ci_command[@]}"',
        "ci-validate", str(setup / "build/init-build-env"), *arguments,
    ]


def get_variable(repo: Path, setup: Path, recipe: str, name: str) -> str:
    return subprocess.check_output(
        build_command(setup, ["bitbake-getvar", "-r", recipe, "--value", name]),
        cwd=repo, text=True,
    ).strip()


def validate(repo: Path, setup: Path, target: str) -> None:
    print(f"Building and testing {target}", flush=True)
    subprocess.run(build_command(setup, ["bitbake", target]), cwd=repo, check=True)


def clean_image(repo: Path, setup: Path, target: str) -> None:
    print(f"Removing successful dependency image output: {target}", flush=True)
    subprocess.run(
        build_command(setup, ["bitbake", "-c", "clean", target]), cwd=repo, check=True,
    )


def run_ptest_batch(repo: Path, setup: Path, targets: list[str], directory: Path) -> int:
    configuration = directory / "results.conf"
    configuration.write_text(
        f'HA_CI_PTEST_RESULTS = {json.dumps(str(directory))}\n'
        f'BBPATH:prepend = {json.dumps(str(directory) + ":")}\n'
        'INHERIT += "ha-ci-ptest-results"\n'
    )
    classes = directory / "classes"
    classes.mkdir()
    (classes / "ha-ci-ptest-results.bbclass").write_text("""
addhandler ha_ci_ptest_result
ha_ci_ptest_result[eventmask] = "bb.build.TaskSucceeded bb.build.TaskFailed bb.build.TaskFailedSilent"
python ha_ci_ptest_result() {
    from pathlib import Path

    if e.task != "do_testimage":
        return
    status = "passed" if isinstance(e, bb.build.TaskSucceeded) else "failed"
    path = Path(d.getVar("HA_CI_PTEST_RESULTS")) / e.pn
    temporary = path.with_suffix(".tmp")
    temporary.write_text(status)
    temporary.replace(path)
}
"""
    )
    print(f"Building and testing dependency images: {', '.join(targets)}", flush=True)
    return subprocess.run(
        build_command(setup, ["bitbake", "-k", "-R", str(configuration), *targets]),
        cwd=repo, check=False,
    ).returncode


def save_ptest_state(state: Path, results: dict) -> None:
    path = ptest_state_path(state)
    path.parent.mkdir(parents=True, exist_ok=True)
    write_json(path, results)


def ptests(repo: Path, setup: Path, state: Path, report: dict) -> None:
    enabled = sorted(set(get_variable(
        repo, setup, "meta-homeassistant-image-ptest", "PTESTS_META_HOMEASSISTANT"
    ).split()))
    if not enabled:
        raise RuntimeError("No enabled dependency ptests found; check the build configuration")
    previous = set(report["baseline_ptests"])
    results = {
        recipe: result for recipe, result in report.get("ptest_results", {}).items()
        if recipe in enabled and isinstance(result, dict)
    }
    changed = set(report["recipes"]) & set(enabled)
    fingerprints = planner.recipe_fingerprints(
        repo, report["revision"], sorted(changed), report["changed_files"],
    )
    selected = sorted(
        recipe for recipe in enabled
        if report.get("all_ptests")
        or recipe not in results
        or recipe in changed and results[recipe].get("fingerprint") != fingerprints[recipe]
        or recipe not in previous and results[recipe].get("status") not in ("failed", "pending")
    )
    report["enabled_ptests"] = enabled
    report["selected_ptests"] = selected
    report["ptest_results"] = results
    for recipe in selected:
        fingerprint = fingerprints.get(recipe)
        if not fingerprint:
            fingerprint = planner.recipe_fingerprints(
                repo, report["revision"], [recipe], [],
            )[recipe]
        results[recipe] = {"fingerprint": fingerprint, "status": "pending"}
    save_ptest_state(state, results)
    write_json(state / "run.json", report)
    print(f"Selected dependency ptests: {', '.join(selected) or '(none)'}", flush=True)
    batch_status = 0
    if selected:
        targets = [f"meta-homeassistant-image-ptest-{recipe}" for recipe in selected]
        with tempfile.TemporaryDirectory(prefix="ptest-batch-", dir=state) as temporary:
            directory = Path(temporary)
            batch_status = run_ptest_batch(repo, setup, targets, directory)
            for recipe, target in zip(selected, targets):
                result = directory / target
                status = result.read_text() if result.is_file() else "pending"
                if status not in ("passed", "failed", "pending"):
                    raise RuntimeError(f"Invalid ptest task result for {target}: {status!r}")
                results[recipe]["status"] = status
            save_ptest_state(state, results)
            write_json(state / "run.json", report)
        if batch_status:
            print(f"Dependency ptest BitBake batch exited with status {batch_status}", flush=True)
    for recipe in selected:
        if results[recipe]["status"] == "passed":
            clean_image(repo, setup, f"meta-homeassistant-image-ptest-{recipe}")
    failed = [name for name in enabled if results.get(name, {}).get("status") in ("failed", "pending")]
    if failed:
        raise RuntimeError(f"Dependency ptests pending: {', '.join(failed)}")
    if batch_status:
        raise RuntimeError(f"Dependency ptest BitBake batch failed with status {batch_status}")


def finish(repo: Path, state: Path, report: dict) -> None:
    required = ("prepare", "image")
    passed = all(report["results"].get(stage) == "passed" for stage in required)
    print("Required validation stages:", flush=True)
    for stage in required:
        print(f"  {stage}: {report['results'].get(stage, 'not run')}", flush=True)
    summary = os.environ.get("GITHUB_STEP_SUMMARY")
    if summary:
        with open(summary, "a") as stream:
            stream.write("## Home Assistant validation\n\n| Stage | Result |\n|---|---|\n")
            for stage in required:
                stream.write(f"| {stage} | {report['results'].get(stage, 'not run')} |\n")
            stream.write(f"| dependency ptests | {report['results'].get('ptests', 'not run')} |\n")
            for recipe, result in report.get("ptest_results", {}).items():
                stream.write(
                    f"| `{recipe}` | {result.get('status', 'unknown')} |\n"
                )
    results = report.get("ptest_results", {})
    pending = [
        recipe for recipe, result in results.items()
        if result.get("status") in ("failed", "pending")
    ]
    print(
        f"Dependency ptests: {len(results) - len(pending)} passed, "
        f"{len(pending)} pending" + (f" ({', '.join(sorted(pending))})" if pending else ""),
        flush=True,
    )
    if not passed:
        raise RuntimeError("Required image validation did not pass; image baseline unchanged")
    if planner.checkout_revision(repo) != report["revision"]:
        raise RuntimeError("Checkout changed during validation; baselines unchanged")
    path = baseline_path(state)
    path.parent.mkdir(exist_ok=True)
    baseline = {
        "policy": planner.POLICY, "scope": scope(), "revision": report["revision"],
        "enabled_ptests": report.get("enabled_ptests", report.get("baseline_ptests", [])),
        "ptest_results": results,
    }
    history = path.parent / "history"
    history.mkdir(exist_ok=True)
    write_json(history / f"{path.stem}-{report['revision']}.json", baseline)
    write_json(path, baseline)
    print("Full-image validation baseline advanced", flush=True)


def execute(stage: str, repo: Path, state: Path) -> None:
    if stage == "acquire":
        acquire(state)
        return
    if stage == "release":
        release(state)
        return
    assert_owner(state)
    if stage == "plan":
        make_plan(repo, state)
        return
    report = json.loads((state / "run.json").read_text())
    if report["scope"] != scope() or report["revision"] != planner.checkout_revision(repo):
        raise RuntimeError("CI plan does not match this checkout")
    setup = state / "bitbake-builds" / CONFIGURATION
    if stage == "finish":
        finish(repo, state, report)
        return
    report["results"][stage] = "failed"
    write_json(state / "run.json", report)
    if stage == "prepare":
        with tempfile.TemporaryDirectory(prefix="ha-ci-bitbake-") as temporary:
            bootstrap = Path(temporary) / "bitbake"
            subprocess.run(
                ["git", "clone", "--quiet", "--depth", "1",
                 "https://git.openembedded.org/bitbake", str(bootstrap)], check=True,
            )
            prepare(repo, state, bootstrap)
    elif stage == "ptests":
        ptests(repo, setup, state, report)
    elif stage == "image":
        validate(repo, setup, TARGET)
    report["results"][stage] = "passed"
    write_json(state / "run.json", report)


def main() -> None:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("stage", choices=("acquire", "plan", "prepare", "ptests", "image", "finish", "release"))
    parser.add_argument("--state-root", type=Path, required=True)
    args = parser.parse_args()
    try:
        execute(args.stage, Path(__file__).resolve().parent.parent, args.state_root.resolve())
    except (subprocess.CalledProcessError, RuntimeError, OSError) as error:
        print(f"CI {args.stage} failed: {error}", file=sys.stderr, flush=True)
        raise SystemExit(1) from None


if __name__ == "__main__":
    main()
