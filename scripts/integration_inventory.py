#!/usr/bin/env python3
"""Compare Home Assistant integration metadata with a checked-out Core source."""

import argparse
import json
import re
import sys
from pathlib import Path
from packaging.requirements import InvalidRequirement, Requirement
from packaging.version import InvalidVersion, Version

LAYER_ROOT = Path(__file__).resolve().parents[1]
INTEGRATIONS_FILE = Path(
    "recipes-homeassistant/homeassistant/python3-homeassistant/integrations.inc"
)
INTEGRATION_TESTS_FILE = Path(
    "recipes-homeassistant/homeassistant/python3-homeassistant/integrations-tests.inc"
)


def _domain_from_package(package_name):
    return package_name.replace("-", "_")


def parse_requirement(requirement):
    """Return a Yocto package name and exact version pin from a manifest requirement."""
    try:
        parsed = Requirement(requirement)
    except (InvalidRequirement, TypeError) as error:
        raise ValueError(f"Unsupported Home Assistant requirement {requirement!r}: {error}") from error

    if parsed.url or parsed.marker is not None:
        raise ValueError(
            f"Unsupported Home Assistant requirement {requirement!r}: "
            "direct URLs and environment markers are not handled"
        )

    specifiers = list(parsed.specifier)
    if len(specifiers) != 1 or specifiers[0].operator != "==" or "*" in specifiers[0].version:
        raise ValueError(
            f"Unsupported Home Assistant requirement {requirement!r}: "
            "expected one exact, non-wildcard == version pin"
        )

    normalized_name = re.sub(r"[-_.]+", "-", parsed.name).lower()
    return f"python3-{normalized_name}", specifiers[0].version


def parse_layer_metadata(integrations_text, integration_tests_text):
    """Read supported domains, per-domain runtime requirements, and test lists."""
    integrations_match = re.search(
        r'^INTEGRATIONS\s*=\s*"\\\n(?P<body>.*?)^"',
        integrations_text,
        re.MULTILINE | re.DOTALL,
    )
    if not integrations_match:
        raise ValueError("Could not locate the INTEGRATIONS package list")

    supported_domains = set(
        _domain_from_package(package_name)
        for package_name in re.findall(
            r"^\s*\$\{PN\}-([a-z0-9][a-z0-9-]*)\s*\\?\s*$",
            integrations_match.group("body"),
            re.MULTILINE,
        )
    )
    if not supported_domains:
        raise ValueError("INTEGRATIONS package list is empty or unrecognized")

    dependencies_by_domain = {}
    dependency_block = re.compile(
        r'^RDEPENDS:\$\{PN\}-([a-z0-9][a-z0-9-]*)\s*=\s*"\\\n(.*?)^"',
        re.MULTILINE | re.DOTALL,
    )
    dependency_line = re.compile(
        r"^\s*(python3-[a-zA-Z0-9_.+-]+)(?:\s+\(([^)]+)\))?\s*\\?\s*$"
    )
    for match in dependency_block.finditer(integrations_text):
        domain = _domain_from_package(match.group(1))
        domain_dependencies = dependencies_by_domain.setdefault(domain, {})
        for line in match.group(2).splitlines():
            dependency_match = dependency_line.match(line)
            if dependency_match:
                domain_dependencies[dependency_match.group(1)] = dependency_match.group(2) or ""

    test_domains = set()
    test_block = re.compile(
        r"COMPONENT_TEST_PACKAGES(?:_FLAKY)?:append\s*=\s*\"(.*?)'\s*,\s*''\s*,\s*d\)\}",
        re.DOTALL,
    )
    for match in test_block.finditer(integration_tests_text):
        test_domains.update(
            _domain_from_package(package_name)
            for package_name in re.findall(r"\$\{PN\}-([a-z0-9][a-z0-9-]*)", match.group(1))
        )

    return supported_domains, dependencies_by_domain, test_domains


def read_upstream_integrations(source_dir):
    """Read manifest requirements and test presence from a Home Assistant checkout."""
    source_dir = Path(source_dir)
    components_dir = source_dir / "homeassistant" / "components"
    tests_dir = source_dir / "tests" / "components"
    if not components_dir.is_dir():
        raise ValueError(f"Home Assistant components directory not found: {components_dir}")
    if not tests_dir.is_dir():
        raise ValueError(f"Home Assistant component tests directory not found: {tests_dir}")

    integrations = {}
    errors = []
    for manifest_path in sorted(components_dir.glob("*/manifest.json")):
        try:
            manifest = json.loads(manifest_path.read_text(encoding="utf-8"))
            domain = manifest["domain"]
            requirements = manifest.get("requirements", [])
            if not isinstance(domain, str) or not isinstance(requirements, list):
                raise ValueError("manifest domain or requirements has an invalid type")
        except (json.JSONDecodeError, KeyError, ValueError) as error:
            errors.append(f"{manifest_path.parent.name}: invalid manifest: {error}")
            continue

        parsed_requirements = {}
        for raw_requirement in requirements:
            try:
                package_name, required_version = parse_requirement(raw_requirement)
            except (TypeError, ValueError) as error:
                errors.append(f"{domain}: {error}")
                continue
            previous_version = parsed_requirements.get(package_name)
            if previous_version is not None and previous_version != required_version:
                errors.append(
                    f"{domain}: conflicting versions for {package_name}: "
                    f"{previous_version} and {required_version}"
                )
            parsed_requirements[package_name] = required_version
        if domain in integrations:
            errors.append(f"duplicate integration domain in manifests: {domain}")
        integrations[domain] = parsed_requirements

    if not integrations:
        raise ValueError(f"No integration manifests found in {components_dir}")

    tested_domains = {
        path.name for path in tests_dir.iterdir() if path.is_dir() and not path.name.startswith(".")
    }
    return integrations, tested_domains, errors


def compare_integrations(supported, current_dependencies, listed_test_domains, upstream, upstream_test_domains, errors):
    """Build a deterministic inventory and dependency review result."""
    upstream_domains = set(upstream)
    shared_domains = supported & upstream_domains
    dependency_findings = []
    for domain in sorted(shared_domains):
        current = current_dependencies.get(domain, {})
        required = upstream[domain]
        for package_name in sorted(required.keys() - current.keys()):
            dependency_findings.append(("missing", domain, package_name, "", required[package_name]))
        for package_name in sorted(current.keys() - required.keys()):
            dependency_findings.append(("review", domain, package_name, current[package_name], "not in manifest"))
        for package_name in sorted(current.keys() & required.keys()):
            current_spec = current[package_name]
            version_match = re.fullmatch(r"(?:==|=|>=|>)\s*(.+)", current_spec)
            current_version = version_match.group(1) if version_match else ""
            try:
                versions_match = Version(current_version) == Version(required[package_name])
            except InvalidVersion:
                versions_match = False
            if not versions_match:
                dependency_findings.append(
                    ("version", domain, package_name, current_spec or "unversioned", required[package_name])
                )

    return {
        "new_upstream": sorted(upstream_domains - supported),
        "removed_upstream": sorted(supported - upstream_domains),
        "supported": sorted(shared_domains),
        "new_tests": sorted((supported & upstream_test_domains) - listed_test_domains),
        "listed_tests_missing_upstream": sorted((supported & listed_test_domains) - upstream_test_domains),
        "dependency_findings": dependency_findings,
        "errors": sorted(errors),
    }


def render_report(release, source_revision, result):
    """Render a stable Markdown report without mutating layer metadata."""
    lines = [
        f"# Home Assistant Integration Inventory: {release}",
        "",
        f"Source commit: `{source_revision}`",
        "",
        "This is a report-only comparison. No BitBake metadata was changed.",
        "",
        f"Supported integrations present upstream: {len(result['supported'])}",
        "",
    ]

    sections = (
        ("Upstream integrations not currently supported", result["new_upstream"]),
        ("Supported integrations absent upstream", result["removed_upstream"]),
        ("Newly detected tests for supported integrations", result["new_tests"]),
        ("Layer-listed tests absent upstream", result["listed_tests_missing_upstream"]),
    )
    for heading, values in sections:
        lines.extend((f"## {heading}", ""))
        lines.extend(f"- `{value}`" for value in values)
        if not values:
            lines.append("- None")
        lines.append("")

    lines.extend(("## Dependency differences requiring review", ""))
    if result["dependency_findings"]:
        for kind, domain, package_name, current, desired in result["dependency_findings"]:
            lines.append(
                f"- `{domain}`: {kind} `{package_name}`; current `{current}`, upstream `{desired}`"
            )
    else:
        lines.append("- None")
    lines.append("")

    lines.extend(("## Unresolved source data", ""))
    if result["errors"]:
        lines.extend(f"- {error}" for error in result["errors"])
    else:
        lines.append("- None")
    lines.append("")
    return "\n".join(lines)


def build_report(layer_dir, source_dir, release, source_revision):
    """Compare a Core checkout with this layer and return the Markdown report."""
    layer_dir = Path(layer_dir)
    integrations_text = (layer_dir / INTEGRATIONS_FILE).read_text(encoding="utf-8")
    tests_text = (layer_dir / INTEGRATION_TESTS_FILE).read_text(encoding="utf-8")
    supported, current_dependencies, listed_tests = parse_layer_metadata(
        integrations_text,
        tests_text,
    )
    upstream, upstream_tests, errors = read_upstream_integrations(source_dir)
    result = compare_integrations(
        supported,
        current_dependencies,
        listed_tests,
        upstream,
        upstream_tests,
        errors,
    )
    return render_report(release, source_revision, result)


def main(argv=None):
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("--release", required=True, help="Home Assistant release tag or identifier")
    parser.add_argument("--source-dir", required=True, type=Path, help="Checked-out Home Assistant Core source")
    parser.add_argument("--source-revision", required=True, help="Verified commit hash for --source-dir")
    parser.add_argument("--layer-dir", type=Path, default=LAYER_ROOT, help="meta-homeassistant checkout")
    parser.add_argument("--output", type=Path, help="Report path; defaults to the layer root")
    parser.add_argument("--overwrite", action="store_true", help="Replace a report for this release if it exists")
    args = parser.parse_args(argv)

    if not re.fullmatch(r"[A-Za-z0-9._+-]+", args.release):
        parser.error("--release may contain only letters, digits, dot, underscore, plus, and hyphen")

    report_path = args.output or args.layer_dir / f"integration-summary-{args.release}.md"
    try:
        report = build_report(args.layer_dir, args.source_dir, args.release, args.source_revision)
        if report_path.exists() and not args.overwrite:
            raise FileExistsError(
                f"Report already exists: {report_path} (use --overwrite to replace it)"
            )
        report_path.parent.mkdir(parents=True, exist_ok=True)
        report_path.write_text(report, encoding="utf-8")
    except (OSError, ValueError) as error:
        print(f"ERROR: {error}", file=sys.stderr)
        return 1

    print(f"Wrote integration inventory: {report_path}")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())