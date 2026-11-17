#!/usr/bin/env python3
"""Independent CI stages sharing one serialized Home Assistant build."""

import argparse
import hashlib
import importlib
import json
import os
import platform
from pathlib import Path
import re
import subprocess
import sys
import tempfile
import time


planner = importlib.import_module("ci-plan")
CONFIGURATION = "homeassistant-x86"
TARGET = "core-image-homeassistant-full"
PTEST_VALIDATION_CACHE_VERSION = 2
IMAGE_VALIDATION_CACHE_VERSION = 2
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


def make_plan(repo: Path, state: Path) -> None:
    revision = planner.checkout_revision(repo)
    baseline = planner.find_baseline(repo, state / "baselines", scope(), revision)
    report = planner.plan(repo, baseline, revision)
    report.update(scope=scope(), revision=revision, results={})
    write_json(state / "run.json", report)
    print(f"Change detection: {report['reason']}", flush=True)
    print(f"Changed recipes: {', '.join(report['recipes']) or '(none)'}", flush=True)


def prepare(repo: Path, state: Path, bootstrap: Path) -> Path:
    assert_owner(state)
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
    pinned_layers = {
        name: source
        for name, source in config["sources"].items()
        if "git-remote" in source
        and re.fullmatch(r"[0-9a-fA-F]{40}", source["git-remote"]["rev"])
    }
    command = [
        str(bootstrap / "bin/bitbake-setup"),
        "--setting", "default", "top-dir-prefix", str(state),
        "--setting", "default", "dl-dir", "/cache/downloads/",
    ]
    if setup.is_symlink():
        raise RuntimeError(f"Refusing to update symlink wrapper {setup}")
    if setup.exists():
        if not setup.is_dir():
            raise RuntimeError(f"Refusing to update non-directory wrapper {setup}")
        if not (setup / "build/init-build-env").is_file() or not (
            setup / "config/config-upstream.json"
        ).is_file():
            raise RuntimeError(f"Existing build wrapper is incomplete: {setup}")
        command.extend([
            "update", "--setup-dir", str(setup), "--update-bb-conf", "yes",
            "--rebase-conflicts-strategy=backup",
        ])
    else:
        command.extend([
            "init", "--non-interactive", "--setup-dir-name", CONFIGURATION,
            str(config_path), CONFIGURATION,
        ])
    subprocess.run(command, cwd=repo, check=True)
    if not (setup / "build/init-build-env").is_file():
        raise RuntimeError("Build configuration setup did not create an environment")
    resolved_path = setup / "config/sources-fixed-revisions.json"
    resolved = json.loads(resolved_path.read_text())
    resolved_changed = False
    for name, source in pinned_layers.items():
        layer = setup / "layers" / source.get("path", name)
        revision = source["git-remote"]["rev"]
        actual = planner.git(layer, "rev-parse", "HEAD")
        if actual.lower() != revision.lower():
            print(
                f"Selecting configured pin {revision} for {layer.name}; "
                f"setup left HEAD at {actual}",
                flush=True,
            )
            subprocess.run(
                ["git", "-C", str(layer), "checkout", "--detach", revision],
                cwd=repo, check=True,
            )
            actual = planner.git(layer, "rev-parse", "HEAD")
        if actual.lower() != revision.lower():
            raise RuntimeError(
                f"Layer {layer.name} is at {actual}, expected configured pin {revision}"
            )
        recorded = resolved["sources"][name]["git-remote"]
        if recorded["rev"] != actual:
            recorded["rev"] = actual
            resolved_changed = True
        print(f"Verified {layer.name} at configured pin {revision}", flush=True)
    for name, source in config["sources"].items():
        if "git-remote" not in source:
            continue
        layer = setup / "layers" / source.get("path", name)
        uri = source["git-remote"]["uri"]
        if planner.git(layer, "remote", "get-url", "origin") != uri:
            print(f"Restoring configured origin for {name}: {uri}", flush=True)
            subprocess.run(
                ["git", "-C", str(layer), "remote", "set-url", "origin", uri],
                cwd=repo, check=True,
            )
    if resolved_changed:
        write_json(resolved_path, resolved)
        print("Updated resolved source revisions to match verified layer pins", flush=True)
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
    with tempfile.TemporaryDirectory(prefix="ha-ci-image-") as temporary:
        directory = Path(temporary)
        run_testimage_batch(repo, setup, [target], directory)
        result = directory / target
        status = result.read_text() if result.is_file() else "pending"
        if status != "passed":
            raise RuntimeError(f"Full-image testimage did not pass for {target}: {status}")


def testimage_status_from_log(target: str, logfile: str) -> str:
    try:
        output = Path(logfile).read_text(errors="replace")
    except OSError as error:
        raise RuntimeError(f"Cannot read testimage task log for {target}: {error}") from error
    if any(f"{target} - {status} -" in output for status in ("FAIL", "FAILED")):
        return "failed"
    if f"{target} - OK - All required tests passed" not in output:
        raise RuntimeError(f"No successful testimage summary for {target} in {logfile}")
    return "passed"


def run_testimage_batch(
    repo: Path, setup: Path, targets: list[str], directory: Path, *, keep_going: bool = False,
) -> int:
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
    import json
    from pathlib import Path

    if e.task != "do_testimage":
        return
    status = "passed" if isinstance(e, bb.build.TaskSucceeded) else "failed"
    path = Path(d.getVar("HA_CI_PTEST_RESULTS")) / (e.pn + "." + status + ".json")
    temporary = path.with_suffix(".tmp")
    temporary.write_text(json.dumps({"status": status, "logfile": e.logfile}))
    temporary.replace(path)
}
"""
    )
    print(f"Building and testing images: {', '.join(targets)}", flush=True)
    arguments = ["bitbake"]
    if keep_going:
        arguments.append("-k")
    arguments.extend(["-R", str(configuration), *targets])
    result = subprocess.run(
        build_command(setup, arguments), cwd=repo, check=not keep_going,
    )
    for target in targets:
        failed = directory / f"{target}.failed.json"
        succeeded = directory / f"{target}.passed.json"
        if failed.is_file():
            status = "failed"
        elif succeeded.is_file():
            try:
                event = json.loads(succeeded.read_text())
            except (OSError, json.JSONDecodeError) as error:
                raise RuntimeError(f"Cannot read testimage event result for {target}: {error}") from error
            if (
                not isinstance(event, dict)
                or event.get("status") != "passed"
                or not isinstance(event.get("logfile"), str)
            ):
                raise RuntimeError(f"Invalid testimage event result for {target}")
            status = testimage_status_from_log(target, event["logfile"])
        else:
            continue
        (directory / target).write_text(status)
    return result.returncode


def run_ptest_batch(repo: Path, setup: Path, targets: list[str], directory: Path) -> int:
    return run_testimage_batch(repo, setup, targets, directory, keep_going=True)


def configuration_inputs(repo: Path, setup: Path, directories: tuple[Path, ...]) -> dict:
    inputs = {}
    for directory in directories:
        for path in sorted(directory.rglob("*")):
            if path.is_file() and ".git" not in path.relative_to(directory).parts:
                inputs[str(path.relative_to(setup))] = path.read_text().replace(
                    str(setup), "${SETUP}"
                ).replace(str(repo), "${REPO}")
    return inputs


def ptest_environment(repo: Path, setup: Path, state: Path, revision: str) -> dict:
    config = json.loads((state / "configuration.conf.json").read_text())
    resolved = json.loads((setup / "config/sources-fixed-revisions.json").read_text())["sources"]
    layers = {}
    for name, source in config["sources"].items():
        layer = setup / "layers" / source.get("path", name)
        actual = planner.git(layer, "rev-parse", "HEAD")
        if planner.git(layer, "status", "--porcelain", "--untracked-files=no"):
            raise RuntimeError(f"Layer {name} has tracked modifications; cannot reuse ptest results")
        if name == "meta-homeassistant":
            if layer.resolve() != repo.resolve() or actual != revision:
                raise RuntimeError("Home Assistant layer does not match the planned checkout")
            continue
        if "git-remote" in source:
            expected = resolved[name]["git-remote"]["rev"]
            pin = source["git-remote"]["rev"]
            if re.fullmatch(r"[0-9a-fA-F]{40}", pin) and expected.lower() != pin.lower():
                raise RuntimeError(f"Layer {name} resolved to {expected}, expected configured pin {pin}")
            if actual.lower() != expected.lower():
                raise RuntimeError(f"Layer {name} is at {actual}, expected resolved revision {expected}")
            origin = planner.git(layer, "remote", "get-url", "origin")
            layers[name] = {"configured": source, "origin": origin, "revision": actual}
        else:
            layers[name] = {"configured": source, "revision": actual}
    objects = planner.metadata_objects(repo, revision)
    shared = {
        name: blob for name, blob in objects.items()
        if name.startswith((
            "conf/", "classes/", "classes-recipe/", "classes-global/", "lib/",
            "tests/image/", "dynamic-layers/", "recipes-",
        ))
        or name in ("scripts/ci-validate.py", "scripts/ci-plan.py")
        or name.endswith((".inc", ".bbclass")) or {"images", "packagegroups"} & set(Path(name).parts)
    }
    for name in ("local.conf", "bblayers.conf"):
        path = setup / "build/conf" / name
        if not path.is_file():
            raise RuntimeError(f"Missing required build configuration: {path}")
    build_config = configuration_inputs(repo, setup, (setup / "build/conf",))
    build_config["site.conf"] = (setup.parent / "site.conf").read_text().replace(
        str(setup), "${SETUP}"
    ).replace(str(repo), "${REPO}")
    selected = next(
        item for item in config["bitbake-setup"]["configurations"]
        if item["name"] == CONFIGURATION
    )
    return {
        "version": PTEST_VALIDATION_CACHE_VERSION, "layers": layers, "configuration": selected,
        "build_config": build_config, "shared_metadata": shared,
    }


def ptest_cache_path(state: Path, run_scope: dict, environment_key: str) -> Path:
    cache_scope = {key: run_scope[key] for key in ("repository", "configuration")}
    namespace = hashlib.sha256(json.dumps(cache_scope, sort_keys=True).encode()).hexdigest()
    return state / "ptest-cache" / namespace / environment_key


def image_validation_fingerprint(
    repo: Path, setup: Path, state: Path, revision: str,
) -> str:
    environment = ptest_environment(repo, setup, state, revision)
    objects = planner.metadata_objects(repo, revision)
    image_inputs = {
        name: blob for name, blob in objects.items()
        if name != "README.md" and not name.startswith("docs/")
    }
    generated_config = configuration_inputs(
        repo, setup, (setup / "build/conf", setup / "config"),
    )
    inputs = {
        "version": IMAGE_VALIDATION_CACHE_VERSION,
        "target": TARGET,
        "environment": environment,
        "homeassistant_inputs": image_inputs,
        "generated_config": generated_config,
        "host": {
            "system": platform.system(),
            "release": platform.release(),
            "machine": platform.machine(),
        },
    }
    return hashlib.sha256(json.dumps(inputs, sort_keys=True).encode()).hexdigest()


def image_validation_cache_path(state: Path, run_scope: dict, fingerprint: str) -> Path:
    cache_scope = {key: run_scope[key] for key in ("repository", "configuration")}
    namespace = hashlib.sha256(json.dumps(cache_scope, sort_keys=True).encode()).hexdigest()
    return state / "image-validation-cache" / namespace / f"{fingerprint}.json"


def reusable_image_validation(path: Path, fingerprint: str) -> dict | None:
    if not path.exists():
        return None
    if not path.is_file():
        raise RuntimeError(f"Invalid full-image validation cache entry: {path}")
    try:
        result = json.loads(path.read_text())
    except (OSError, json.JSONDecodeError) as error:
        raise RuntimeError(f"Cannot read full-image validation cache entry {path}: {error}") from error
    if (
        not isinstance(result, dict)
        or result.get("version") != IMAGE_VALIDATION_CACHE_VERSION
        or result.get("target") != TARGET
        or result.get("fingerprint") != fingerprint
        or result.get("status") != "passed"
    ):
        raise RuntimeError(f"Invalid full-image validation cache entry: {path}")
    return result


def validate_image(repo: Path, setup: Path, state: Path, report: dict) -> None:
    fingerprint = image_validation_fingerprint(repo, setup, state, report["revision"])
    cache = image_validation_cache_path(state, report["scope"], fingerprint)
    cached = reusable_image_validation(cache, fingerprint)
    if cached:
        report["image_validation"] = {
            "fingerprint": fingerprint,
            "status": "reused",
            "validated_revision": cached["revision"],
        }
        print(
            f"Reusing successful full-image validation from {cached['revision']}",
            flush=True,
        )
        return

    report["image_validation"] = {"fingerprint": fingerprint, "status": "running"}
    write_json(state / "run.json", report)
    validate(repo, setup, TARGET)
    if image_validation_fingerprint(repo, setup, state, report["revision"]) != fingerprint:
        raise RuntimeError("Build environment changed during image validation; result not cached")
    cache.parent.mkdir(parents=True, exist_ok=True)
    write_json(cache, {
        "version": IMAGE_VALIDATION_CACHE_VERSION,
        "target": TARGET,
        "fingerprint": fingerprint,
        "status": "passed",
        "revision": report["revision"],
        "run": json.loads(owner()),
        "ref": report["scope"]["ref"],
    })
    report["image_validation"] = {"fingerprint": fingerprint, "status": "built"}


def reusable_ptest_results(cache: Path, environment_key: str, fingerprints: dict[str, str]) -> dict:
    results = {}
    for recipe, fingerprint in fingerprints.items():
        path = cache / f"{fingerprint}.json"
        if not path.is_file():
            continue
        result = json.loads(path.read_text())
        if not isinstance(result, dict) or result.get("status") not in ("passed", "failed", "pending"):
            raise RuntimeError(f"Invalid cached ptest result for {recipe}")
        if result.get("environment") != environment_key or result.get("fingerprint") != fingerprint:
            raise RuntimeError(f"Cached ptest provenance does not match its key for {recipe}")
        if result["status"] == "passed":
            results[recipe] = result
    return results


def ptests(repo: Path, setup: Path, state: Path, report: dict) -> None:
    enabled = sorted(set(get_variable(
        repo, setup, "meta-homeassistant-image-ptest", "PTESTS_META_HOMEASSISTANT"
    ).split()))
    if not enabled:
        raise RuntimeError("No enabled dependency ptests found; check the build configuration")
    environment = ptest_environment(repo, setup, state, report["revision"])
    environment_key = hashlib.sha256(json.dumps(environment, sort_keys=True).encode()).hexdigest()
    cache = ptest_cache_path(state, report["scope"], environment_key)
    cache.mkdir(parents=True, exist_ok=True)
    write_json(cache / "environment.json", environment)
    report["ptest_environment"] = environment_key
    fingerprints = planner.recipe_fingerprints(repo, report["revision"], enabled)
    results = reusable_ptest_results(cache, environment_key, fingerprints)
    selected = [recipe for recipe in enabled if recipe not in results]
    print(
        f"Ptest environment {environment_key}: reused {len(results)} of {len(enabled)} results",
        flush=True,
    )
    report["enabled_ptests"] = enabled
    report["selected_ptests"] = selected
    report["ptest_results"] = results
    for recipe in selected:
        results[recipe] = {
            "recipe": recipe, "fingerprint": fingerprints[recipe],
            "environment": environment_key, "revision": report["revision"],
            "run": json.loads(owner()), "ref": report["scope"]["ref"], "status": "pending",
        }
    write_json(state / "run.json", report)
    print(f"Selected dependency ptests: {', '.join(selected) or '(none)'}", flush=True)
    batch_status = 0
    if selected:
        targets = [f"meta-homeassistant-image-ptest-{recipe}" for recipe in selected]
        with tempfile.TemporaryDirectory(prefix="ptest-batch-", dir=state) as temporary:
            directory = Path(temporary)
            batch_status = run_ptest_batch(repo, setup, targets, directory)
            if ptest_environment(repo, setup, state, report["revision"]) != environment:
                raise RuntimeError("Build environment changed during ptests; results cannot be reused")
            for recipe, target in zip(selected, targets):
                result = directory / target
                status = result.read_text() if result.is_file() else "pending"
                if status not in ("passed", "failed", "pending"):
                    raise RuntimeError(f"Invalid ptest task result for {target}: {status!r}")
                results[recipe]["status"] = status
                if status in ("passed", "failed"):
                    write_json(cache / f"{fingerprints[recipe]}.json", results[recipe])
            write_json(state / "run.json", report)
        if batch_status:
            print(f"Dependency ptest BitBake batch exited with status {batch_status}", flush=True)
    failed = [name for name in enabled if results.get(name, {}).get("status") == "failed"]
    pending = [name for name in enabled if results.get(name, {}).get("status") == "pending"]
    if failed or pending:
        details = []
        if failed:
            details.append(f"failed: {', '.join(failed)}")
        if pending:
            details.append(f"pending: {', '.join(pending)}")
        raise RuntimeError(f"Dependency ptests {'; '.join(details)}")
    if batch_status:
        raise RuntimeError(f"Dependency ptest BitBake batch failed with status {batch_status}")


def validation_summary(report: dict) -> str:
    results = report.get("results", {})
    image = report.get("image_validation", {})
    image_result = results.get("image", "not run")
    if image_result == "passed":
        image_status = "**PASSED**"
        image_status += f" ({image.get('status', 'validated')})"
    elif image_result == "failed":
        image_status = "**FAILED**"
    else:
        image_status = "**NOT RUN**"
    ptest_results = report.get("ptest_results", {})
    failed_ptests = sorted(
        name for name, result in ptest_results.items()
        if result.get("status") == "failed"
    )
    pending_ptests = sorted(
        name for name, result in ptest_results.items()
        if result.get("status") == "pending"
    )
    passed_count = sum(
        result.get("status") == "passed" for result in ptest_results.values()
    )
    ptest_status = results.get("ptests", "not run").upper()
    if failed_ptests:
        ptest_status = f"**FAILED** ({len(failed_ptests)} failed"
        if pending_ptests:
            ptest_status += f", {len(pending_ptests)} pending"
        ptest_status += ")"
    elif pending_ptests:
        ptest_status = f"**INCOMPLETE** ({len(pending_ptests)} pending)"
    elif ptest_status == "PASSED":
        ptest_status = f"**PASSED** ({passed_count} passed)"
    elif ptest_status == "FAILED":
        ptest_status = "**FAILED**"
    else:
        ptest_status = "**NOT RUN**"
    lines = [
        "# Home Assistant validation",
        "",
        f"- **Revision:** `{report['revision']}`",
        f"- **Ref:** `{report['scope']['ref']}`",
        "",
        "## Required validation",
        "",
        "| Validation | Result |",
        "|---|---|",
        f"| Preparation | {results.get('prepare', 'not run').upper()} |",
        (
            "| `core-image-homeassistant-full` image and runtime tests "
            "(includes `python3-homeassistant` ptest) | "
            f"{image_status} |"
        ),
        (
            "| Dependency ptests "
            "(`meta-homeassistant-image-ptest-*`) | "
            f"{ptest_status} |"
        ),
    ]
    lines.append("")
    if failed_ptests:
        lines.extend([
            f"> **Failed dependency ptests ({len(failed_ptests)}):** "
            + ", ".join(f"`{name}`" for name in failed_ptests),
            "",
        ])
    if pending_ptests:
        lines.extend([
            f"> **Dependency ptests without a result ({len(pending_ptests)}):** "
            + ", ".join(f"`{name}`" for name in pending_ptests),
            "",
        ])
    if image.get("validated_revision"):
        lines.extend([
            f"Full-image validation reused from `{image['validated_revision']}`.",
            "",
        ])
    if ptest_results:
        lines.extend([
            "## Dependency ptest results",
            "",
            "| Dependency | Result |",
            "|---|---|",
        ])
        for recipe, result in sorted(ptest_results.items()):
            status = result.get("status", "unknown").upper()
            if status == "FAILED":
                status = f"**{status}**"
            elif status == "PENDING":
                status = f"**{status}**"
            lines.append(f"| `{recipe}` | {status} |")
    else:
        lines.extend(["No dependency ptest results were recorded.", ""])
    return "\n".join(lines).rstrip() + "\n"


def finish(repo: Path, state: Path, report: dict) -> None:
    required = ("prepare", "image")
    passed = all(report["results"].get(stage) == "passed" for stage in required)
    print("Required validation stages:", flush=True)
    for stage in required:
        print(f"  {stage}: {report['results'].get(stage, 'not run')}", flush=True)
    summary_content = validation_summary(report)
    report_path = Path(os.environ.get("CI_REPORT_PATH", str(repo / "ci-validation-report.md")))
    if not report_path.is_absolute():
        report_path = repo / report_path
    report_path.parent.mkdir(parents=True, exist_ok=True)
    report_path.write_text(summary_content)
    summary = os.environ.get("GITHUB_STEP_SUMMARY")
    if summary:
        with open(summary, "a") as stream:
            stream.write(summary_content)
    results = report.get("ptest_results", {})
    failed = [
        recipe for recipe, result in results.items()
        if result.get("status") == "failed"
    ]
    pending = [
        recipe for recipe, result in results.items()
        if result.get("status") == "pending"
    ]
    print(
        f"Dependency ptests: {len(results) - len(failed) - len(pending)} passed, "
        f"{len(failed)} failed, {len(pending)} pending"
        + (f" ({', '.join(sorted(failed + pending))})" if failed or pending else ""),
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
        "ptest_environment": report.get("ptest_environment"),
        "image_validation": report.get("image_validation"),
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
        validate_image(repo, setup, state, report)
    report["results"][stage] = "passed"
    write_json(state / "run.json", report)


def main() -> None:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument(
        "stage",
        choices=("acquire", "plan", "prepare", "ptests", "image", "finish", "release"),
    )
    parser.add_argument("--state-root", type=Path, required=True)
    args = parser.parse_args()
    try:
        execute(args.stage, Path(__file__).resolve().parent.parent, args.state_root.resolve())
    except (subprocess.CalledProcessError, RuntimeError, OSError) as error:
        if isinstance(error, subprocess.CalledProcessError):
            for output in (error.stdout, error.stderr):
                if output:
                    print(output.decode(errors="replace") if isinstance(output, bytes) else output,
                          file=sys.stderr, flush=True)
        print(f"CI {args.stage} failed: {error}", file=sys.stderr, flush=True)
        raise SystemExit(1) from None


if __name__ == "__main__":
    main()
