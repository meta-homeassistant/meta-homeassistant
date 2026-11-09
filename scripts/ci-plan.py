#!/usr/bin/env python3
"""Git-only recipe change detection and branch validation baselines."""

import json
import hashlib
import posixpath
from pathlib import Path
import re
import subprocess


POLICY = 2


def git(repo: Path, *args: str) -> str:
    return subprocess.check_output(["git", "-C", str(repo), *args], text=True).strip()


def checkout_revision(repo: Path) -> str:
    if git(repo, "status", "--porcelain", "--untracked-files=no", "--ignore-submodules"):
        raise RuntimeError("CI requires a clean tracked Home Assistant checkout")
    return git(repo, "rev-parse", "HEAD")


def is_ancestor(repo: Path, older: str, newer: str) -> bool:
    result = subprocess.run(
        ["git", "-C", str(repo), "merge-base", "--is-ancestor", older, newer],
        check=False,
    )
    if result.returncode not in (0, 1):
        result.check_returncode()
    return result.returncode == 0


def find_baseline(repo: Path, directory: Path, scope: dict, revision: str) -> dict | None:
    candidates = []
    paths = sorted(directory.glob("*.json")) + sorted((directory / "history").glob("*.json"))
    for path in paths:
        try:
            baseline = json.loads(path.read_text())
        except json.JSONDecodeError:
            print(f"Ignoring invalid baseline: {path.name}", flush=True)
            continue
        if not isinstance(baseline, dict) or baseline.get("policy") != POLICY:
            continue
        previous_scope = baseline.get("scope", {})
        if not isinstance(previous_scope, dict) or any(
            previous_scope.get(key) != scope[key] for key in ("repository", "configuration")
        ):
            continue
        previous = baseline.get("revision")
        if not isinstance(previous, str) or not re.fullmatch(r"[0-9a-f]{40,64}", previous):
            continue
        available = subprocess.run(
            ["git", "-C", str(repo), "cat-file", "-e", f"{previous}^{{commit}}"],
            stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL, check=False,
        )
        if available.returncode:
            continue
        if not is_ancestor(repo, previous, revision):
            if path.parent == directory and previous_scope == scope and is_ancestor(repo, revision, previous):
                tip = git(repo, "ls-remote", "--exit-code", "origin", scope["ref"]).split()[0]
                if tip != revision:
                    raise RuntimeError("Superseded run: this branch already validated a descendant")
            continue
        if path.parent == directory and previous_scope == scope:
            return baseline
        distance = int(git(repo, "rev-list", "--count", f"{previous}..{revision}"))
        candidates.append((distance, baseline))
    return min(candidates, key=lambda item: item[0])[1] if candidates else None


def recipe_name(path: str) -> str:
    return Path(path).stem.split("_", 1)[0]


def recipe_changes(repo: Path, revision: str, changed: list[str]) -> list[str]:
    files = git(repo, "ls-tree", "-r", "--name-only", revision).splitlines()
    recipes = [name for name in files if name.endswith((".bb", ".bbappend"))]
    affected = set()
    changed_set = set(changed)
    for name in changed:
        path = Path(name)
        if path.suffix in (".bb", ".bbappend"):
            affected.add(recipe_name(name))
        for recipe in recipes:
            candidate = Path(recipe)
            # Recipe-local patches, runners, files/, and named .inc files.
            if candidate.parent in path.parents and (
                path.relative_to(candidate.parent).parts[0] in
                (recipe_name(recipe), "files")
                or path.name == f"{recipe_name(recipe)}.inc"
                or path.name.startswith(f"{recipe_name(recipe)}-") and path.suffix == ".inc"
            ):
                affected.add(recipe_name(recipe))
    # Follow shared require/include chains in checked-in metadata as well.
    includes = []
    if any(name.endswith(".inc") for name in changed):
        result = subprocess.run(
            ["git", "-C", str(repo), "grep", "-I", "-E",
             r"^[[:space:]]*(require|include)[[:space:]]+", revision, "--",
             "*.bb", "*.bbappend", "*.inc"],
            text=True, stdout=subprocess.PIPE, check=False,
        )
        if result.returncode not in (0, 1):
            result.check_returncode()
        for line in result.stdout.splitlines():
            _, name, text = line.split(":", 2)
            match = re.match(r"\s*(?:require|include)\s+([^\s#]+)", text)
            if match:
                include = match.group(1)
                includes.append((name, include, posixpath.normpath(str(Path(name).parent / include))))
    while True:
        added = set()
        for name, include, local in includes:
            if name not in changed_set and (include in changed_set or local in changed_set):
                added.add(name)
        if not added:
            break
        changed_set.update(added)
    affected.update(recipe_name(name) for name in changed_set if name.endswith((".bb", ".bbappend")))
    return sorted(affected)


def recipe_fingerprints(
    repo: Path, revision: str, recipes: list[str], changed: list[str],
) -> dict[str, str]:
    if not recipes:
        return {}
    tree = subprocess.check_output(
        ["git", "-C", str(repo), "ls-tree", "-r", revision], text=True,
    )
    objects = {
        fields[3]: fields[2]
        for line in tree.splitlines()
        if len(fields := line.split(None, 3)) == 4
    }
    changes = [
        (name, objects.get(name, "deleted"))
        for name in sorted(changed)
    ]
    return {
        recipe: hashlib.sha256(
            json.dumps([recipe, revision if not changes else changes], sort_keys=True).encode()
        ).hexdigest()
        for recipe in recipes
    }


def plan(repo: Path, baseline: dict | None, revision: str) -> dict:
    changed = []
    if baseline:
        changed = git(
            repo, "diff", "--no-renames", "--name-only",
            baseline["revision"], revision,
        ).splitlines()
    return {
        "reason": "Changes since validated ancestor" if baseline else "No validated ancestor; test all enabled ptests",
        "baseline_revision": baseline["revision"] if baseline else None,
        "baseline_ptests": baseline.get("enabled_ptests", []) if baseline else [],
        "ptest_results": baseline.get("ptest_results", {}) if baseline else {},
        "changed_files": changed,
        "recipes": recipe_changes(repo, revision, changed) if changed else [],
        "all_ptests": baseline is None,
    }
