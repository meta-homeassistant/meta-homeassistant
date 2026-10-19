#!/usr/bin/env python3
"""Incremental image validation against the last successfully tested inputs."""

import argparse
import fcntl
import hashlib
import json
import os
from pathlib import Path
import subprocess
import sys
import tempfile


POLICY = 1
CONFIGURATION = "homeassistant-x86"
TARGET = "core-image-homeassistant-full"
TEST_FRAGMENTS = (
    "homeassistant/enable-testing-base",
    "homeassistant/add-homeassistant-image-test-deps",
)


def git(repo: Path, *args: str) -> str:
    return subprocess.check_output(
        ["git", "-C", str(repo), *args], text=True, stderr=subprocess.DEVNULL
    ).strip()


def is_ancestor(repo: Path, older: str, newer: str) -> bool:
    result = subprocess.run(
        ["git", "-C", str(repo), "merge-base", "--is-ancestor", older, newer],
        check=False,
    )
    if result.returncode not in (0, 1):
        result.check_returncode()
    return result.returncode == 0


def has_commit(repo: Path, revision: str) -> bool:
    result = subprocess.run(
        ["git", "-C", str(repo), "cat-file", "-e", f"{revision}^{{commit}}"],
        check=False, stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL,
    )
    return result.returncode == 0


def checkout_revision(repo: Path) -> str:
    if git(repo, "status", "--porcelain", "--untracked-files=no", "--ignore-submodules"):
        raise RuntimeError("CI requires a clean tracked Home Assistant checkout")
    return git(repo, "rev-parse", "HEAD")


def write_json(path: Path, value: dict) -> None:
    # The temporary file must share the destination filesystem for atomic replace.
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


def read_baseline(path: Path) -> dict | None:
    if not path.exists():
        return None
    try:
        value = json.loads(path.read_text())
    except json.JSONDecodeError:
        print("Invalid baseline; complete validation required.", flush=True)
        return None
    if not isinstance(value, dict):
        print("Invalid baseline object; complete validation required", flush=True)
        return None
    return value


def plan(repo: Path, baseline: dict | None, current: dict, force: bool = False) -> dict:
    result = {"mode": "validate", "reason": "", "changed_files": []}
    if not baseline:
        result["reason"] = "No validated baseline"
    elif any(baseline.get(key) != current[key] for key in ("policy", "scope")):
        result["reason"] = "Baseline scope or validation policy changed"
    elif not isinstance(baseline.get("revision"), str) or not has_commit(repo, baseline["revision"]):
        result["reason"] = "Validated commit unavailable"
    elif not is_ancestor(repo, baseline["revision"], current["revision"]):
        result["reason"] = "History diverged from validated baseline"
    else:
        changed = subprocess.check_output(
            ["git", "-C", str(repo), "diff", "--name-only", "-z",
             baseline["revision"], current["revision"]]
        ).decode().split("\0")
        result["changed_files"] = [name for name in changed if name]
        if force:
            result["reason"] = "Scheduled or manually requested validation"
        elif baseline.get("inputs") != current["inputs"]:
            result["reason"] = "Resolved sources, build configuration or builder changed"
        elif any(not documentation_only(name) for name in result["changed_files"]):
            result["reason"] = "Build, test or unclassified files changed since validation"
        else:
            result["mode"] = "skip"
            result["reason"] = "Only documentation/editor changes or already validated inputs"
    return result


def documentation_only(name: str) -> bool:
    return (
        name in ("README.md", "COPYING.MIT")
        or name.startswith(".vscode/")
        or (name.startswith("docs/") and Path(name).suffix in (".md", ".rst"))
    )


def reject_stale_run(repo: Path, baseline: dict | None, revision: str, ref: str) -> None:
    if baseline and isinstance(baseline.get("revision"), str):
        previous = baseline["revision"]
        if previous != revision and has_commit(repo, previous) and is_ancestor(repo, revision, previous):
            tip = git(repo, "ls-remote", "--exit-code", "origin", ref).split()[0]
            if tip != revision:
                raise RuntimeError("Superseded run: a descendant has already been validated")


def snapshot(repo: Path, setup: Path, bootstrap: Path, builder: str) -> dict:
    fixed = json.loads((setup / "config/sources-fixed-revisions.json").read_text())
    revisions = {}
    for name, source in sorted(fixed["sources"].items()):
        path = setup / "layers" / source.get("path", name)
        if name == "meta-homeassistant":
            if path.resolve() != repo:
                raise RuntimeError("Wrapper is not using this Home Assistant checkout")
            continue
        if git(path, "status", "--porcelain", "--untracked-files=no"):
            raise RuntimeError(f"Dependency checkout has tracked modifications: {name}")
        revisions[name] = git(path, "rev-parse", "HEAD")
        expected = source.get("git-remote", {}).get("rev")
        if expected and expected != revisions[name]:
            raise RuntimeError(f"Resolved revision does not match checkout: {name}")
    conf = {
        str(path.relative_to(setup / "build/conf")): hashlib.sha256(path.read_bytes()).hexdigest()
        for path in sorted((setup / "build/conf").rglob("*"))
        if path.is_file()
    }
    return {
        "sources": revisions,
        "bootstrap": git(bootstrap, "rev-parse", "HEAD"),
        "configuration": conf,
        "builder": builder,
        "os_release": hashlib.sha256(Path("/etc/os-release").read_bytes()).hexdigest(),
    }


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
    )
    setup = top / CONFIGURATION
    command = [
        str(bootstrap / "bin/bitbake-setup"),
        "--setting", "default", "top-dir-prefix", str(state),
        "--setting", "default", "dl-dir", "/cache/downloads/",
    ]
    if (setup / "layers").exists():
        command += ["update", "--setup-dir", str(setup), "--update-bb-conf", "yes"]
    else:
        command += [
            "init", "--non-interactive", "--setup-dir-name", CONFIGURATION,
            str(config_path), CONFIGURATION,
        ]
    run_quietly(command, "Build configuration setup", cwd=repo)
    if not (setup / "build/init-build-env").is_file():
        raise RuntimeError("Build configuration setup did not create an environment.")
    return setup


def run_quietly(command: list[str], stage: str, cwd: Path | None = None) -> None:
    with tempfile.TemporaryFile(mode="w+t", encoding="utf-8", errors="replace") as output:
        result = subprocess.run(
            command, cwd=cwd, stdout=output, stderr=subprocess.STDOUT,
            text=True, check=False,
        )
    if result.returncode:
        raise RuntimeError(f"{stage} failed (exit code {result.returncode}).")


def validate(repo: Path, setup: Path) -> None:
    command = [
        "bash", "-c",
        'set -eo pipefail; readonly ci_image_target="$2"; source "$1"; bitbake "$ci_image_target"',
        "ci-validate", str(setup / "build/init-build-env"), TARGET,
    ]
    print(f"Building and testing image target {TARGET}.", flush=True)
    result = subprocess.run(command, cwd=repo, check=False)
    if result.returncode:
        raise subprocess.CalledProcessError(result.returncode, TARGET)


def record_result(path: Path, report: dict, result: str) -> None:
    report["result"] = result
    write_json(path, report)
    print(
        f"Image validation {result}: {report['mode']} ({report['reason']}); target {TARGET}.",
        flush=True,
    )
    summary = os.environ.get("GITHUB_STEP_SUMMARY")
    if summary:
        with open(summary, "a") as stream:
            stream.write(
                f"## Home Assistant image validation: {result}\n\n"
                f"- Mode: {report['mode']}\n"
                f"- Reason: {report['reason']}\n"
                f"- Target: `{TARGET}`\n"
            )


def run(repo: Path, state_root: Path, scope: dict, run_id: str, builder: str, force: bool) -> None:
    state_root.mkdir(parents=True, exist_ok=True)
    # All cooperating CI runs share this lock, including baseline promotion.
    with (state_root / "validation.lock").open("a") as lock:
        print("Waiting for the CI validation lock", flush=True)
        fcntl.flock(lock, fcntl.LOCK_EX)
        key = hashlib.sha256(json.dumps(scope, sort_keys=True).encode()).hexdigest()
        state = state_root / key
        state.mkdir(exist_ok=True)
        baseline_path = state / "validated.json"
        baseline = read_baseline(baseline_path)
        revision = checkout_revision(repo)
        reject_stale_run(repo, baseline, revision, scope["ref"])
        with tempfile.TemporaryDirectory(prefix="ha-ci-bitbake-") as temporary:
            bootstrap = Path(temporary) / "bitbake"
            run_quietly(
                ["git", "clone", "--quiet", "--depth", "1",
                 "https://git.openembedded.org/bitbake", str(bootstrap)],
                "BitBake bootstrap checkout",
            )
            setup = prepare(repo, state, bootstrap)
            scope_id = hashlib.sha256(json.dumps(scope, sort_keys=True).encode()).hexdigest()
            current = {
                "policy": POLICY, "scope": scope_id, "revision": revision,
                "test_fragments": list(TEST_FRAGMENTS),
                "inputs": snapshot(repo, setup, bootstrap, builder),
            }
            decision = plan(repo, baseline, current, force)
            report = {
                "mode": decision["mode"],
                "reason": decision["reason"],
                "result": "planned",
            }
            reports = state / "reports"
            reports.mkdir(exist_ok=True)
            report_path = reports / f"{hashlib.sha256(run_id.encode()).hexdigest()}.json"
            write_json(report_path, report)
            print(
                f"Validation plan: {decision['mode']} ({decision['reason']}); target {TARGET}.",
                flush=True,
            )
            if decision["mode"] == "skip":
                record_result(report_path, report, "not-required")
                print("Image baseline unchanged; no build required", flush=True)
                return
            try:
                validate(repo, setup)
                if (checkout_revision(repo) != revision
                        or snapshot(repo, setup, bootstrap, builder) != current["inputs"]):
                    raise RuntimeError("Build inputs changed during validation; baseline not advanced")
            except (subprocess.CalledProcessError, RuntimeError):
                record_result(report_path, report, "failed")
                raise
            record_result(report_path, report, "passed")
            write_json(baseline_path, current)
            print("Validated image baseline advanced.", flush=True)


def main() -> None:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--state-root", type=Path, required=True)
    args = parser.parse_args()
    scope = {
        "repository": os.environ["CI_REPOSITORY"],
        "ref": os.environ["CI_REF"],
        "configuration": CONFIGURATION,
    }
    try:
        run(
            Path(__file__).resolve().parent.parent, args.state_root.resolve(),
            scope, os.environ["CI_RUN_ID"], os.environ["CI_BUILDER_ID"],
            os.environ["CI_EVENT"] != "push",
        )
    except subprocess.CalledProcessError as error:
        print(f"Validation failed (exit code {error.returncode}).", file=sys.stderr, flush=True)
        raise SystemExit(error.returncode) from None
    except RuntimeError as error:
        print(f"Validation could not complete: {error}", file=sys.stderr, flush=True)
        raise SystemExit(1) from None
    except OSError:
        print("Validation could not complete because of a runner I/O error.",
              file=sys.stderr, flush=True)
        raise SystemExit(1) from None


if __name__ == "__main__":
    main()
