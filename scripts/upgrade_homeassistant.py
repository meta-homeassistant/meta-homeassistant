#!/usr/bin/env python3
"""Stage, reconcile, and validate a Core upgrade without finishing recipes.

The caller selects the existing build wrapper and image; machine-specific boot
policy belongs in layer metadata, not this script. Each gate stops on failure
and leaves staged work available for inspection and a compatible rerun.
"""

from __future__ import annotations

import argparse
import codecs
import datetime as dt
import difflib
import json
import locale
import re
import shlex
import shutil
import signal
import subprocess
import sys
import tomllib
from dataclasses import dataclass, field
from pathlib import Path
from typing import Callable, Sequence
from urllib.parse import urlsplit

from packaging.requirements import InvalidRequirement, Requirement
from packaging.version import InvalidVersion, Version

try:
    from .integration_inventory import build_report, parse_layer_metadata, read_upstream_integrations
except ImportError:
    from integration_inventory import build_report, parse_layer_metadata, read_upstream_integrations


LAYER_ROOT = Path(__file__).resolve().parents[1]
CORE_RECIPE = "python3-homeassistant"
DEFAULT_CORE_PTEST_RUNQEMU_ARGS = ("slirp", "snapshot", "nographic")
CORE_SOURCE_RELATIVE = Path("build/workspace/sources/python3-homeassistant")
CORE_RECIPE_RELATIVE = Path("build/workspace/recipes/python3-homeassistant")
CORE_RECIPE_FILES_RELATIVE = Path("python3-homeassistant")
INTEGRATION_METADATA_FILES = ("integrations.inc", "integrations-tests.inc")
# Preserve layer-specific dependencies that upstream Python requirements omit.
CORE_LOCAL_RUNTIME = {"python3-statistics"}
CORE_LOCAL_PTEST = {"python3-go2rtc-client"}
# The ptest class supplies pytest; development tooling is not test runtime.
# Astroid/Pylint remain eligible because Core's tests/pylint uses them.
PTEST_FRAMEWORK_PACKAGES = {"python3-pytest"}
PTEST_EXCLUDED_PACKAGES = {
    "librt",
    "mypy",
    "prek",
    "pipdeptree",
    "pytest-github-actions-annotate-failures",
}


@dataclass
class RecipeStatus:
    devtool_upgrade: str = "not required"
    compilation: str = "not run"
    ptest_present: str = "not checked"
    ptest_passed: str = "not run"


@dataclass
class RunLog:
    release: str
    revision: str = ""
    planned_actions: list[str] = field(default_factory=list)
    commands: list[dict[str, object]] = field(default_factory=list)
    outcomes: list[str] = field(default_factory=list)
    open_tasks: list[str] = field(default_factory=list)
    manual_actions: list[str] = field(default_factory=list)
    recipe_status: dict[str, RecipeStatus] = field(default_factory=dict)

    def recipe(self, name: str) -> RecipeStatus:
        if name not in self.recipe_status:
            self.recipe_status[name] = RecipeStatus()
        return self.recipe_status[name]

    def record(self, label: str, command: Sequence[str], result: subprocess.CompletedProcess[str]) -> None:
        # Successful commands are summarized by outcomes; retain bounded failure
        # transcripts so a large BitBake log cannot swamp the review report.
        if result.returncode == 0:
            return
        output = result.stdout or ""
        if len(output) > 40000:
            output = (
                output[:4000]
                + "\n... output truncated; retaining beginning and final diagnostics ...\n"
                + output[-36000:]
            )
        self.commands.append(
            {
                "label": label,
                "command": shlex.join(command),
                "returncode": result.returncode,
                "output": output,
            }
        )

    def render(self) -> str:
        lines = [
            f"# Home Assistant upgrade run: {self.release}",
            "",
            f"Timestamp: `{dt.datetime.now().astimezone().isoformat(timespec='seconds')}`",
            f"Source commit: `{self.revision or 'unresolved'}`",
            "",
        ]
        lines.extend(f"- {outcome}" for outcome in self.outcomes)
        lines.extend(["", "## Planned actions", ""])
        if self.planned_actions:
            lines.extend(f"- {action}" for action in self.planned_actions)
        else:
            lines.append("- No actions were planned before the workflow stopped.")
        lines.extend(["", "## Open tasks requiring attention", ""])
        if self.open_tasks:
            lines.extend(f"- {task}" for task in sorted(set(self.open_tasks)))
        else:
            lines.append("- None")
        lines.extend(
            [
                "",
                "## Recipe Validation Summary",
                "",
                "| Recipe or target | devtool upgrade | compilation | ptest present | ptest passed |",
                "| --- | --- | --- | --- | --- |",
            ]
        )
        if self.recipe_status:
            for name, status in sorted(self.recipe_status.items()):
                cells = (
                    name,
                    status.devtool_upgrade,
                    status.compilation,
                    status.ptest_present,
                    status.ptest_passed,
                )
                escaped = [str(cell).replace("|", "\\|").replace("\n", " ") for cell in cells]
                lines.append("| " + " | ".join(escaped) + " |")
        else:
            lines.append("| None | - | - | - | - |")
        lines.extend(["", "## Manual Finish After Review", ""])
        if self.manual_actions:
            lines.append("The workflow did not execute these commands:")
            lines.extend(f"- `{action}`" for action in self.manual_actions)
        else:
            lines.append("- Not ready; validation has not completed successfully.")
        lines.extend(["", "## Completed steps", ""])
        completed = [outcome for outcome in self.outcomes if outcome.startswith("Completed:")]
        lines.extend(f"- {step.removeprefix('Completed: ').strip()}" for step in completed)
        if not completed:
            lines.append("- None")
        for entry in self.commands:
            lines.extend(
                [
                    "",
                    f"## {entry['label']} (exit {entry['returncode']})",
                    "",
                    f"`{entry['command']}`",
                    "",
                    "```text",
                    str(entry["output"]).rstrip(),
                    "```",
                ]
            )
        return "\n".join(lines).rstrip() + "\n"


CommandRunner = Callable[[str, Sequence[str], Path], subprocess.CompletedProcess[str]]


class WorkflowBlocked(RuntimeError):
    def __init__(self, phase: str, blockers: Sequence[str]):
        self.phase = phase
        self.blockers = list(blockers)
        super().__init__(f"{phase} stopped: " + "; ".join(self.blockers))


def _stop_if_blocked(blockers: Sequence[str], phase: str) -> None:
    if blockers:
        raise WorkflowBlocked(phase, blockers)


def _run(command: str, args: Sequence[str], cwd: Path) -> subprocess.CompletedProcess[str]:
    process_args = [command, *args]
    process = subprocess.Popen(
        process_args,
        cwd=cwd,
        stdout=subprocess.PIPE,
        stderr=subprocess.STDOUT,
    )
    output: list[str] = []
    decoder = codecs.getincrementaldecoder(locale.getencoding())()
    try:
        if process.stdout is not None:
            with process.stdout:
                # Preserve CR and ANSI updates from pseudo-terminal helpers.
                while chunk := process.stdout.read1(65536):
                    text = decoder.decode(chunk)
                    sys.stdout.write(text)
                    sys.stdout.flush()
                    output.append(text)
                tail = decoder.decode(b"", final=True)
                if tail:
                    sys.stdout.write(tail)
                    sys.stdout.flush()
                    output.append(tail)
        returncode = process.wait()
    except KeyboardInterrupt:
        if process.poll() is None:
            process.send_signal(signal.SIGINT)
            try:
                process.wait(timeout=10)
            except subprocess.TimeoutExpired:
                process.kill()
                process.wait()
        raise
    return subprocess.CompletedProcess(process_args, returncode, "".join(output))


def _run_in_setup(
    setup_dir: Path,
    command: str,
    runner: CommandRunner,
    quiet_success: bool = False,
) -> subprocess.CompletedProcess[str]:
    init_script = setup_dir / "build/init-build-env"
    print(f"\n[wrapper] {command}", flush=True)
    if quiet_success:
        command = (
            'output_file=$(mktemp) || exit $?; '
            'trap \'rm -f "$output_file"\' EXIT; '
            f'{command} >"$output_file" 2>&1; '
            'status=$?; '
            'if [ "$status" -ne 0 ]; then cat "$output_file"; fi; '
            'exit "$status"'
        )
    shell_command = f"source {shlex.quote(str(init_script))} >/dev/null && {command}"
    return runner("bash", ["-lc", shell_command], setup_dir / "build")


def _git_output(args: Sequence[str], cwd: Path, runner: CommandRunner) -> str:
    result = runner("git", args, cwd)
    if result.returncode:
        raise RuntimeError((result.stdout or "git command failed").strip())
    return (result.stdout or "").strip()


def resolve_release_commit(release: str, cwd: Path, runner: CommandRunner) -> str:
    refs = _git_output(
        [
            "ls-remote",
            "https://github.com/home-assistant/core.git",
            f"refs/tags/{release}",
            f"refs/tags/{release}^{{}}",
        ],
        cwd,
        runner,
    )
    revisions = [line.split()[0] for line in refs.splitlines() if line.split()]
    if not revisions:
        raise RuntimeError(f"Home Assistant release tag not found: {tag}")
    return revisions[-1]


def _ensure_fresh_artifacts(layer_dir: Path, release: str) -> tuple[Path, Path]:
    safe_release = re.sub(r"[^A-Za-z0-9._+-]", "_", release)
    report_path = layer_dir / f"integration-summary-{safe_release}.md"
    log_path = layer_dir / "upgrade-logs" / f"{safe_release}.md"
    return report_path, log_path


def _prepare_run_log(log_path: Path) -> None:
    # The path is reserved at startup, not a completion marker. run_upgrade's
    # finally block writes the terminal result, including handled interruptions.
    log_path.parent.mkdir(parents=True, exist_ok=True)
    if log_path.exists():
        log_path.unlink()
    log_path.touch()


def _upgrade_state_path(setup_dir: Path, release: str) -> Path:
    safe_release = re.sub(r"[^A-Za-z0-9._+-]", "_", release)
    return setup_dir / "build/workspace" / f".ha-upgrade-{safe_release}.json"


def _load_upgrade_state(setup_dir: Path, release: str) -> dict[str, object]:
    path = _upgrade_state_path(setup_dir, release)
    if not path.is_file():
        return {"release": release, "staged_dependencies": {}}
    state = json.loads(path.read_text(encoding="utf-8"))
    if state.get("release") != release:
        raise RuntimeError(f"Upgrade state release mismatch in {path}")
    state.setdefault("staged_dependencies", {})
    return state


def _save_upgrade_state(setup_dir: Path, release: str, state: dict[str, object]) -> None:
    path = _upgrade_state_path(setup_dir, release)
    path.parent.mkdir(parents=True, exist_ok=True)
    # Replace atomically so an interrupted write cannot corrupt resume state.
    temporary_path = path.with_suffix(".tmp")
    temporary_path.write_text(json.dumps(state, indent=2, sort_keys=True) + "\n", encoding="utf-8")
    temporary_path.replace(path)


def _staged_integration_metadata_paths(setup_dir: Path) -> tuple[Path, Path]:
    metadata_dir = setup_dir / CORE_RECIPE_RELATIVE / CORE_RECIPE_FILES_RELATIVE
    paths = tuple(metadata_dir / name for name in INTEGRATION_METADATA_FILES)
    missing = [str(path) for path in paths if not path.is_file()]
    if missing:
        raise RuntimeError(
            "The devtool workspace is missing copied integration metadata: " + ", ".join(missing)
        )
    return paths


def _redirect_staged_integration_requires(recipe_path: Path) -> str:
    # BBPATH-based requires would still read the original layer includes rather
    # than devtool's copied files, silently ignoring staged reconciliation.
    recipe_text = recipe_path.read_text(encoding="utf-8")
    original = recipe_text
    for name in INTEGRATION_METADATA_FILES:
        pattern = re.compile(rf"(?m)^require\s+.*{re.escape(name)}\s*$")
        matches = list(pattern.finditer(recipe_text))
        if len(matches) != 1:
            raise RuntimeError(
                f"Expected one require for staged {name} in {recipe_path}, found {len(matches)}"
            )
        replacement = f"require ${{THISDIR}}/{CORE_RECIPE_FILES_RELATIVE.as_posix()}/{name}"
        match = matches[0]
        recipe_text = recipe_text[: match.start()] + replacement + recipe_text[match.end() :]
    if recipe_text != original:
        recipe_path.write_text(recipe_text, encoding="utf-8")
    return original


def _verify_local_source_mapping(layer_dir: Path) -> None:
    for candidate in layer_dir.parents:
        mapping_path = candidate / "configurations/local-sources.json"
        if not mapping_path.is_file():
            continue
        mapping = json.loads(mapping_path.read_text(encoding="utf-8"))
        layer_mapping = mapping.get("sources", {}).get("meta-homeassistant", {}).get("local", {})
        mapped_path = layer_mapping.get("path")
        if not mapped_path:
            raise RuntimeError(f"meta-homeassistant has no local source mapping in {mapping_path}")
        resolved_mapping = (mapping_path.parent / mapped_path).resolve()
        if resolved_mapping != layer_dir.resolve():
            raise RuntimeError(
                f"meta-homeassistant mapping in {mapping_path} resolves to {resolved_mapping}, "
                f"not selected layer {layer_dir}"
            )
        return


def _parse_active_recipe_versions(output: str) -> dict[str, str]:
    versions: dict[str, str] = {}
    for line in output.splitlines():
        fields = line.split()
        if len(fields) >= 2 and fields[0].startswith("python3-"):
            version = fields[1].lstrip(":")
            version = re.sub(r"-r\d+$", "", version)
            versions[fields[0]] = version
    return versions


def _parse_devtool_workspace_recipes(output: str) -> set[str]:
    recipes = set()
    for line in output.splitlines():
        match = re.match(r"^\s*([A-Za-z0-9][A-Za-z0-9_.+-]*):\s+\S", line)
        if match and match.group(1) not in {"NOTE", "WARNING", "DEBUG"}:
            recipes.add(match.group(1))
    return recipes


def _requirement_floor(raw_requirement: str) -> tuple[str, str]:
    try:
        requirement = Requirement(raw_requirement)
    except InvalidRequirement as error:
        raise ValueError(f"Unsupported Home Assistant requirement {raw_requirement!r}: {error}") from error
    if requirement.marker is not None or requirement.url is not None:
        raise ValueError(f"Conditional or direct-URL requirement needs review: {raw_requirement}")
    normalized_name = re.sub(r"[-_.]+", "-", requirement.name).lower()
    package = f"python3-{normalized_name}"
    floors = []
    for specifier in requirement.specifier:
        if specifier.operator in {">=", ">", "==", "~="}:
            try:
                floors.append(Version(specifier.version))
            except InvalidVersion as error:
                raise ValueError(f"Unsupported version in requirement {raw_requirement!r}") from error
        elif specifier.operator not in {"<", "<=", "!="}:
            raise ValueError(f"Unsupported version operator in requirement {raw_requirement!r}")
    floor = str(max(floors)) if floors else ""
    return package, floor


def _read_test_requirements(source_dir: Path) -> list[str]:
    requirements = []
    for raw_line in (source_dir / "requirements_test.txt").read_text(encoding="utf-8").splitlines():
        line = raw_line.strip()
        if not line or line.startswith("#") or line.startswith(("-r ", "-c ")):
            continue
        requirements.append(line)
    return requirements


def _reconcile_core_recipe(
    recipe_path: Path,
    source_dir: Path,
    active_recipes: dict[str, str],
) -> list[str]:
    recipe_text = recipe_path.read_text(encoding="utf-8")
    project = tomllib.loads((source_dir / "pyproject.toml").read_text(encoding="utf-8"))["project"]
    python_requirement = Requirement(f"python{project['requires-python']}")
    core_floors = []
    for specifier in python_requirement.specifier:
        if specifier.operator in {">=", ">", "==", "~="}:
            core_floors.append(Version(specifier.version))
    if not core_floors:
        raise ValueError("requires-python has no supported minimum version")
    python_floor = str(max(core_floors))

    runtime: dict[str, str] = {}
    test: dict[str, str] = {}
    runtime_sources: dict[str, str] = {}
    test_sources: dict[str, str] = {}
    blockers: list[str] = []
    for raw_requirement in project.get("dependencies", []):
        package, floor = _requirement_floor(raw_requirement)
        runtime[package] = floor
        runtime_sources[package] = f"pyproject.toml dependency {raw_requirement!r}"

    precommit_path = source_dir / "requirements_test_pre_commit.txt"
    precommit_names = set()
    if precommit_path.exists():
        for raw_line in precommit_path.read_text(encoding="utf-8").splitlines():
            line = raw_line.strip()
            if line and not line.startswith(("#", "-")):
                precommit_names.add(_requirement_floor(line)[0])
    for raw_requirement in _read_test_requirements(source_dir):
        package, floor = _requirement_floor(raw_requirement)
        distribution_name = package.removeprefix("python3-")
        if (
            package in precommit_names
            or package in PTEST_FRAMEWORK_PACKAGES
            or distribution_name.startswith("types-")
            or distribution_name in PTEST_EXCLUDED_PACKAGES
        ):
            continue
        test[package] = floor
        test_sources[package] = f"requirements_test.txt entry {raw_requirement!r}"

    runtime.update({package: "" for package in CORE_LOCAL_RUNTIME})
    test.update({package: "" for package in CORE_LOCAL_PTEST})
    for package in runtime:
        if package not in CORE_LOCAL_RUNTIME and package not in active_recipes:
            source = runtime_sources.get(package, "Core runtime requirements")
            blockers.append(f"{source} maps to {package}, but no exact active recipe provider exists")
    for package in test:
        if package not in CORE_LOCAL_PTEST and package not in active_recipes:
            source = test_sources.get(package, "Core ptest requirements")
            blockers.append(f"{source} maps to {package}, but no exact active recipe provider exists")

    def replace_block(pattern: str, lines: list[str], label: str) -> None:
        nonlocal recipe_text
        match = re.search(pattern, recipe_text, re.DOTALL | re.MULTILINE)
        if not match:
            raise ValueError(f"Could not locate {label} dependency block in staged Core recipe")
        body = "".join(
            f"    {package}{f' (>={floor})' if floor else ''} \\\n"
            for package, floor in sorted(lines)
        )
        recipe_text = recipe_text[: match.start(1)] + body + recipe_text[match.end(1) :]

    runtime["python3-core"] = python_floor
    replace_block(r'RDEPENDS:\$\{PN\}\s*\+=\s*"\\\n(.*?)^"', list(runtime.items()), "runtime")
    preserved_ptest_lines = []
    ptest_match = re.search(
        r'RDEPENDS:\$\{PN\}-ptest\s*=\s*"\\\n(.*?)^"',
        recipe_text,
        re.DOTALL | re.MULTILINE,
    )
    if not ptest_match:
        raise ValueError("Could not locate Core ptest dependency block")
    for line in ptest_match.group(1).splitlines():
        stripped = line.strip().rstrip("\\").strip()
        if stripped and not stripped.startswith("python3-"):
            preserved_ptest_lines.append(stripped)
    ptest_lines = [
        (package, floor) for package, floor in test.items()
    ]
    ptest_body = "".join(
        f"    {package}{f' (>={floor})' if floor else ''} \\\n"
        for package, floor in sorted(ptest_lines)
    )
    ptest_body += "".join(f"    {line} \\\n" for line in preserved_ptest_lines)
    recipe_text = recipe_text[: ptest_match.start(1)] + ptest_body + recipe_text[ptest_match.end(1) :]
    recipe_path.write_text(recipe_text, encoding="utf-8")
    return sorted(set(blockers))


def _remove_removed_integrations(
    integrations_path: Path,
    tests_path: Path,
    image_integrations_path: Path,
    upstream_domains: set[str],
) -> list[str]:
    integrations_text = integrations_path.read_text(encoding="utf-8")
    supported, _, _ = parse_layer_metadata(integrations_text, "")
    image_integrations_text = image_integrations_path.read_text(encoding="utf-8")
    image_domains = {
        match.group(1).replace("-", "_")
        for match in re.finditer(
            r"(?m)^[ \t]*python3-homeassistant-([a-z0-9][a-z0-9-]*)[ \t]*\\?[ \t]*$",
            image_integrations_text,
        )
    }
    # A resumed workspace may already have lost the Core entries while the
    # image still requests them. Such requests can select an older Core recipe.
    removed = (supported | image_domains) - upstream_domains
    if not removed:
        return []

    integrations_match = re.search(
        r'(?m)^INTEGRATIONS\s*=\s*"\\\n(.*?)^"',
        integrations_text,
        re.DOTALL,
    )
    if not integrations_match:
        raise ValueError("Could not locate the INTEGRATIONS package list")

    def remove_integration_package(match: re.Match[str]) -> str:
        domain = match.group(1).replace("-", "_")
        return "" if domain in removed else match.group(0)

    body = re.sub(
        r"(?m)^[ \t]*\$\{PN\}-([a-z0-9][a-z0-9-]*)[ \t]*\\?[ \t]*\n?",
        remove_integration_package,
        integrations_match.group(1),
    )
    integrations_text = (
        integrations_text[: integrations_match.start(1)]
        + body
        + integrations_text[integrations_match.end(1) :]
    )

    def is_removed_metadata(match: re.Match[str]) -> bool:
        return match.group(1).replace("-", "_") in removed

    integrations_text = re.sub(
        r'(?m)^[ \t]*RDEPENDS:\$\{PN\}-([a-z0-9][a-z0-9-]*)\s*=\s*"\\\n.*?^"[ \t]*(?:\n|$)',
        lambda match: "" if is_removed_metadata(match) else match.group(0),
        integrations_text,
        flags=re.DOTALL,
    )
    integrations_text = re.sub(
        r'(?m)^[ \t]*ALLOW_EMPTY:\$\{PN\}-([a-z0-9][a-z0-9-]*)\s*=\s*"[^\n]*"(?:\n|$)',
        lambda match: "" if is_removed_metadata(match) else match.group(0),
        integrations_text,
    )

    tests_text = tests_path.read_text(encoding="utf-8")
    tests_text = re.sub(
        r"(?m)^[ \t]*\$\{PN\}-([a-z0-9][a-z0-9-]*)[ \t]*\\?[ \t]*\n?",
        remove_integration_package,
        tests_text,
    )
    image_integrations_text = re.sub(
        r"(?m)^[ \t]*python3-homeassistant-([a-z0-9][a-z0-9-]*)[ \t]*\\?[ \t]*\n?",
        lambda match: (
            ""
            if match.group(1).replace("-", "_") in removed
            else match.group(0)
        ),
        image_integrations_text,
    )

    # Core/test includes stay in devtool; the image consumes a separate layer
    # include, so that file must be edited directly and included in review.
    integrations_path.write_text(integrations_text, encoding="utf-8")
    tests_path.write_text(tests_text, encoding="utf-8")
    image_integrations_path.write_text(image_integrations_text, encoding="utf-8")
    return sorted(removed)


def _replace_integration_dependencies(
    integrations_path: Path,
    upstream: dict[str, dict[str, str]],
    supported: set[str],
    active_recipes: dict[str, str],
) -> list[str]:
    text = integrations_path.read_text(encoding="utf-8")
    _, current_dependencies, _ = parse_layer_metadata(text, "")
    blockers: list[str] = []
    blocks = list(
        re.finditer(
            r'(?m)^RDEPENDS:\$\{PN\}-([a-z0-9][a-z0-9-]*)\s*=\s*"\\\n(.*?)^"',
            text,
            re.DOTALL,
        )
    )
    replacements: list[tuple[int, int, str]] = []
    found_domains: set[str] = set()
    for match in blocks:
        domain = match.group(1).replace("-", "_")
        if domain not in supported or domain not in upstream:
            continue
        found_domains.add(domain)
        # Dependencies are per-integration: another domain using a package does
        # not justify keeping it here once this manifest stops requiring it.
        current_domain_dependencies = current_dependencies.get(domain, {})
        dependencies: dict[str, str] = {}
        for recipe, required_version in upstream[domain].items():
            current_spec = current_domain_dependencies.get(recipe)
            if current_spec is None and recipe not in active_recipes:
                blockers.append(f"{domain} requires unavailable or aliased recipe {recipe}")
                continue
            if current_spec:
                match_spec = re.fullmatch(r"(?:>=|==|=|>)\s*(.+)", current_spec)
                if not match_spec:
                    blockers.append(f"Cannot safely reconcile {recipe} constraint {current_spec!r}")
                    continue
                try:
                    if Version(match_spec.group(1)) >= Version(required_version):
                        dependencies[recipe] = current_spec
                        continue
                except InvalidVersion:
                    blockers.append(f"Cannot compare {recipe} constraint {current_spec!r}")
                    continue
            dependencies[recipe] = f">={required_version}"

        body_lines = []
        for recipe, spec in sorted(dependencies.items()):
            body_lines.append(f"    {recipe} ({spec}) \\")
        replacement = "\n".join(body_lines) + ("\n" if body_lines else "")
        replacements.append((match.start(2), match.end(2), replacement))

    for domain in sorted(supported & upstream.keys() - found_domains):
        if upstream[domain]:
            blockers.append(f"{domain} needs a new dependency stanza; refusing implicit ownership creation")

    for start, end, replacement in reversed(replacements):
        text = text[:start] + replacement + text[end:]
    if replacements:
        integrations_path.write_text(text, encoding="utf-8")
    return sorted(set(blockers))


def _check_provider_versions(
    upstream: dict[str, dict[str, str]],
    supported: set[str],
    active_recipes: dict[str, str],
) -> list[str]:
    blockers = []
    checked: set[tuple[str, str]] = set()
    for domain in sorted(supported & upstream.keys()):
        for recipe, required in upstream[domain].items():
            key = (recipe, required)
            if key in checked or recipe not in active_recipes:
                continue
            checked.add(key)
            try:
                if Version(active_recipes[recipe]) < Version(required):
                    blockers.append(
                        f"{recipe} provider {active_recipes[recipe]} is below required {required}"
                    )
            except InvalidVersion:
                blockers.append(f"Cannot compare provider version for {recipe}: {active_recipes[recipe]}")
    return blockers


def _required_recipe_versions(
    upstream: dict[str, dict[str, str]],
    supported: set[str],
    core_recipe_path: Path,
) -> dict[str, str]:
    required: dict[str, str] = {}
    for domain in supported & upstream.keys():
        for recipe, version in upstream[domain].items():
            if version and (recipe not in required or Version(version) > Version(required[recipe])):
                required[recipe] = version
    for line in core_recipe_path.read_text(encoding="utf-8").splitlines():
        match = re.match(r"\s*(python3-[A-Za-z0-9_.+-]+)\s+\(>=\s*([^)]+)\)", line)
        if not match or match.group(1) == "python3-core":
            continue
        recipe, version = match.groups()
        if recipe not in required or Version(version) > Version(required[recipe]):
            required[recipe] = version
    return required


def _provider_plan_actions(
    required: dict[str, str],
    active_recipes: dict[str, str],
) -> list[str]:
    sufficient: list[str] = []
    below_floor: list[str] = []
    unresolved: list[str] = []
    for recipe, requested in sorted(required.items()):
        current = active_recipes.get(recipe)
        if current is None:
            unresolved.append(f"{recipe} (no exact active provider)")
            continue
        try:
            if Version(current) >= Version(requested):
                sufficient.append(recipe)
            else:
                below_floor.append(f"{recipe} ({current} -> {requested})")
        except InvalidVersion:
            unresolved.append(f"{recipe} (unparseable active version {current!r})")

    actions = [f"Inspect version floors for {len(required)} required dependency providers."]
    if sufficient:
        actions.append(
            f"Reuse {len(sufficient)} providers already meeting their version floors; "
            "resume compatible staged workspaces and compile staged providers."
        )
    if below_floor:
        actions.append(
            "Stage providers below their required version, in name order; stop at the first failure: "
            + ", ".join(below_floor)
            + "."
        )
    if unresolved:
        actions.append(
            "Resolve these providers before proceeding: " + ", ".join(unresolved) + "."
        )
    return actions


def _active_layer_paths(show_layers_output: str) -> list[Path]:
    paths = []
    for line in show_layers_output.splitlines():
        fields = line.split()
        path_field = next((field for field in fields if field.startswith("/")), None)
        if path_field:
            candidate = Path(path_field).resolve()
            if candidate.is_dir():
                paths.append(candidate)
    return sorted(set(paths), key=lambda path: len(str(path)), reverse=True)


def _resolve_provider_srcrev(
    recipe: str,
    requested: str,
    setup_dir: Path,
    runner: CommandRunner,
    log: RunLog,
) -> tuple[str | None, str | None]:
    def get_variable(name: str) -> str | None:
        command = (
            f"bitbake-getvar {name} --value --ignore-undefined "
            f"-r {shlex.quote(recipe)}"
        )
        result = _run_in_setup(setup_dir, command, runner)
        log.record(f"Read {name} for {recipe}", ["bash", "-lc", command], result)
        if result.returncode:
            return None
        return (result.stdout or "").strip()

    current_srcrev = get_variable("SRCREV")
    if current_srcrev is None:
        return None, f"Could not inspect SRCREV for {recipe}"
    if not current_srcrev or current_srcrev == "INVALID":
        return None, None

    source_uris = get_variable("SRC_URI")
    current_version = get_variable("PV")
    if source_uris is None or current_version is None:
        return None, f"Could not inspect Git source metadata for {recipe}"

    git_sources = []
    for source_uri in shlex.split(source_uris):
        source, separator, raw_parameters = source_uri.partition(";")
        if not source.startswith(("git://", "gitsm://")):
            continue
        parameters = {}
        if separator:
            for parameter in raw_parameters.split(";"):
                key, equals, value = parameter.partition("=")
                if equals:
                    parameters[key] = value
        git_sources.append((source, parameters))

    if len(git_sources) != 1:
        return None, f"Cannot safely resolve a single Git source and tag for {recipe}"
    source, parameters = git_sources[0]
    if source.startswith("gitsm://"):
        return None, f"Cannot safely resolve submodule source revision for {recipe}"
    parsed_source = urlsplit(source)
    protocol = parameters.get("protocol")
    if parsed_source.username or parsed_source.password or protocol != "https":
        return None, f"Cannot safely query non-HTTPS Git source for {recipe}"
    tag = parameters.get("tag")
    if not tag or current_version not in tag:
        return None, f"Cannot derive the requested Git tag for {recipe} from SRC_URI"
    requested_tag = tag.replace(current_version, requested)
    if requested_tag == tag or any(character.isspace() for character in requested_tag):
        return None, f"Cannot derive a safe requested Git tag for {recipe}"

    repository = f"https://{parsed_source.netloc}{parsed_source.path}"
    tag_ref = f"refs/tags/{requested_tag}"
    result = runner(
        "git",
        ["ls-remote", repository, tag_ref, f"{tag_ref}^{{}}"],
        setup_dir,
    )
    log.record(
        f"Resolve upstream revision for {recipe}",
        ["git", "ls-remote", repository, tag_ref, f"{tag_ref}^{{}}"],
        result,
    )
    if result.returncode:
        return None, f"Could not query upstream Git tag {requested_tag} for {recipe}"

    revisions = {}
    for line in (result.stdout or "").splitlines():
        fields = line.split()
        if len(fields) == 2 and fields[1] in {tag_ref, f"{tag_ref}^{{}}"}:
            revisions[fields[1]] = fields[0]
    revision = revisions.get(f"{tag_ref}^{{}}", revisions.get(tag_ref))
    if revision is None or not re.fullmatch(r"[0-9a-fA-F]{40,64}", revision):
        return None, f"Upstream Git tag {requested_tag} did not resolve to a commit for {recipe}"

    log.outcomes.append(
        f"Resolved {recipe} version {requested} to upstream tag {requested_tag} at {revision}."
    )
    return revision, None


def _discard_pristine_failed_upgrade(
    source_dir: Path,
    requested: str,
    runner: CommandRunner,
) -> str | None:
    """Discard only a clean, unregistered partial tree at devtool's base tag."""
    if source_dir.is_symlink():
        return f"Existing source workspace at {source_dir} is a symlink; preserved for review"
    status = runner("git", ["status", "--porcelain", "--untracked-files=all"], source_dir)
    if status.returncode:
        return f"Could not inspect existing source workspace at {source_dir}; preserved for review"
    if (status.stdout or "").strip():
        return f"Existing source workspace at {source_dir} has local changes; preserved for review"

    head = runner("git", ["rev-parse", "HEAD"], source_dir)
    base = runner("git", ["rev-parse", "--verify", f"refs/tags/devtool-base-{requested}"], source_dir)
    if head.returncode or base.returncode:
        return (
            f"Existing source workspace at {source_dir} is not verifiably at "
            f"devtool-base-{requested}; preserved for review"
        )
    if (head.stdout or "").strip() != (base.stdout or "").strip():
        return (
            f"Existing source workspace at {source_dir} is not at "
            f"devtool-base-{requested}; preserved for review"
        )

    shutil.rmtree(source_dir)
    return None


def _stage_insufficient_providers(
    required: dict[str, str],
    active_recipes: dict[str, str],
    setup_dir: Path,
    release: str,
    layer_paths: list[Path],
    runner: CommandRunner,
    log: RunLog,
) -> tuple[list[tuple[str, Path | None]], list[str]]:
    staged: list[tuple[str, Path | None]] = []
    newly_staged: list[tuple[str, Path]] = []
    blockers: list[str] = []
    state = _load_upgrade_state(setup_dir, release)
    staged_state = state["staged_dependencies"]
    if not isinstance(staged_state, dict):
        staged_state = {}
        state["staged_dependencies"] = staged_state
    for recipe, requested in sorted(required.items()):
        current = active_recipes.get(recipe)
        if current is None:
            status = log.recipe(recipe)
            status.devtool_upgrade = "not attempted (provider missing)"
            status.compilation = "not run"
            status.ptest_present = "unknown"
            status.ptest_passed = "not run"
            blockers.append(f"No exact active provider for {recipe}; recipe alias/source is unresolved")
            break
        try:
            if Version(current) >= Version(requested):
                state_entry = staged_state.get(recipe)
                workspace_dir = setup_dir / "build/workspace/recipes" / recipe
                if workspace_dir.is_dir():
                    if isinstance(state_entry, dict):
                        owner = Path(str(state_entry.get("owner", ""))).resolve()
                        if owner in layer_paths:
                            staged.append((recipe, owner))
                            log.recipe(recipe).devtool_upgrade = "resumed staged upgrade"
                            staged_state[recipe] = {
                                "owner": str(owner),
                                "requested": requested,
                                "status": "staged",
                            }
                            log.outcomes.append(f"Resumed staged provider {recipe} at {current}.")
                        else:
                            blockers.append(f"Saved owner for staged {recipe} is no longer an active layer")
                            break
                    else:
                        log.recipe(recipe).devtool_upgrade = (
                            "existing provider accepted (new recipe; no layer owner)"
                        )
                        log.outcomes.append(
                            f"Accepted existing {recipe} workspace at {current}; it meets {requested} "
                            "and has no layer owner because it is a new recipe."
                        )
                        staged.append((recipe, None))
                        log.open_tasks.append(
                            f"Choose a destination layer for new provider {recipe}; after successful "
                            f"validation and review, run `devtool finish {shlex.quote(recipe)} "
                            "<destination-layer>` in the selected build environment "
                            "(replace <destination-layer> with the chosen layer path). "
                            "devtool finish moves the recipe and associated files into that layer; "
                            "do not move them manually beforehand."
                        )
                continue
        except InvalidVersion:
            status = log.recipe(recipe)
            status.devtool_upgrade = "not attempted (provider version invalid)"
            blockers.append(f"Cannot compare active provider {recipe} version {current!r}")
            break

        workspace_root = setup_dir / "build/workspace"
        workspace_recipe = workspace_root / "recipes" / recipe
        workspace_source = workspace_root / "sources" / recipe
        workspace_appends = workspace_root / "appends"
        has_workspace_append = any(workspace_appends.glob(f"{recipe}_*.bbappend")) or (
            workspace_appends / f"{recipe}.bbappend"
        ).is_file()
        recipe_status = log.recipe(recipe)
        recipe_status.devtool_upgrade = "in progress"
        if workspace_recipe.is_dir() or workspace_source.is_dir():
            state_entry = staged_state.get(recipe)
            if isinstance(state_entry, dict):
                owner = Path(str(state_entry.get("owner", ""))).resolve()
                if owner in layer_paths:
                    status = state_entry.get("status", "staged")
                    if (
                        status == "staging"
                        and workspace_source.is_dir()
                        and not workspace_recipe.is_dir()
                        and not has_workspace_append
                    ):
                        discard_blocker = _discard_pristine_failed_upgrade(
                            workspace_source,
                            requested,
                            runner,
                        )
                        if discard_blocker:
                            recipe_status.devtool_upgrade = "incomplete; workspace preserved"
                            blockers.append(discard_blocker)
                            break
                        log.outcomes.append(
                            f"Discarded pristine partial {recipe} source; "
                            "retrying devtool upgrade from a fresh workspace."
                        )
                    elif status == "staging":
                        recipe_status.devtool_upgrade = "incomplete; workspace preserved"
                        blockers.append(
                            f"Existing devtool workspace for {recipe} is registered or cannot be "
                            "identified as a pristine partial upgrade; it is preserved for review"
                        )
                        break
                    else:
                        recipe_status.devtool_upgrade = "existing staged version below required"
                        blockers.append(
                            f"Existing devtool workspace for {recipe} has provider {current} below "
                            f"required {requested}; workspace preserved for manual repair"
                        )
                        break
                else:
                    recipe_status.devtool_upgrade = "unknown staged workspace; preserved"
                    blockers.append(f"Existing staged {recipe} has no valid recorded owner")
                    break
            else:
                recipe_status.devtool_upgrade = "unknown staged workspace; preserved"
                blockers.append(
                    f"Existing {recipe} devtool workspace has no saved owner state; "
                    "workspace preserved and needs ownership review"
                )
                break
            if blockers:
                break
            if workspace_recipe.is_dir() or workspace_source.is_dir():
                continue
        file_command = (
            f"bitbake-getvar FILE --value --ignore-undefined "
            f"-r {shlex.quote(recipe)}"
        )
        file_result = _run_in_setup(
            setup_dir,
            file_command,
            runner,
        )
        log.record(
            f"Locate provider owner for {recipe}",
            ["bitbake-getvar", "FILE", "--value", "--ignore-undefined", "-r", recipe],
            file_result,
        )
        if file_result.returncode:
            recipe_status.devtool_upgrade = "failed: provider inspection"
            blockers.append(f"Could not inspect provider recipe {recipe}")
            break
        recipe_file_value = (file_result.stdout or "").strip()
        if not recipe_file_value:
            recipe_status.devtool_upgrade = "failed: recipe path unresolved"
            blockers.append(f"Could not resolve source recipe path for {recipe}")
            break
        recipe_file = Path(recipe_file_value).resolve()
        owner = next((path for path in layer_paths if recipe_file.is_relative_to(path)), None)
        if owner is None:
            recipe_status.devtool_upgrade = "failed: owner unresolved"
            blockers.append(f"Could not determine owning layer for {recipe} at {recipe_file}")
            break
        srcrev, srcrev_blocker = _resolve_provider_srcrev(
            recipe,
            requested,
            setup_dir,
            runner,
            log,
        )
        if srcrev_blocker:
            recipe_status.devtool_upgrade = "not attempted (source revision unresolved)"
            blockers.append(srcrev_blocker)
            break
        # Record ownership before devtool runs; even a failed upgrade may leave
        # a partial workspace that the next invocation must preserve or inspect.
        staged_state[recipe] = {
            "owner": str(owner),
            "requested": requested,
            "status": "staging",
        }
        _save_upgrade_state(setup_dir, release, state)
        upgrade_command = (
            f"devtool upgrade {shlex.quote(recipe)} --version {shlex.quote(requested)}"
        )
        if srcrev:
            upgrade_command += f" --srcrev {shlex.quote(srcrev)}"
        upgrade = _run_logged(
            f"Stage dependency recipe {recipe}",
            upgrade_command,
            setup_dir,
            runner,
            log,
        )
        if upgrade.returncode:
            recipe_status.devtool_upgrade = f"failed (exit {upgrade.returncode})"
            blockers.append(f"devtool could not upgrade {recipe} to {requested}; workspace preserved")
            break
        recipe_status.devtool_upgrade = f"passed (to {requested})"
        staged.append((recipe, owner))
        newly_staged.append((recipe, owner))
        staged_state[recipe] = {
            "owner": str(owner),
            "requested": requested,
            "status": "staged",
        }
        _save_upgrade_state(setup_dir, release, state)

    if newly_staged and not blockers:
        refreshed = _run_in_setup(setup_dir, "bitbake -s", runner)
        log.record("Recheck staged provider versions", ["bitbake", "-s"], refreshed)
        if refreshed.returncode:
            blockers.append("Could not verify staged provider versions")
        else:
            refreshed_recipes = _parse_active_recipe_versions(refreshed.stdout or "")
            for recipe, owner in newly_staged:
                current = refreshed_recipes.get(recipe)
                requested = required[recipe]
                try:
                    if current is None or Version(current) < Version(requested):
                        blockers.append(
                            f"Staged {recipe} provider {current or 'missing'} does not meet {requested}"
                        )
                except InvalidVersion:
                    blockers.append(f"Cannot compare staged {recipe} version {current!r}")
    return staged, sorted(set(blockers))


def _add_new_regular_tests(
    tests_path: Path,
    newly_tested: set[str],
    listed_tests: set[str],
) -> None:
    additions = sorted(newly_tested - listed_tests)
    if not additions:
        return
    text = tests_path.read_text(encoding="utf-8")
    marker = "COMPONENT_TEST_PACKAGES:append = \"\\\n"
    start = text.find(marker)
    if start < 0:
        raise RuntimeError("Could not locate regular COMPONENT_TEST_PACKAGES block")
    body_start = start + len(marker)
    terminator = "${@bb.utils.contains('PACKAGECONFIG', 'integration-tests', '', '', d)}\""
    body_end = text.find(terminator, body_start)
    if body_end < 0:
        raise RuntimeError("Could not locate end of regular component test list")
    lines = "".join(f"    ${{PN}}-{domain.replace('_', '-')} \\\n" for domain in additions)
    text = text[:body_end] + lines + text[body_end:]
    tests_path.write_text(text, encoding="utf-8")


def _run_dependency_ptests(
    staged_dependencies: list[tuple[str, Path | None]],
    layer_dir: Path,
    setup_dir: Path,
    runner: CommandRunner,
    log: RunLog,
    compilation_results: dict[str, bool],
    tracked_recipes: Sequence[str] = (),
    dependency_ptest_helper: Path | None = None,
    wrapper: str | None = None,
) -> list[str]:
    group_file = layer_dir / "conf/include/ptest-packagelists-meta-homeassistant.inc"
    if not group_file.is_file():
        for recipe in tracked_recipes:
            log.recipe(recipe).ptest_present = "unknown"
            log.recipe(recipe).ptest_passed = "not run"
        return ["Home Assistant ptest package groups are unavailable"]
    group_text = group_file.read_text(encoding="utf-8")
    supported = set(
        re.findall(
            r"(?m)^\s*(python3-[A-Za-z0-9_.+-]+)\s*\\?$",
            "\n".join(
                match.group(1)
                for match in re.finditer(
                    r'PTESTS_(?:FAST|SLOW)_META_HOMEASSISTANT\s*=\s*"\\\n(.*?)^"',
                    group_text,
                    re.DOTALL | re.MULTILINE,
                )
            ),
        )
    )
    to_test = [(recipe, owner) for recipe, owner in staged_dependencies if recipe in supported]
    skipped = sorted({recipe for recipe, _ in staged_dependencies} - supported)
    staged_names = {recipe for recipe, _ in staged_dependencies}
    for recipe in tracked_recipes:
        status = log.recipe(recipe)
        if recipe in supported:
            status.ptest_present = "yes"
            if recipe not in staged_names:
                status.ptest_passed = "not run (dependency upgrade was not staged)"
        else:
            status.ptest_present = "no"
            status.ptest_passed = "not available"
    if skipped:
        log.outcomes.append(
            "Dependency ptest skipped because recipes are outside fast/slow groups: "
            + ", ".join(skipped)
        )
        log.open_tasks.extend(
            f"Review ptest coverage for {recipe}; it is not in a fast/slow Home Assistant ptest group."
            for recipe in skipped
        )
    if not to_test:
        return []

    runnable = []
    for recipe, owner in to_test:
        if compilation_results.get(recipe, False):
            runnable.append((recipe, owner))
        else:
            log.recipe(recipe).ptest_passed = "not run (compile failed)"
    if not runnable:
        return []

    fragment = "homeassistant/enable-testing-base"
    newly_enabled = False
    if dependency_ptest_helper is None:
        toolcfg = setup_dir / "build/conf/toolcfg.conf"
        enabled = set()
        if toolcfg.is_file():
            for value in re.findall(
                r'(?m)^OE_FRAGMENTS\s*\+?=\s*"([^"]*)"',
                toolcfg.read_text(encoding="utf-8"),
            ):
                enabled.update(value.split())
        if fragment not in enabled:
            enable = _run_in_setup(
                setup_dir,
                f"bitbake-config-build enable-fragment {fragment}",
                runner,
            )
            log.record(
                "Enable dependency ptest fragment",
                ["bitbake-config-build", "enable-fragment", fragment],
                enable,
            )
            if enable.returncode:
                for recipe, _ in runnable:
                    log.recipe(recipe).ptest_passed = "not run (could not enable test fragment)"
                return ["Could not enable the Home Assistant dependency ptest fragment"]
            newly_enabled = True

    # Helpers own fragment setup/cleanup; the standalone path restores only
    # the fragment enabled here, including on failure or interruption.
    blockers: list[str] = []
    try:
        for recipe, _ in runnable:
            target = f"meta-homeassistant-image-ptest-{recipe}"
            command = f"bitbake {shlex.quote(target)}"
            if dependency_ptest_helper is not None:
                command = shlex.join([
                    "bash", str(dependency_ptest_helper),
                    "--wrapper", wrapper or setup_dir.name,
                    "--setup-dir", str(setup_dir),
                    "--target", target,
                    "--mode", "ptest",
                ])
            result = _run_logged(
                f"Run dependency ptest image {recipe}",
                command,
                setup_dir,
                runner,
                log,
            )
            if result.returncode:
                blockers.append(f"Dependency ptest failed for {recipe}")
                log.recipe(recipe).ptest_passed = f"no (exit {result.returncode})"
                break
            else:
                log.recipe(recipe).ptest_passed = "yes"
    finally:
        if newly_enabled:
            disable = _run_in_setup(
                setup_dir,
                f"bitbake-config-build disable-fragment {fragment}",
                runner,
            )
            log.record(
                "Disable dependency ptest fragment",
                ["bitbake-config-build", "disable-fragment", fragment],
                disable,
            )
            if disable.returncode:
                blockers.append("Could not disable the Home Assistant dependency ptest fragment")
    return blockers


def _verify_wrapper(
    layer_dir: Path,
    setup_dir: Path,
    wrapper: str,
    target: str,
    runner: CommandRunner,
    log: RunLog,
) -> tuple[list[Path], list[str]]:
    init_script = setup_dir / "build/init-build-env"
    if not init_script.is_file():
        raise RuntimeError(f"Build wrapper {wrapper!r} has no init script: {init_script}")
    layers = _run_in_setup(setup_dir, "bitbake-layers show-layers", runner)
    log.record("Inspect active layers", ["bitbake-layers", "show-layers"], layers)
    if layers.returncode:
        raise RuntimeError("Could not query active BitBake layers")
    active_paths = _active_layer_paths(layers.stdout or "")
    if layer_dir.resolve() not in active_paths:
        raise RuntimeError(f"Selected layer is not active in wrapper {wrapper!r}: {layer_dir}")
    target_check = _run_in_setup(
        setup_dir,
        f"bitbake -e {shlex.quote(target)}",
        runner,
        quiet_success=True,
    )
    log.record("Verify image target", ["bitbake", "-e", target], target_check)
    target_blockers = []
    if target_check.returncode:
        target_blockers.append(
            f"Target {target!r} is currently unbuildable in wrapper {wrapper!r}; "
            "resolve the BitBake error before resuming the upgrade"
        )
    return active_paths, target_blockers


def _staged_source_matches_release(
    source_dir: Path,
    revision: str,
    recipe_path: Path,
    layer_dir: Path,
    runner: CommandRunner,
) -> bool:
    # devtool HEAD includes applied recipe patches, not just the upstream tag.
    # Reuse only a clean tree whose changes are covered by those declared patches.
    if not (source_dir / ".git").exists():
        return False
    try:
        ancestor = runner("git", ["merge-base", "--is-ancestor", revision, "HEAD"], source_dir)
        if ancestor.returncode:
            return False
        status = _git_output(["status", "--porcelain"], source_dir, runner)
        if status:
            return False
        changed_files = set(
            _git_output(["diff", "--name-only", revision, "HEAD"], source_dir, runner).splitlines()
        )
        recipe_text = recipe_path.read_text(encoding="utf-8")
        patch_names = re.findall(r"file://([^\\\s\"]+\.patch)", recipe_text)
        allowed_files: set[str] = set()
        patch_dir = layer_dir / "recipes-homeassistant/homeassistant/python3-homeassistant"
        for patch_name in patch_names:
            patch_path = patch_dir / Path(patch_name).name
            if not patch_path.is_file():
                return False
            patch_text = patch_path.read_text(encoding="utf-8")
            allowed_files.update(
                path
                for path in re.findall(r"^\+\+\+ b/(.+)$", patch_text, re.MULTILINE)
                if path != "/dev/null"
            )
            reverse_check = runner(
                "git",
                ["apply", "--reverse", "--check", str(patch_path)],
                source_dir,
            )
            if reverse_check.returncode:
                return False
        return changed_files.issubset(allowed_files)
    except RuntimeError:
        return False


def _existing_stage_matches(
    source_dir: Path,
    revision: str,
    recipe_path: Path,
    layer_dir: Path,
    runner: CommandRunner,
) -> bool:
    if not recipe_path.is_file():
        return False
    recipe_text = recipe_path.read_text(encoding="utf-8")
    srcrev_match = re.search(r'(?m)^SRCREV\s*=\s*"([0-9a-fA-F]+)"', recipe_text)
    return bool(
        srcrev_match
        and srcrev_match.group(1) == revision
        and _staged_source_matches_release(source_dir, revision, recipe_path, layer_dir, runner)
    )


def _run_logged(
    label: str,
    command: str,
    setup_dir: Path,
    runner: CommandRunner,
    log: RunLog,
) -> subprocess.CompletedProcess[str]:
    print(f"\n=== {label} ===", flush=True)
    log.outcomes.append(f"Started: {label}")
    result = _run_in_setup(setup_dir, command, runner)
    log.record(label, ["bash", "-lc", command], result)
    log.outcomes.append(f"Completed: {label} (exit {result.returncode})")
    return result


def _append_report_results(
    report: str,
    log: RunLog,
    blockers: Sequence[str],
    metadata_changes: Sequence[str] = (),
    review_actions: Sequence[str] = (),
) -> str:
    lines = [report.rstrip(), "", "## Upgrade workflow results", ""]
    lines.extend(f"- {outcome}" for outcome in log.outcomes)
    lines.extend(f"- BLOCKED: {blocker}" for blocker in blockers)
    if review_actions:
        lines.extend(["", "## Manual Finish After Review", ""])
        lines.append("The workflow intentionally did not run these commands.")
        lines.extend(f"- `{command}`" for command in review_actions)
    if metadata_changes:
        lines.extend(["", "## Metadata changes", "", "```diff"])
        lines.extend(metadata_changes)
        lines.append("```")
    return "\n".join(lines).rstrip() + "\n"


def run_upgrade(
    *,
    release: str,
    layer_dir: Path,
    setup_dir: Path,
    wrapper: str,
    target: str,
    core_ptest_target: str | None = None,
    core_ptest_runqemu_args: Sequence[str] | None = None,
    dependency_ptest_helper: Path | None = None,
    image_test_helper: Path | None = None,
    runner: CommandRunner = _run,
) -> int:
    log = RunLog(release=release)
    report_path: Path | None = None
    log_path: Path | None = None
    metadata_changes: list[str] = []
    blockers: list[str] = []
    try:
        if dependency_ptest_helper is not None:
            dependency_ptest_helper = dependency_ptest_helper.expanduser().resolve()
            if not dependency_ptest_helper.is_file():
                raise FileNotFoundError(f"Dependency ptest helper not found: {dependency_ptest_helper}")
        if image_test_helper is not None:
            image_test_helper = image_test_helper.expanduser().resolve()
            if not image_test_helper.is_file():
                raise FileNotFoundError(f"Image test helper not found: {image_test_helper}")
        report_path, log_path = _ensure_fresh_artifacts(layer_dir, release)
        ptest_target = core_ptest_target or target
        ptest_runqemu_args = (
            tuple(core_ptest_runqemu_args)
            if core_ptest_runqemu_args is not None
            else DEFAULT_CORE_PTEST_RUNQEMU_ARGS
        )
        log.planned_actions.extend(
            [
                f"Resolve Home Assistant Core release {release} to an exact upstream commit.",
                f"Verify wrapper {wrapper} at {setup_dir} and image target {target}.",
                "Reuse a matching staged Core workspace or stage Core with devtool, then reconcile requirements and integration metadata.",
                "Inspect required dependency providers and stage or resume only providers that need work.",
                "Include all active non-Core devtool workspace recipes in dependency validation, including pre-existing recipes.",
                "Compile every changed or accepted provider before dependency ptests.",
                "Run available ptests for staged providers in the configured fast/slow ptest groups.",
                (
                    "After dependency validation passes, compile python3-homeassistant and build the selected image "
                    "through the caller's base-mode testimage helper."
                    if image_test_helper is not None
                    else "After dependency validation passes, compile python3-homeassistant and build the selected image."
                ),
                f"Run the plain Core ptest for python3-homeassistant using image target {ptest_target}.",
                "After successful validation and review, provide devtool finish commands; do not execute them automatically.",
            ]
        )
        if report_path.exists():
            raise FileExistsError(
                f"Refusing to overwrite existing report {report_path}; choose a new release or archive it"
            )
        _prepare_run_log(log_path)
        # 1. Validate the caller's existing setup before changing workspace files.
        print("[phase] Preflight release, mapping, wrapper layers, and target", flush=True)
        _verify_local_source_mapping(layer_dir)
        revision = resolve_release_commit(release, layer_dir, runner)
        log.revision = revision
        log.outcomes.append(f"Preflight resolved {release} to {revision}.")
        print(f"Upgrade release: {release} ({revision})")
        print(f"Wrapper: {wrapper} at {setup_dir}; target: {target}")
        layer_paths, target_blockers = _verify_wrapper(
            layer_dir,
            setup_dir,
            wrapper,
            target,
            runner,
            log,
        )
        blockers.extend(target_blockers)
        _stop_if_blocked(blockers, "Preflight")

        workspace_status = _run_logged(
            "Inspect devtool workspace before upgrade",
            "devtool status",
            setup_dir,
            runner,
            log,
        )
        if workspace_status.returncode:
            raise RuntimeError("Could not inspect devtool workspace")
        # 2. Reuse only a matching release plus declared patches. Never reset an
        # incompatible workspace or overwrite user source changes to force reuse.
        source_dir = setup_dir / CORE_SOURCE_RELATIVE
        staged_recipe = (
            setup_dir
            / CORE_RECIPE_RELATIVE
            / f"python3-homeassistant_{release}.bb"
        )
        if _existing_stage_matches(source_dir, revision, staged_recipe, layer_dir, runner):
            log.recipe(CORE_RECIPE).devtool_upgrade = "resumed staged upgrade"
            log.outcomes.append("Reused the matching staged Core source; devtool upgrade was not repeated.")
        else:
            print("[phase] Stage Home Assistant Core with devtool", flush=True)
            if source_dir.exists() or staged_recipe.exists():
                raise RuntimeError(
                    f"An incompatible devtool workspace already exists for {CORE_RECIPE}; "
                    "preserving it and stopping before devtool upgrade"
                )
            upgrade_command = (
                f"devtool upgrade {CORE_RECIPE} --version {shlex.quote(release)} "
                f"--srcrev {shlex.quote(revision)} --srcbranch master"
            )
            upgraded = _run_logged("Stage Core release", upgrade_command, setup_dir, runner, log)
            if upgraded.returncode:
                log.recipe(CORE_RECIPE).devtool_upgrade = f"failed (exit {upgraded.returncode})"
                raise RuntimeError("devtool upgrade failed; staged files were left untouched")
            log.recipe(CORE_RECIPE).devtool_upgrade = f"passed (to {release})"

        actual_revision = _git_output(["rev-parse", "HEAD"], source_dir, runner)
        if not _staged_source_matches_release(
            source_dir,
            revision,
            staged_recipe,
            layer_dir,
            runner,
        ):
            raise RuntimeError(
                f"Staged source is not the requested release plus declared recipe patches: "
                f"expected {revision}, workspace HEAD is {actual_revision}"
            )
        log.outcomes.append(
            f"Verified upstream source commit {revision}; workspace HEAD {actual_revision} contains only recipe patches."
        )
        recipe_candidates = (setup_dir / CORE_RECIPE_RELATIVE).glob(f"{CORE_RECIPE}_{release}.bb")
        recipe_candidates = list(recipe_candidates)
        if len(recipe_candidates) != 1:
            raise RuntimeError(
                f"Expected one staged {CORE_RECIPE}_{release}.bb recipe, found {len(recipe_candidates)}"
            )
        staged_recipe = recipe_candidates[0]
        integrations_file, tests_file = _staged_integration_metadata_paths(setup_dir)
        staged_recipe_before = _redirect_staged_integration_requires(staged_recipe)
        staged_recipe_after = staged_recipe.read_text(encoding="utf-8")
        metadata_changes.extend(
            line.rstrip("\n")
            for line in difflib.unified_diff(
                staged_recipe_before.splitlines(keepends=True),
                staged_recipe_after.splitlines(keepends=True),
                fromfile=f"{CORE_RECIPE} staged recipe before",
                tofile=f"{CORE_RECIPE} staged recipe after",
            )
        )
        # 3. Read upstream once and reconcile staged Core/runtime/test metadata.
        # Inventory the layer baseline before applying deterministic removals.
        upstream_integrations, upstream_test_domains, source_errors = read_upstream_integrations(
            source_dir
        )
        _stop_if_blocked(source_errors, "Read upstream integration metadata")
        supported, current_dependencies, listed_tests = parse_layer_metadata(
            integrations_file.read_text(encoding="utf-8"),
            tests_file.read_text(encoding="utf-8"),
        )
        print("[phase] Query providers and reconcile Core/integration metadata", flush=True)
        recipe_catalog = _run_in_setup(setup_dir, "bitbake -s", runner)
        log.record("Query active recipe catalog", ["bitbake", "-s"], recipe_catalog)
        if recipe_catalog.returncode:
            raise RuntimeError("Could not query active recipe versions")
        active_recipes = _parse_active_recipe_versions(recipe_catalog.stdout or "")
        core_recipe_before = staged_recipe.read_text(encoding="utf-8")
        core_reconciliation_blockers = _reconcile_core_recipe(
            staged_recipe, source_dir, active_recipes
        )
        core_recipe_after = staged_recipe.read_text(encoding="utf-8")
        metadata_changes.extend(
            line.rstrip("\n")
            for line in difflib.unified_diff(
                core_recipe_before.splitlines(keepends=True),
                core_recipe_after.splitlines(keepends=True),
                fromfile=f"{CORE_RECIPE} before",
                tofile=f"{CORE_RECIPE} after",
            )
        )
        _stop_if_blocked(core_reconciliation_blockers, "Reconcile Core requirements")
        inventory = build_report(layer_dir, source_dir, release, revision).replace(
            "This is a report-only comparison. No BitBake metadata was changed.",
            "This inventory captures upstream differences before workflow reconciliation.",
        )
        integration_before = integrations_file.read_text(encoding="utf-8")
        tests_before = tests_file.read_text(encoding="utf-8")
        image_integrations_file = (
            layer_dir / "recipes-homeassistant/images/homeassistant-integrations.inc"
        )
        image_integrations_before = image_integrations_file.read_text(encoding="utf-8")
        removed_integrations = _remove_removed_integrations(
            integrations_file,
            tests_file,
            image_integrations_file,
            set(upstream_integrations),
        )
        reconciled_supported = supported - set(removed_integrations)
        removed_dependencies = sum(
            len(set(current_dependencies.get(domain, {})) - set(upstream_integrations[domain]))
            for domain in reconciled_supported & upstream_integrations.keys()
        )
        reconciliation_blockers = _replace_integration_dependencies(
            integrations_file,
            upstream_integrations,
            reconciled_supported,
            active_recipes,
        )
        _stop_if_blocked(reconciliation_blockers, "Reconcile integration dependencies")
        required_versions = _required_recipe_versions(
            upstream_integrations,
            supported,
            staged_recipe,
        )
        log.planned_actions.extend(_provider_plan_actions(required_versions, active_recipes))
        staged_dependencies, provider_blockers = _stage_insufficient_providers(
            required_versions,
            active_recipes,
            setup_dir,
            release,
            layer_paths,
            runner,
            log,
        )
        _stop_if_blocked(provider_blockers, "Stage dependency providers")
        workspace_status = _run_logged(
            "Recheck devtool workspace after staging",
            "devtool status",
            setup_dir,
            runner,
            log,
        )
        if workspace_status.returncode:
            raise RuntimeError("Could not recheck devtool workspace after staging")
        workspace_recipes = _parse_devtool_workspace_recipes(
            workspace_status.stdout or ""
        )
        workspace_dependency_recipes = workspace_recipes - {CORE_RECIPE}
        staged_by_name = dict(staged_dependencies)
        upgrade_state = _load_upgrade_state(setup_dir, release)
        staged_state = upgrade_state.get("staged_dependencies", {})
        for recipe in sorted(workspace_dependency_recipes):
            if recipe in staged_by_name:
                continue
            owner: Path | None = None
            if isinstance(staged_state, dict):
                state_entry = staged_state.get(recipe)
                if isinstance(state_entry, dict):
                    recorded_owner = state_entry.get("owner")
                    if isinstance(recorded_owner, str):
                        candidate_owner = Path(recorded_owner).resolve()
                        if candidate_owner in layer_paths:
                            owner = candidate_owner
            staged_by_name[recipe] = owner
            log.recipe(recipe).devtool_upgrade = "existing workspace recipe; included for validation"
            log.outcomes.append(
                f"Added workspace recipe {recipe} to dependency validation."
            )
            if owner is None:
                log.open_tasks.append(
                    f"Review the owner and destination layer for workspace recipe {recipe}; "
                    "after successful validation and review, run "
                    f"`devtool finish {shlex.quote(recipe)} <destination-layer>` in the selected "
                    "build environment. Do not move workspace files manually."
                )
        staged_dependencies = sorted(staged_by_name.items())
        if staged_dependencies:
            log.planned_actions.append(
                "Compile workspace dependency recipes and run their available fast/slow ptests: "
                + ", ".join(recipe for recipe, _owner in staged_dependencies)
                + "."
            )
        _add_new_regular_tests(
            tests_file,
            upstream_test_domains & reconciled_supported,
            listed_tests,
        )
        for path, before, label in (
            (integrations_file, integration_before, "integrations.inc"),
            (tests_file, tests_before, "integrations-tests.inc"),
            (
                image_integrations_file,
                image_integrations_before,
                "homeassistant-integrations.inc",
            ),
        ):
            after = path.read_text(encoding="utf-8")
            metadata_changes.extend(
                line.rstrip("\n")
                for line in difflib.unified_diff(
                    before.splitlines(keepends=True),
                    after.splitlines(keepends=True),
                    fromfile=f"{label} before",
                    tofile=f"{label} after",
                )
            )
        if removed_integrations:
            log.outcomes.append(
                "Removed integrations absent from upstream manifests and their Core package, test, "
                "and image metadata: "
                + ", ".join(removed_integrations)
                + "."
            )
        if removed_dependencies:
            log.outcomes.append(
                f"Removed {removed_dependencies} per-integration package dependencies no longer listed "
                "in upstream manifests."
            )
        log.outcomes.append(
            "Reconciled supported integration package dependencies to upstream manifests."
        )
        log.outcomes.append(
            "Reconciled staged Core runtime and ptest requirements from pyproject.toml and requirements_test.txt."
        )
        if upstream_test_domains & reconciled_supported - listed_tests:
            log.outcomes.append("Added newly detected supported integration tests to the regular test list.")
        if reconciled_supported & (listed_tests - upstream_test_domains):
            log.outcomes.append(
                "Existing integration test entries absent upstream were preserved for manual review."
            )

        # 4. Compile and test providers before the expensive Core/image builds.
        # Unsupported ptests are explicit coverage gaps, never implied passes.
        print("[phase] Build changed dependency recipes", flush=True)
        compilation_results: dict[str, bool] = {}
        for recipe, _ in staged_dependencies:
            compile_result = _run_logged(
                f"Compile {recipe}",
                f"bitbake {shlex.quote(recipe)}",
                setup_dir,
                runner,
                log,
            )
            passed = compile_result.returncode == 0
            compilation_results[recipe] = passed
            log.recipe(recipe).compilation = "passed" if passed else f"failed (exit {compile_result.returncode})"
            if not passed:
                blockers.append(f"Compilation failed for {recipe}")
                _stop_if_blocked(blockers, f"Compile {recipe}")

        print("[phase] Run ptests for changed providers in fast/slow groups", flush=True)
        dependency_ptest_blockers = _run_dependency_ptests(
            staged_dependencies,
            layer_dir,
            setup_dir,
            runner,
            log,
            compilation_results,
            [
                recipe
                for recipe in log.recipe_status
                if recipe != CORE_RECIPE
            ],
            dependency_ptest_helper,
            wrapper,
        )
        if dependency_ptest_blockers:
            blockers.extend(dependency_ptest_blockers)
            _stop_if_blocked(dependency_ptest_blockers, "Run dependency ptests")

        # 5. Only validated dependencies reach Core and image validation.
        # A successful recipe build alone does not validate the assembled image.
        print("[phase] Build Core recipe and selected image", flush=True)
        core_compile = _run_logged(
            f"Compile {CORE_RECIPE}",
            f"bitbake {CORE_RECIPE}",
            setup_dir,
            runner,
            log,
        )
        core_compiled = core_compile.returncode == 0
        compilation_results[CORE_RECIPE] = core_compiled
        log.recipe(CORE_RECIPE).compilation = (
            "passed" if core_compiled else f"failed (exit {core_compile.returncode})"
        )
        if not core_compiled:
            blockers.append(f"Compilation failed for {CORE_RECIPE}")
            _stop_if_blocked(blockers, f"Compile {CORE_RECIPE}")

        image_build_command = (
            shlex.join(
                [
                    "bash",
                    str(image_test_helper),
                    "--wrapper",
                    wrapper,
                    "--setup-dir",
                    str(setup_dir),
                    "--target",
                    target,
                    "--mode",
                    "base",
                ]
            )
            if image_test_helper is not None
            else f"bitbake {shlex.quote(target)}"
        )
        image_build = _run_logged(
            f"Build image {target}",
            image_build_command,
            setup_dir,
            runner,
            log,
        )
        image_built = image_build.returncode == 0
        log.recipe(target).compilation = "passed" if image_built else f"failed (exit {image_build.returncode})"
        log.recipe(target).devtool_upgrade = "not applicable (image target)"
        log.recipe(target).ptest_present = "not applicable (image target)"
        log.recipe(target).ptest_passed = "not applicable (image target)"
        if not image_built:
            blockers.append(f"Image build failed for {target}")
            log.open_tasks.append("Rerun the selected image build after resolving its BitBake errors.")
            _stop_if_blocked(blockers, f"Build image {target}")

        # The fail-fast gates above guarantee that all required builds passed.
        # Resolve the shared helper from the layer, not the caller's working dir.
        ptest_script = layer_dir / "tests/image/test-pytest-plain.sh"
        ptest_command = [
            "bash",
            str(ptest_script),
            "--wrapper",
            wrapper,
            "--target",
            ptest_target,
            "--package",
            CORE_RECIPE,
            "--setup-dir",
            str(setup_dir),
            "--no-default-runqemu-args",
        ]
        for runqemu_arg in ptest_runqemu_args:
            ptest_command.extend(["--runqemu-arg", runqemu_arg])
        print("\n=== Run Core plain ptest ===", flush=True)
        log.outcomes.append("Started: Core plain ptest")
        ptest = runner(ptest_command[0], ptest_command[1:], layer_dir)
        log.record("Run Core plain ptest", ptest_command, ptest)
        log.recipe(CORE_RECIPE).ptest_present = "yes"
        log.outcomes.append(f"Completed: Core plain ptest (exit {ptest.returncode})")
        if ptest.returncode:
            log.recipe(CORE_RECIPE).ptest_passed = f"no (exit {ptest.returncode})"
            blockers.append("Core ptest failed")
            _stop_if_blocked(blockers, "Run Core ptest")
        log.recipe(CORE_RECIPE).ptest_passed = "yes"
        log.open_tasks.append(
            "Review Core test coverage: the configured ptest suite is not complete Home Assistant regression coverage."
        )
        log.outcomes.append(
            "Core ptest passed; this is the configured ptest suite, not complete Home Assistant regression coverage."
        )

        # 6. Publish a review-ready result only after all gates pass. Ownership
        # determines suggested destinations; devtool finish is never executed.
        log.outcomes.append(
            "Required builds and available ptests passed; upgrade is ready for manual review."
        )
        log.outcomes.append(
            "No devtool finish command was run; staged recipe workspaces remain available for review."
        )
        review_actions = [
            f"source {shlex.quote(str(setup_dir / 'build/init-build-env'))} && "
            f"devtool finish {shlex.quote(recipe)} {shlex.quote(str(owner))}"
            for recipe, owner in staged_dependencies
            if owner is not None
        ]
        review_actions.append(
            f"source {shlex.quote(str(setup_dir / 'build/init-build-env'))} && "
            f"devtool finish {CORE_RECIPE} {shlex.quote(str(layer_dir))}"
        )
        log.manual_actions = review_actions
        log.planned_actions.extend(
            f"After review, run `{command}`."
            for command in review_actions
        )
        report_path.write_text(
            _append_report_results(inventory, log, [], metadata_changes, review_actions),
            encoding="utf-8",
        )
        return 0
    except KeyboardInterrupt:
        log.outcomes.append("Interrupted by user; no later gates ran and staged workspace edits were preserved.")
        log.open_tasks.append("Resume the same release task; compatible Core/provider workspaces will be reused.")
        print("\nInterrupted. Staged workspace edits were preserved.", file=sys.stderr, flush=True)
        return_code = 130
    except WorkflowBlocked as error:
        blockers.extend(error.blockers)
        log.outcomes.append(
            f"Stopped after {error.phase}; returned control for user action. "
            "Staged workspace changes were preserved; rerun after resolving the blocker."
        )
        log.outcomes.extend(f"BLOCKED: {blocker}" for blocker in error.blockers)
        print(f"STOPPED: {error}", file=sys.stderr, flush=True)
        return_code = 1
    except (OSError, RuntimeError, ValueError, FileExistsError) as error:
        blockers.append(str(error))
        log.outcomes.append("Upgrade stopped; no later gates were run.")
        log.outcomes.extend(f"BLOCKED: {blocker}" for blocker in blockers)
        log.open_tasks.extend(blockers)
        print(f"ERROR: {error}", file=sys.stderr)
        return_code = 1
    finally:
        log.open_tasks.extend(blockers)
        if log_path is not None:
            log_path.parent.mkdir(parents=True, exist_ok=True)
            log_path.write_text(log.render(), encoding="utf-8")
    return return_code


def build_parser() -> argparse.ArgumentParser:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--release", required=True, help="Explicit Home Assistant Core release tag")
    parser.add_argument("--layer-dir", type=Path, default=LAYER_ROOT, help="meta-homeassistant checkout")
    parser.add_argument("--setup-dir", type=Path, required=True, help="Existing bitbake-setup directory")
    parser.add_argument("--wrapper", required=True, help="Configured wrapper name")
    parser.add_argument("--target", required=True, help="Primary image target to build")
    parser.add_argument("--core-ptest-target", help="SSH-capable image containing python3-homeassistant ptest files")
    parser.add_argument(
        "--core-ptest-runqemu-arg",
        action="append",
        dest="core_ptest_runqemu_args",
        help="runqemu argument for the Core ptest (repeatable; replaces defaults "
             "slirp, snapshot, nographic)",
    )
    parser.add_argument(
        "--dependency-ptest-helper",
        type=Path,
        help="Runtime helper accepting --wrapper, --setup-dir, --target and --mode ptest; "
             "use the enclosing project's testimage helper for machine-specific boot policy",
    )
    parser.add_argument(
        "--image-test-helper",
        type=Path,
        help="Optional enclosing-project testimage helper; builds and tests the selected image in base mode",
    )
    return parser


def main(argv: Sequence[str] | None = None) -> int:
    parser = build_parser()
    args = parser.parse_args(argv)
    release = args.release.strip()
    if not re.fullmatch(r"\d{4}\.\d+\.\d+", release):
        parser.error("--release must be an explicit Home Assistant tag such as 2026.3.1")
    layer_dir = args.layer_dir.expanduser().resolve()
    setup_dir = args.setup_dir.expanduser().resolve()
    if not (layer_dir / "recipes-homeassistant/homeassistant/python3-homeassistant").is_dir():
        parser.error(f"--layer-dir is not a meta-homeassistant checkout: {layer_dir}")
    return run_upgrade(
        release=release,
        layer_dir=layer_dir,
        setup_dir=setup_dir,
        wrapper=args.wrapper,
        target=args.target,
        core_ptest_target=args.core_ptest_target,
        core_ptest_runqemu_args=args.core_ptest_runqemu_args,
        dependency_ptest_helper=args.dependency_ptest_helper,
        image_test_helper=args.image_test_helper,
    )


if __name__ == "__main__":
    raise SystemExit(main())
