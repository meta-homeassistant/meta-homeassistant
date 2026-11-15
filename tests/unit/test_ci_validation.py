#!/usr/bin/env python3
"""Offline tests for CI planning, shared builds, and independent stages."""

import contextlib
import importlib
import io
import json
import os
from pathlib import Path
import shlex
import subprocess
import sys
import tempfile
import unittest
from unittest.mock import patch


sys.path.insert(0, str(Path(__file__).resolve().parents[2] / "scripts"))
ci = importlib.import_module("ci-validate")
planner = importlib.import_module("ci-plan")
CLEAN_IMAGE = ci.clean_image
RUN_PTEST_BATCH = ci.run_ptest_batch
PTEST_ENVIRONMENT = ci.ptest_environment
REAL_RUN = subprocess.run


class ValidationTests(unittest.TestCase):
    def setUp(self):
        temporary = tempfile.TemporaryDirectory(prefix="ha-ci-test-")
        self.addCleanup(temporary.cleanup)
        self.root = Path(temporary.name)
        self.repo = self.root / "repo"
        self.repo.mkdir()
        self.git("init", "-q", "-b", "main")
        self.git("config", "user.name", "CI tests")
        self.git("config", "user.email", "ci@example.invalid")
        self.git("remote", "add", "origin", str(self.repo))
        self.initial = self.commit("README.md", "initial")
        self.state = self.root / "state"
        self.state.mkdir()
        self.environment = patch.dict(os.environ, {
            "CI_REPOSITORY": "test/ha", "CI_REF": "refs/heads/main",
            "CI_RUN_ID": "1", "CI_RUN_ATTEMPT": "1", "GITHUB_STEP_SUMMARY": "",
        })
        self.environment.start()
        self.addCleanup(self.environment.stop)
        cleanup = patch.object(ci, "clean_image")
        self.clean_image = cleanup.start()
        self.addCleanup(cleanup.stop)
        self.ptest_statuses = {}
        self.batch_status = 0
        batch = patch.object(ci, "run_ptest_batch", side_effect=self.run_ptest_batch)
        self.batch = batch.start()
        self.addCleanup(batch.stop)
        self.environment_inputs = {"version": 1, "layers": {"dependency": {"revision": "a" * 40}}}
        environment = patch.object(ci, "ptest_environment", side_effect=lambda *args: self.environment_inputs)
        self.environment_query = environment.start()
        self.addCleanup(environment.stop)

    def run_ptest_batch(self, repo, setup, targets, directory):
        for target in targets:
            recipe = target.removeprefix("meta-homeassistant-image-ptest-")
            status = self.ptest_statuses.get(recipe, "passed")
            if status is not None:
                (directory / target).write_text(status)
        return self.batch_status

    def git(self, *args):
        return planner.git(self.repo, *args)

    def commit(self, name, text):
        path = self.repo / name
        path.parent.mkdir(parents=True, exist_ok=True)
        path.write_text(text)
        self.git("add", "--", name)
        self.git("commit", "-qm", text)
        return self.git("rev-parse", "HEAD")

    def baseline(self, revision=None, ref=None):
        revision = revision or self.initial
        recipes = ["python3-one", "python3-two"]
        fingerprints = planner.recipe_fingerprints(self.repo, revision, recipes) if revision != "0" * 40 else {}
        return {
            "policy": planner.POLICY,
            "scope": {**ci.scope(), "ref": ref or os.environ["CI_REF"]},
            "revision": revision,
            "enabled_ptests": recipes,
            "ptest_results": {
                recipe: {
                    "fingerprint": fingerprints.get(recipe, "unavailable"), "status": "passed",
                    "environment": ci.hashlib.sha256(
                        json.dumps(self.environment_inputs, sort_keys=True).encode()
                    ).hexdigest(),
                }
                for recipe in recipes
            },
        }

    def save_baseline(self, baseline, name="main"):
        directory = self.state / "baselines"
        directory.mkdir(exist_ok=True)
        ci.write_json(directory / f"{name}.json", baseline)

    def report(self, **values):
        report = planner.plan(self.repo, self.baseline(), self.git("rev-parse", "HEAD"))
        report.update(scope=ci.scope(), revision=self.git("rev-parse", "HEAD"), results={})
        report["ptest_results"] = self.baseline()["ptest_results"]
        report.update(values)
        environment_key = ci.hashlib.sha256(
            json.dumps(self.environment_inputs, sort_keys=True).encode()
        ).hexdigest()
        fingerprints = planner.recipe_fingerprints(
            self.repo, report["revision"], list(report["ptest_results"]),
        )
        cache = ci.ptest_cache_path(self.state, report["scope"], environment_key)
        for recipe, result in report["ptest_results"].items():
            if (
                result.get("environment") == environment_key
                and result.get("fingerprint") == fingerprints[recipe]
                and result.get("status") in ("passed", "failed")
            ):
                path = cache / f"{fingerprints[recipe]}.json"
                if not path.exists():
                    cache.mkdir(parents=True, exist_ok=True)
                    ci.write_json(path, result)
        return report

    def test_accumulated_recipe_change_survives_documentation_commit(self):
        self.commit("recipes-devtools/python/python3-one_1.bb", "recipe")
        self.commit("README.md", "docs last")
        report = planner.plan(self.repo, self.baseline(), self.git("rev-parse", "HEAD"))
        self.assertEqual(report["recipes"], ["python3-one"])
        self.assertIn("README.md", report["changed_files"])

    def test_docs_and_shared_configuration_are_reported_as_non_recipe_changes(self):
        self.commit("conf/distro/homeassistant.conf", 'DISTRO_FEATURES = ""')
        self.commit("README.md", "documentation")
        report = planner.plan(self.repo, self.baseline(), self.git("rev-parse", "HEAD"))
        self.assertEqual(report["recipes"], [])
        self.assertEqual(report["changed_files"], ["README.md", "conf/distro/homeassistant.conf"])

    def test_homeassistant_build_configuration_change_is_reported(self):
        self.commit("configurations/homeassistant.conf.json", '{"version": "1"}')
        report = planner.plan(self.repo, self.baseline(), self.git("rev-parse", "HEAD"))
        self.assertEqual(report["recipes"], [])
        self.assertEqual(report["changed_files"], ["configurations/homeassistant.conf.json"])
        self.assertIn("configuration changed", report["reason"])

    def test_recipe_local_files_and_shared_include_chains(self):
        self.commit("recipes-devtools/python/python3-one_1.bb", "require common.inc")
        self.commit("recipes-devtools/python/python3-two_1.bb", "require wrapper.inc")
        self.commit("recipes-devtools/python/wrapper.inc", "require common.inc")
        self.commit("recipes-devtools/python/common.inc", "initial include")
        previous = self.baseline(self.git("rev-parse", "HEAD"))
        self.commit("recipes-devtools/python/common.inc", "updated include")
        self.commit("recipes-devtools/python/python3-one/run-ptest", "runner")
        report = planner.plan(self.repo, previous, self.git("rev-parse", "HEAD"))
        self.assertEqual(report["recipes"], ["python3-one", "python3-two"])

    def test_rename_and_deleted_recipe_are_detected(self):
        self.commit("recipes-devtools/python/python3-one_1.bb", "recipe")
        previous = self.baseline(self.git("rev-parse", "HEAD"))
        self.git("mv", "recipes-devtools/python/python3-one_1.bb",
                 "recipes-devtools/python/python3-one_2.bb")
        self.git("commit", "-qm", "upgrade")
        self.assertEqual(planner.plan(
            self.repo, previous, self.git("rev-parse", "HEAD")
        )["recipes"], ["python3-one"])
        previous = self.baseline(self.git("rev-parse", "HEAD"))
        self.git("rm", "recipes-devtools/python/python3-one_2.bb")
        self.git("commit", "-qm", "delete")
        self.assertEqual(planner.plan(
            self.repo, previous, self.git("rev-parse", "HEAD")
        )["recipes"], ["python3-one"])

    def test_first_run_has_no_validated_ancestor(self):
        report = planner.plan(self.repo, None, self.initial)
        self.assertIsNone(report["baseline_revision"])
        self.assertEqual(report["ptest_results"], {})

    def test_branch_uses_own_validated_ancestor(self):
        self.save_baseline(self.baseline())
        newer = self.commit("README.md", "newer")
        self.save_baseline(self.baseline(newer, "refs/heads/other"), "other")
        baseline = planner.find_baseline(self.repo, self.state / "baselines", ci.scope(), newer)
        self.assertEqual(baseline["revision"], self.initial)

    def test_new_branch_uses_nearest_validated_ancestor(self):
        self.save_baseline(self.baseline())
        newer = self.commit("README.md", "newer")
        self.save_baseline(self.baseline(newer, "refs/heads/other"), "other")
        with patch.dict(os.environ, {"CI_REF": "refs/heads/new"}):
            baseline = planner.find_baseline(self.repo, self.state / "baselines", ci.scope(), newer)
        self.assertEqual(baseline["revision"], newer)

    def test_superseded_run_cannot_regress_branch_baseline(self):
        newer = self.commit("README.md", "newer")
        self.save_baseline(self.baseline(newer))
        with self.assertRaisesRegex(RuntimeError, "Superseded"):
            planner.find_baseline(self.repo, self.state / "baselines", ci.scope(), self.initial)

    def test_new_branch_can_reuse_old_fork_after_main_has_advanced(self):
        baseline = self.baseline()
        history = self.state / "baselines/history"
        history.mkdir(parents=True)
        ci.write_json(history / "initial.json", baseline)
        newer = self.commit("README.md", "main advanced")
        self.save_baseline(self.baseline(newer))
        self.git("switch", "-qc", "feature", self.initial)
        feature = self.commit("README.md", "feature diverged")
        with patch.dict(os.environ, {"CI_REF": "refs/heads/feature"}):
            result = planner.find_baseline(
                self.repo, self.state / "baselines", ci.scope(), feature,
            )
        self.assertEqual(result["revision"], self.initial)

    def test_intentional_branch_rollback_can_be_validated(self):
        newer = self.commit("README.md", "newer")
        self.save_baseline(self.baseline(newer))
        self.git("switch", "-qc", "rollback", self.initial)
        with patch.dict(os.environ, {"CI_REF": "refs/heads/rollback"}):
            self.save_baseline(self.baseline(newer), "rollback")
            self.assertIsNone(planner.find_baseline(
                self.repo, self.state / "baselines", ci.scope(), self.initial,
            ))

    def test_diverged_unavailable_invalid_and_foreign_baselines_are_not_reused(self):
        other = self.commit("README.md", "other branch")
        self.save_baseline(self.baseline(other))
        self.git("switch", "-qc", "diverged", self.initial)
        self.commit("README.md", "diverged")
        self.save_baseline(self.baseline("0" * 40), "missing")
        self.save_baseline({**self.baseline(), "scope": {}}, "foreign")
        self.save_baseline({"policy": 0}, "old")
        (self.state / "baselines/broken.json").write_text("{")
        with contextlib.redirect_stdout(io.StringIO()):
            self.assertIsNone(planner.find_baseline(
                self.repo, self.state / "baselines", ci.scope(), self.git("rev-parse", "HEAD")
            ))

    def test_lock_excludes_other_runs_and_only_owner_can_release(self):
        (self.state / "validation.lock").touch()
        ci.acquire(self.state, timeout=0)
        with patch.dict(os.environ, {"CI_RUN_ID": "2"}):
            with self.assertRaisesRegex(RuntimeError, "locked"):
                ci.acquire(self.state, timeout=0)
            with self.assertRaisesRegex(RuntimeError, "does not own"):
                ci.assert_owner(self.state)
            ci.release(self.state)
        self.assertTrue((self.state / "build.lock").exists())
        ci.release(self.state)
        ci.acquire(self.state, timeout=0)
        ci.release(self.state)

    def test_changed_and_newly_enabled_ptests_only(self):
        self.commit("recipes-devtools/python/python3-one_1.bb", "changed recipe")
        report = self.report(recipes=["python3-one", "python3-disabled"])
        with (
            patch.object(ci, "get_variable", return_value="python3-two python3-one python3-new"),
            patch.object(ci, "validate") as build,
        ):
            ci.ptests(self.repo, self.root, self.state, report)
        self.assertEqual(report["selected_ptests"], ["python3-new", "python3-one"])
        self.assertEqual(self.batch.call_args.args[2], [
            "meta-homeassistant-image-ptest-python3-new",
            "meta-homeassistant-image-ptest-python3-one",
        ])
        self.batch.assert_called_once()
        build.assert_not_called()
        self.assertEqual(self.clean_image.call_count, 2)

    def test_no_changes_does_not_retest_dependencies(self):
        with (
            patch.object(ci, "get_variable", return_value="python3-one python3-two"),
            patch.object(ci, "validate") as build,
        ):
            ci.ptests(self.repo, self.root, self.state, self.report())
        build.assert_not_called()
        self.batch.assert_not_called()

    def test_legacy_results_without_provenance_are_revalidated(self):
        report = self.report(ptest_results={
            recipe: {"fingerprint": "previous", "status": "passed"}
            for recipe in ("python3-one", "python3-two")
        })
        with patch.object(ci, "get_variable", return_value="python3-one python3-two"):
            ci.ptests(self.repo, self.root, self.state, report)
        self.assertEqual(report["selected_ptests"], ["python3-one", "python3-two"])
        environments = list((self.state / "ptest-cache").glob("*/*/environment.json"))
        self.assertEqual(len(environments), 1)
        self.assertEqual(json.loads(environments[0].read_text()), self.environment_inputs)
        saved = json.loads(next(environments[0].parent.glob(
            report["ptest_results"]["python3-one"]["fingerprint"] + ".json"
        )).read_text())
        self.assertEqual(saved, report["ptest_results"]["python3-one"])
        self.assertEqual(saved["run"], ["test/ha", "1", "1"])

    def test_cache_provenance_mismatch_is_reported_instead_of_reused(self):
        cache = self.state / "ptest-cache"
        cache.mkdir()
        ci.write_json(cache / "fingerprint.json", {
            "status": "passed", "fingerprint": "fingerprint", "environment": "wrong",
        })
        with self.assertRaisesRegex(RuntimeError, "provenance does not match"):
            ci.reusable_ptest_results(cache, "expected", {"python3-one": "fingerprint"})

    def test_returning_layer_combination_reuses_history_across_branches(self):
        first = self.report(ptest_results={})
        with patch.object(ci, "get_variable", return_value="python3-one python3-two"):
            ci.ptests(self.repo, self.root, self.state, first)
            self.environment_inputs = {
                **self.environment_inputs, "layers": {"dependency": {"revision": "b" * 40}},
            }
            second = self.report(ptest_results=first["ptest_results"])
            ci.ptests(self.repo, self.root, self.state, second)
            self.assertEqual(second["selected_ptests"], ["python3-one", "python3-two"])
            self.assertNotEqual(first["ptest_environment"], second["ptest_environment"])
            self.environment_inputs = {
                **self.environment_inputs, "layers": {"dependency": {"revision": "a" * 40}},
            }
            self.commit("README.md", "unrelated documentation")
            with patch.dict(os.environ, {"CI_REF": "refs/heads/returning", "CI_RUN_ID": "2"}):
                returning = self.report(ptest_results={}, baseline_ptests=[])
                self.batch.reset_mock()
                ci.ptests(self.repo, self.root, self.state, returning)
        self.assertEqual(returning["selected_ptests"], [])
        self.batch.assert_not_called()
        self.assertEqual(returning["ptest_results"], first["ptest_results"])
        self.assertEqual(len(list((self.state / "ptest-cache").glob("*/*/environment.json"))), 2)

    def test_recipe_content_change_retests_only_that_recipe_and_can_be_reverted(self):
        recipe_path = "recipes-devtools/python/python3-one_1.bb"
        self.commit(recipe_path, "initial recipe")
        first = self.report(ptest_results={})
        with patch.object(ci, "get_variable", return_value="python3-one python3-two"):
            ci.ptests(self.repo, self.root, self.state, first)
            self.commit(recipe_path, "changed recipe")
            self.commit("README.md", "unrelated documentation")
            changed = self.report(ptest_results=first["ptest_results"])
            ci.ptests(self.repo, self.root, self.state, changed)
            self.assertEqual(changed["selected_ptests"], ["python3-one"])
            self.commit(recipe_path, "initial recipe")
            reverted = self.report(ptest_results=changed["ptest_results"])
            self.batch.reset_mock()
            ci.ptests(self.repo, self.root, self.state, reverted)
        self.batch.assert_not_called()
        self.assertEqual(reverted["ptest_results"], first["ptest_results"])

    def test_recipe_runner_permissions_and_content_are_fingerprinted(self):
        self.git("config", "core.filemode", "true")
        self.commit("recipes-devtools/python/python3-one_1.bb", "recipe")
        runner = "recipes-devtools/python/python3-one/run-ptest"
        self.commit(runner, "#!/bin/sh\n")
        recipes = ["python3-one", "python3-two"]
        before = planner.recipe_fingerprints(self.repo, self.git("rev-parse", "HEAD"), recipes)
        docs = self.commit("README.md", "documentation only")
        self.assertEqual(planner.recipe_fingerprints(self.repo, docs, recipes), before)
        (self.repo / runner).chmod(0o755)
        self.git("add", runner)
        self.git("commit", "-qm", "make test runner executable")
        permissions = planner.recipe_fingerprints(self.repo, self.git("rev-parse", "HEAD"), recipes)
        self.assertNotEqual(permissions["python3-one"], before["python3-one"])
        self.assertEqual(permissions["python3-two"], before["python3-two"])
        content = self.commit(runner, "#!/bin/sh\nexit 1\n")
        after = planner.recipe_fingerprints(self.repo, content, recipes)
        self.assertNotEqual(after["python3-one"], permissions["python3-one"])
        self.assertEqual(after["python3-two"], permissions["python3-two"])

    def test_pending_result_is_retried_but_successful_sibling_is_reused(self):
        first = self.report(ptest_results={})
        self.ptest_statuses = {"python3-one": None}
        with patch.object(ci, "get_variable", return_value="python3-one python3-two"):
            with self.assertRaisesRegex(RuntimeError, "python3-one"):
                ci.ptests(self.repo, self.root, self.state, first)
            self.ptest_statuses = {}
            following = self.report(ptest_results=first["ptest_results"])
            ci.ptests(self.repo, self.root, self.state, following)
        self.assertEqual(following["selected_ptests"], ["python3-one"])
        self.assertEqual(following["ptest_results"]["python3-two"], first["ptest_results"]["python3-two"])

    def test_environment_change_during_tests_does_not_archive_results(self):
        def change_environment(*args):
            self.environment_inputs = {**self.environment_inputs, "changed": True}
            return self.run_ptest_batch(*args)

        self.batch.side_effect = change_environment
        with patch.object(ci, "get_variable", return_value="python3-one"):
            with self.assertRaisesRegex(RuntimeError, "environment changed"):
                ci.ptests(self.repo, self.root, self.state, self.report(ptest_results={}))
        self.assertEqual(list((self.state / "ptest-cache").glob("*/*/*.json")),
                         list((self.state / "ptest-cache").glob("*/*/environment.json")))

    def test_environment_records_actual_layers_and_shared_metadata_not_documentation(self):
        setup = self.state / "bitbake-builds" / ci.CONFIGURATION
        (setup / "build/conf").mkdir(parents=True)
        (setup / "config").mkdir()
        layers = setup / "layers"
        layers.mkdir()
        (layers / "meta-homeassistant").symlink_to(self.repo, target_is_directory=True)
        dependency = layers / "dependency"
        REAL_RUN(["git", "clone", "--quiet", str(self.repo), str(dependency)], check=True)
        config = {
            "sources": {
                "meta-homeassistant": {"local": {"path": str(self.repo)}},
                "dependency": {"git-remote": {
                    "uri": str(self.repo), "branch": "main", "rev": self.initial,
                }},
            },
            "bitbake-setup": {"configurations": [{
                "name": ci.CONFIGURATION, "oe-fragments": ["machine/qemux86-64"],
            }]},
        }
        ci.write_json(self.state / "configuration.conf.json", config)
        resolved = {"sources": config["sources"]}
        ci.write_json(setup / "config/sources-fixed-revisions.json", resolved)
        (setup / "build/conf/local.conf").write_text('MACHINE = "qemux86-64"\n')
        (setup / "build/conf/bblayers.conf").write_text(f'BBLAYERS = "{layers}/dependency"\n')
        (setup.parent / "site.conf").write_text('DL_DIR = "/cache/downloads"\n')
        first = PTEST_ENVIRONMENT(self.repo, setup, self.state, self.initial)
        self.assertEqual(first["layers"]["dependency"]["revision"], self.initial)
        self.assertEqual(first["layers"]["dependency"]["origin"], str(self.repo))
        self.assertNotIn("meta-homeassistant", first["layers"])
        self.assertNotIn(str(setup), first["build_config"]["bblayers.conf"])
        docs_revision = self.commit("README.md", "new documentation")
        self.assertEqual(PTEST_ENVIRONMENT(self.repo, setup, self.state, docs_revision), first)
        shared_revision = self.commit("conf/distro/homeassistant.conf", 'DISTRO_FEATURES = "changed"')
        shared = PTEST_ENVIRONMENT(self.repo, setup, self.state, shared_revision)
        self.assertNotEqual(shared, first)
        (setup / "build/conf/local.conf").write_text('MACHINE = "qemuarm64"\n')
        self.assertNotEqual(PTEST_ENVIRONMENT(self.repo, setup, self.state, shared_revision), shared)

        REAL_RUN(["git", "-C", str(dependency), "fetch", "--quiet", "origin"], check=True)
        REAL_RUN(["git", "-C", str(dependency), "checkout", "--quiet",
                  "--detach", shared_revision], check=True)
        with self.assertRaisesRegex(RuntimeError, "expected resolved revision"):
            PTEST_ENVIRONMENT(self.repo, setup, self.state, shared_revision)
        resolved["sources"]["dependency"]["git-remote"]["rev"] = shared_revision
        ci.write_json(setup / "config/sources-fixed-revisions.json", resolved)
        with self.assertRaisesRegex(RuntimeError, "expected configured pin"):
            PTEST_ENVIRONMENT(self.repo, setup, self.state, shared_revision)
        config["sources"]["dependency"]["git-remote"]["rev"] = "main"
        ci.write_json(self.state / "configuration.conf.json", config)
        rolling = PTEST_ENVIRONMENT(self.repo, setup, self.state, shared_revision)
        self.assertEqual(rolling["layers"]["dependency"]["revision"], shared_revision)
        (dependency / "README.md").write_text("uncommitted changes")
        with self.assertRaisesRegex(RuntimeError, "tracked modifications"):
            PTEST_ENVIRONMENT(self.repo, setup, self.state, shared_revision)

    def test_image_validation_fingerprint_ignores_docs_and_tracks_build_inputs(self):
        setup = self.root / "setup"
        (setup / "build/conf").mkdir(parents=True)
        (setup / "config").mkdir()
        (setup / "build/conf/local.conf").write_text('MACHINE = "qemux86-64"\n')
        (setup / "config/sources-fixed-revisions.json").write_text('{"sources": {}}\n')
        environment = {"layers": {"dependency": {"revision": "a" * 40}}}
        with patch.object(ci, "ptest_environment", return_value=environment):
            initial = ci.image_validation_fingerprint(
                self.repo, setup, self.state, self.initial,
            )
            documentation = self.commit("docs/testing.md", "updated guide")
            self.assertEqual(
                ci.image_validation_fingerprint(self.repo, setup, self.state, documentation),
                initial,
            )
            (setup / "build/conf/local.conf").write_text('MACHINE = "qemuarm64"\n')
            self.assertNotEqual(
                ci.image_validation_fingerprint(self.repo, setup, self.state, documentation),
                initial,
            )
            (setup / "build/conf/local.conf").write_text('MACHINE = "qemux86-64"\n')
            changed = self.commit(
                "recipes-homeassistant/images/core-image-homeassistant-full.bb",
                "changed image input",
            )
            self.assertNotEqual(
                ci.image_validation_fingerprint(self.repo, setup, self.state, changed),
                initial,
            )
        with patch.object(ci, "ptest_environment", return_value=environment):
            unchanged_environment = ci.image_validation_fingerprint(
                self.repo, setup, self.state, changed,
            )
        with patch.object(ci, "ptest_environment", return_value={
            "layers": {"dependency": {"revision": "b" * 40}},
        }):
            self.assertNotEqual(
                ci.image_validation_fingerprint(self.repo, setup, self.state, changed),
                unchanged_environment,
            )

    def test_first_run_tests_every_enabled_dependency_in_one_batch(self):
        report = self.report(baseline_ptests=[], ptest_results={})
        with (
            patch.object(ci, "get_variable", return_value="python3-one python3-two"),
            patch.object(ci, "validate") as build,
        ):
            ci.ptests(self.repo, self.root, self.state, report)
        self.batch.assert_called_once()
        self.assertEqual(self.batch.call_args.args[2], [
            "meta-homeassistant-image-ptest-python3-one",
            "meta-homeassistant-image-ptest-python3-two",
        ])
        build.assert_not_called()

    def test_build_configuration_change_retests_all_saved_ptest_results(self):
        report = self.report(
            baseline_ptests=["python3-one", "python3-two"],
            ptest_results={
                "python3-one": {"fingerprint": "previous", "status": "failed"},
                "python3-two": {"fingerprint": "previous", "status": "passed"},
            },
        )
        with patch.object(ci, "get_variable", return_value="python3-one python3-two"):
            ci.ptests(self.repo, self.root, self.state, report)
        self.assertEqual(report["selected_ptests"], ["python3-one", "python3-two"])
        self.batch.assert_called_once()

    def test_ptest_failure_is_named_and_remaining_dependencies_still_run(self):
        report = self.report(baseline_ptests=[], ptest_results={})
        self.ptest_statuses = {"python3-one": "failed"}
        self.batch_status = 1
        with (
            patch.object(ci, "get_variable", return_value="python3-one python3-two"),
        ):
            with self.assertRaisesRegex(RuntimeError, "python3-one"):
                ci.ptests(self.repo, self.root, self.state, report)
        self.batch.assert_called_once()
        self.assertEqual(report["ptest_results"]["python3-one"]["status"], "failed")
        self.assertEqual(report["ptest_results"]["python3-two"]["status"], "passed")
        self.assertEqual(report["ptest_results"]["python3-one"]["revision"], report["revision"])
        self.assertEqual(report["ptest_results"]["python3-one"]["environment"], report["ptest_environment"])
        saved = json.loads((self.state / "run.json").read_text())["ptest_results"]
        self.assertEqual(saved, report["ptest_results"])
        self.clean_image.assert_called_once_with(
            self.repo, self.root, "meta-homeassistant-image-ptest-python3-two",
        )

    def test_followup_run_retries_failures_but_reuses_successful_dependencies(self):
        first = self.report(baseline_ptests=[], ptest_results={})
        self.ptest_statuses = {"python3-one": "failed"}
        self.batch_status = 1
        with (
            patch.object(ci, "get_variable", return_value="python3-one python3-two"),
        ):
            with self.assertRaisesRegex(RuntimeError, "python3-one"):
                ci.ptests(self.repo, self.root, self.state, first)

        followup = self.report(
            baseline_ptests=["python3-one", "python3-two"],
            ptest_results=first["ptest_results"],
        )
        self.ptest_statuses = {}
        self.batch_status = 0
        self.batch.reset_mock()
        with (
            patch.object(ci, "get_variable", return_value="python3-one python3-two"),
            patch.dict(os.environ, {"CI_RUN_ID": "2"}),
        ):
            ci.ptests(self.repo, self.root, self.state, followup)

        self.assertEqual(followup["selected_ptests"], ["python3-one"])
        self.batch.assert_called_once()
        self.assertEqual(followup["ptest_results"]["python3-two"]["status"], "passed")
        self.assertEqual(followup["ptest_results"]["python3-one"]["status"], "passed")
        self.assertEqual(followup["ptest_results"]["python3-one"]["run"], ["test/ha", "2", "1"])

    def test_failed_ptests_are_retried_after_image_baseline_advances(self):
        first = self.report(baseline_ptests=[], ptest_results={})
        self.ptest_statuses = {"python3-one": "failed"}
        self.batch_status = 1
        with (
            patch.object(ci, "get_variable", return_value="python3-one python3-two"),
        ):
            with self.assertRaisesRegex(RuntimeError, "python3-one"):
                ci.ptests(self.repo, self.root, self.state, first)

        first["results"] = {"prepare": "passed", "ptests": "failed", "image": "passed"}
        ci.finish(self.repo, self.state, first)
        self.assertEqual(json.loads(ci.baseline_path(self.state).read_text())["revision"], self.initial)

        self.commit("README.md", "later change")
        ci.make_plan(self.repo, self.state)
        followup = json.loads((self.state / "run.json").read_text())
        self.assertEqual(followup["baseline_revision"], self.initial)
        self.assertEqual(followup["ptest_results"], {})
        self.batch.reset_mock()
        with (
            patch.object(ci, "get_variable", return_value="python3-one python3-two"),
        ):
            with self.assertRaisesRegex(RuntimeError, "python3-one"):
                ci.ptests(self.repo, self.root, self.state, followup)
        self.assertEqual(followup["selected_ptests"], ["python3-one"])
        self.batch.assert_called_once()

    def test_changed_recipe_inputs_reselect_a_failed_dependency(self):
        recipe_path = "recipes-devtools/python/python3-one_1.bb"
        results = self.baseline()["ptest_results"]
        results["python3-one"]["status"] = "failed"
        self.commit(recipe_path, "recipe v1")
        report = self.report(
            recipes=["python3-one"],
            changed_files=[recipe_path],
            baseline_ptests=["python3-one", "python3-two"],
            ptest_results=results,
        )
        with patch.object(ci, "get_variable", return_value="python3-one python3-two"):
            ci.ptests(self.repo, self.root, self.state, report)
        self.assertEqual(report["selected_ptests"], ["python3-one"])
        self.assertEqual(self.batch.call_args.args[2], [
            "meta-homeassistant-image-ptest-python3-one",
        ])
        self.batch.assert_called_once()

    def test_empty_enabled_list_is_an_error(self):
        with patch.object(ci, "get_variable", return_value=""):
            with self.assertRaisesRegex(RuntimeError, "No enabled"):
                ci.ptests(self.repo, self.root, self.state, self.report())

    def test_missing_task_result_remains_pending_even_if_bitbake_returns_zero(self):
        report = self.report(baseline_ptests=[], ptest_results={})
        self.ptest_statuses = {"python3-one": None}
        with patch.object(ci, "get_variable", return_value="python3-one python3-two"):
            with self.assertRaisesRegex(RuntimeError, "python3-one"):
                ci.ptests(self.repo, self.root, self.state, report)
        self.assertEqual(report["ptest_results"]["python3-one"]["status"], "pending")
        self.assertEqual(report["ptest_results"]["python3-two"]["status"], "passed")
        self.assertEqual(
            json.loads((self.state / "run.json").read_text())["ptest_results"], report["ptest_results"],
        )
        self.clean_image.assert_called_once_with(
            self.repo, self.root, "meta-homeassistant-image-ptest-python3-two",
        )

    def test_non_test_task_failure_is_not_hidden_by_passing_tests(self):
        report = self.report(baseline_ptests=[], ptest_results={})
        self.batch_status = 1
        with patch.object(ci, "get_variable", return_value="python3-one"):
            with self.assertRaisesRegex(RuntimeError, "batch failed with status 1"):
                ci.ptests(self.repo, self.root, self.state, report)
        self.assertEqual(report["ptest_results"]["python3-one"]["status"], "passed")

    def test_invalid_task_result_is_an_error(self):
        self.ptest_statuses = {"python3-one": "invalid"}
        with patch.object(ci, "get_variable", return_value="python3-one"):
            with self.assertRaisesRegex(RuntimeError, "Invalid ptest task result"):
                ci.ptests(
                    self.repo, self.root, self.state,
                    self.report(baseline_ptests=[], ptest_results={}),
                )
        self.clean_image.assert_not_called()

    def test_batch_uses_one_keep_going_command_and_isolates_results(self):
        targets = [
            "meta-homeassistant-image-ptest-python3-one",
            "meta-homeassistant-image-ptest-python3-two",
        ]
        directories = []

        def run_batch(repo, setup, selected, directory):
            directories.append(directory)
            self.assertFalse((directory / targets[0]).exists())
            with patch.object(ci.subprocess, "run", return_value=subprocess.CompletedProcess([], 0)) as run:
                status = RUN_PTEST_BATCH(repo, setup, selected, directory)
            self.assertEqual(run.call_args.args[0][-6:], [
                "bitbake", "-k", "-R", str(directory / "results.conf"), *targets,
            ])
            self.assertFalse(run.call_args.kwargs["check"])
            self.assertNotIn("stdout", run.call_args.kwargs)
            configuration = (directory / "results.conf").read_text()
            self.assertIn('INHERIT += "ha-ci-ptest-results"', configuration)
            self.assertIn(json.dumps(str(directory)), configuration)
            event_class = directory / "classes/ha-ci-ptest-results.bbclass"
            self.assertTrue(event_class.is_file())
            self.assertIn('e.pn + "." + status + ".json"', event_class.read_text())
            self.assertIn('"logfile": e.logfile', event_class.read_text())
            self.run_ptest_batch(repo, setup, selected, directory)
            return status

        self.batch.side_effect = run_batch
        with patch.object(ci, "get_variable", return_value="python3-one python3-two"):
            for _ in range(2):
                self.environment_inputs = {**self.environment_inputs, "batch": len(directories)}
                ci.ptests(
                    self.repo, self.root, self.state,
                    self.report(baseline_ptests=[], ptest_results={}),
                )
        self.assertEqual(len(set(directories)), 2)
        self.assertTrue(all(not directory.exists() for directory in directories))

    def test_batch_does_not_pass_testimage_failure_reported_as_task_success(self):
        target = "meta-homeassistant-image-ptest-python3-one"

        def finish_bitbake(*args, **kwargs):
            logfile = self.root / "log.do_testimage"
            logfile.write_text(
                f"ERROR: {target}-1.0 do_testimage: {target} - FAILED - also check logs\n"
                f"NOTE: recipe {target}-1.0: task do_testimage: Succeeded\n"
            )
            (directory / f"{target}.passed.json").write_text(json.dumps({
                "status": "passed",
                "logfile": str(logfile),
            }))
            return subprocess.CompletedProcess(args[0], 0)

        directory = self.root / "ptest-batch"
        directory.mkdir()
        with patch.object(ci.subprocess, "run", side_effect=finish_bitbake):
            status = RUN_PTEST_BATCH(self.repo, self.root, [target], directory)

        self.assertEqual(status, 0)
        self.assertEqual((directory / target).read_text(), "failed")

    def test_image_baseline_advances_independently_of_pending_ptests(self):
        report = self.report(enabled_ptests=["python3-one"], ptest_results={
            "python3-one": {"fingerprint": "current", "status": "failed"},
        })
        for results in ({}, {"prepare": "passed", "image": "failed"}):
            report["results"] = results
            with self.assertRaisesRegex(RuntimeError, "image baseline unchanged"):
                ci.finish(self.repo, self.state, report)
            self.assertFalse(ci.baseline_path(self.state).exists())
        report["results"] = {"prepare": "passed", "ptests": "failed", "image": "passed"}
        report["results"]["integrations"] = "failed"
        ci.finish(self.repo, self.state, report)
        saved = json.loads(ci.baseline_path(self.state).read_text())
        self.assertEqual(saved["revision"], self.initial)
        self.assertEqual(saved["ptest_results"]["python3-one"]["status"], "failed")

    def test_changed_checkout_cannot_promote_image_baseline(self):
        report = self.report(
            results=dict.fromkeys(("prepare", "ptests", "image"), "passed"),
            enabled_ptests=["python3-one"],
            ptest_results={},
        )
        self.commit("README.md", "changed after build")
        with self.assertRaisesRegex(RuntimeError, "Checkout changed"):
            ci.finish(self.repo, self.state, report)
        self.assertFalse(ci.baseline_path(self.state).exists())

    def test_image_runs_even_when_ptests_failed(self):
        ci.acquire(self.state, timeout=0)
        report = self.report(results={"prepare": "passed", "ptests": "failed"})
        ci.write_json(self.state / "run.json", report)
        with (
            patch.object(ci, "image_validation_fingerprint", return_value="a" * 64),
            patch.object(ci, "validate") as build,
        ):
            ci.execute("image", self.repo, self.state)
        self.assertEqual(build.call_args.args[2], ci.TARGET)
        saved = json.loads((self.state / "run.json").read_text())
        self.assertEqual(saved["results"], {"prepare": "passed", "ptests": "failed", "image": "passed"})
        ci.release(self.state)

    def test_failed_build_is_recorded_before_execution(self):
        ci.acquire(self.state, timeout=0)
        ci.write_json(self.state / "run.json", self.report())
        with (
            patch.object(ci, "image_validation_fingerprint", return_value="a" * 64),
            patch.object(ci, "validate", side_effect=subprocess.CalledProcessError(7, "bitbake")),
        ):
            with self.assertRaises(subprocess.CalledProcessError):
                ci.execute("image", self.repo, self.state)
        self.assertEqual(json.loads((self.state / "run.json").read_text())["results"]["image"], "failed")
        self.assertFalse((self.state / "image-validation-cache").exists())
        ci.release(self.state)

    def test_successful_full_image_validation_is_reused_for_matching_inputs(self):
        ci.acquire(self.state, timeout=0)
        fingerprint = "a" * 64
        report = self.report(results={"prepare": "passed"})
        ci.write_json(self.state / "run.json", report)
        with (
            patch.object(ci, "image_validation_fingerprint", return_value=fingerprint),
            patch.object(ci, "validate") as build,
        ):
            ci.execute("image", self.repo, self.state)
            build.assert_called_once_with(
                self.repo, self.state / "bitbake-builds" / ci.CONFIGURATION, ci.TARGET,
            )
            cache = ci.image_validation_cache_path(self.state, report["scope"], fingerprint)
            self.assertEqual(json.loads(cache.read_text())["status"], "passed")

            next_report = self.report(results={"prepare": "passed"})
            ci.write_json(self.state / "run.json", next_report)
            build.reset_mock()
            ci.execute("image", self.repo, self.state)
            build.assert_not_called()
            reused = json.loads((self.state / "run.json").read_text())
            self.assertEqual(reused["image_validation"]["status"], "reused")
            self.assertEqual(reused["image_validation"]["validated_revision"], self.initial)

            changed_report = self.report(results={"prepare": "passed"})
            ci.write_json(self.state / "run.json", changed_report)
            build.reset_mock()
            with patch.object(ci, "image_validation_fingerprint", return_value="b" * 64):
                ci.execute("image", self.repo, self.state)
            build.assert_called_once()
        saved = json.loads((self.state / "run.json").read_text())
        self.assertEqual(saved["results"]["image"], "passed")
        self.assertEqual(saved["image_validation"]["status"], "built")
        ci.release(self.state)

    def test_cleanup_removes_historical_wrappers_but_preserves_caches_and_sources(self):
        ci.acquire(self.state, timeout=0)
        top = self.state / "bitbake-builds"
        top.mkdir()
        names = [
            ci.CONFIGURATION,
            f"{ci.CONFIGURATION}.previous-1794766073973581010",
            f"{ci.CONFIGURATION}.previous-1794768032252540482",
            f"{ci.CONFIGURATION}.previous-1794769730865733254",
            f"{ci.CONFIGURATION}.incomplete-1794766073973581010",
        ]
        for name in names:
            (top / name / "build").mkdir(parents=True)
            (top / name / "build/old-log").write_text("obsolete")
        shared = self.root / "downloads"
        shared.mkdir()
        (shared / "source.tar").write_text("shared download")
        (top / ci.CONFIGURATION / "source").symlink_to(self.repo, target_is_directory=True)
        (top / ci.CONFIGURATION / "downloads").symlink_to(shared, target_is_directory=True)
        preserved = [
            top / ".bitbake-setup-cache/setting",
            top / "site.conf",
            top / "other-wrapper/build/file",
            top / f"{ci.CONFIGURATION}.previous-not-a-timestamp/file",
            self.state / "ptest-cache/result.json",
            self.state / "baselines/history/result.json",
            self.root / "sstate-cache/object",
        ]
        for path in preserved:
            path.parent.mkdir(parents=True, exist_ok=True)
            path.write_text("keep")
        ci.cleanup_wrappers(self.state)
        self.assertTrue(all(not (top / name).exists() for name in names))
        for path in preserved:
            self.assertEqual(path.read_text(), "keep")
        self.assertEqual((shared / "source.tar").read_text(), "shared download")
        self.assertEqual(self.git("rev-parse", "HEAD"), self.initial)

    def test_cleanup_requires_own_lock(self):
        wrapper = self.state / "bitbake-builds" / ci.CONFIGURATION
        wrapper.mkdir(parents=True)
        with self.assertRaises(FileNotFoundError):
            ci.cleanup_wrappers(self.state)
        ci.acquire(self.state, timeout=0)
        with patch.dict(os.environ, {"CI_RUN_ID": "another-run"}):
            with self.assertRaisesRegex(RuntimeError, "does not own"):
                ci.cleanup_wrappers(self.state)
        self.assertTrue(wrapper.is_dir())

    def test_cleanup_rejects_symlinked_build_root_or_wrapper(self):
        ci.acquire(self.state, timeout=0)
        top = self.state / "bitbake-builds"
        top.symlink_to(self.repo, target_is_directory=True)
        with self.assertRaisesRegex(RuntimeError, "symlinked build directory"):
            ci.cleanup_wrappers(self.state)
        top.unlink()
        top.mkdir()
        (top / ci.CONFIGURATION).mkdir()
        (top / f"{ci.CONFIGURATION}.previous-123").symlink_to(self.repo, target_is_directory=True)
        with self.assertRaisesRegex(RuntimeError, "symlink wrapper"):
            ci.cleanup_wrappers(self.state)
        self.assertTrue((top / ci.CONFIGURATION).is_dir())
        (top / f"{ci.CONFIGURATION}.previous-123").unlink()
        (top / f"{ci.CONFIGURATION}.previous-123").write_text("not a directory")
        with self.assertRaisesRegex(RuntimeError, "non-directory or symlink wrapper"):
            ci.cleanup_wrappers(self.state)
        self.assertTrue((top / ci.CONFIGURATION).is_dir())
        self.assertEqual(self.git("rev-parse", "HEAD"), self.initial)

    def test_cleanup_stage_routes_without_a_plan_and_reports_failure(self):
        ci.acquire(self.state, timeout=0)
        stderr = io.StringIO()
        with patch.object(ci, "cleanup_wrappers", side_effect=RuntimeError("cleanup blocked")) as cleanup, \
                patch.object(sys, "argv", ["ci-validate.py", "cleanup",
                                          "--state-root", str(self.state)]), \
                contextlib.redirect_stderr(stderr):
            with self.assertRaises(SystemExit) as error:
                ci.main()
        self.assertEqual(error.exception.code, 1)
        cleanup.assert_called_once_with(self.state)
        self.assertIn("CI cleanup failed: cleanup blocked", stderr.getvalue())
        self.assertFalse((self.state / "run.json").exists())

    def test_prepare_uses_shared_wrapper_fragments_and_rm_work(self):
        ci.acquire(self.state, timeout=0)
        directory = self.repo / "configurations"
        directory.mkdir()
        (directory / "homeassistant.conf.json").write_text(json.dumps({
            "sources": {},
            "bitbake-setup": {"configurations": [
                {"name": ci.CONFIGURATION, "oe-fragments": ["machine/qemux86-64"]},
            ]},
        }))
        setup = self.state / "bitbake-builds" / ci.CONFIGURATION
        baseline = self.baseline()
        ci.baseline_path(self.state).parent.mkdir()
        ci.write_json(ci.baseline_path(self.state), baseline)
        ptest_results = baseline["ptest_results"]
        (self.state / "ptest-cache").mkdir(exist_ok=True)
        ci.write_json(self.state / "ptest-cache/preserved.json", ptest_results)
        report = self.report()
        ci.write_json(self.state / "run.json", report)

        def initialize(command, **kwargs):
            self.assertFalse(setup.exists())
            (setup / "build").mkdir(parents=True, exist_ok=True)
            (setup / "build/init-build-env").touch()
            (setup / "layers").mkdir(exist_ok=True)
            return subprocess.CompletedProcess(command, 0)

        with patch.object(ci.subprocess, "run", side_effect=initialize) as command:
            self.assertEqual(ci.prepare(self.repo, self.state, self.root / "bootstrap"), setup)
            self.assertIn("init", command.call_args.args[0])
            self.assertNotIn("--rebase-conflicts-strategy", command.call_args.args[0])
            ci.cleanup_wrappers(self.state)
            with patch.dict(os.environ, {"CI_REF": "refs/heads/another"}):
                self.assertEqual(ci.prepare(self.repo, self.state, self.root / "bootstrap"), setup)
            self.assertIn("init", command.call_args.args[0])
            self.assertNotIn("update", command.call_args.args[0])
            (setup / "build/init-build-env").unlink()
            marker = setup / "layers/obsolete-input"
            marker.write_text("discard incomplete setup")
            ci.cleanup_wrappers(self.state)
            self.assertEqual(ci.prepare(self.repo, self.state, self.root / "bootstrap"), setup)
            self.assertIn("init", command.call_args.args[0])
            self.assertNotIn("--rebase-conflicts-strategy", command.call_args.args[0])
            self.assertEqual(list(setup.parent.glob(f"{ci.CONFIGURATION}.previous-*")), [])
            self.assertFalse(marker.exists())
        config = json.loads((self.state / "configuration.conf.json").read_text())
        self.assertEqual(config["sources"]["meta-homeassistant"]["local"]["path"], str(self.repo))
        self.assertEqual(config["bitbake-setup"]["configurations"][0]["oe-fragments"],
                         ["machine/qemux86-64", *ci.TEST_FRAGMENTS])
        self.assertEqual(ci.TEST_FRAGMENTS, (
            "homeassistant/enable-testing-base",
            "homeassistant/add-homeassistant-image-test-deps",
        ))
        self.assertIn('INHERIT += "rm_work"', (setup.parent / "site.conf").read_text())
        self.assertIn('TEST_LOG_DIR = "${TOPDIR}/ci-test-logs/${PN}"',
                      (setup.parent / "site.conf").read_text())
        self.assertEqual(json.loads(ci.baseline_path(self.state).read_text()), baseline)
        self.assertEqual(json.loads((self.state / "ptest-cache/preserved.json").read_text()), ptest_results)
        self.assertEqual(json.loads((self.state / "run.json").read_text()), report)

    def test_prepare_restores_exact_pin_and_discards_obsolete_checkout(self):
        ci.acquire(self.state, timeout=0)
        directory = self.repo / "configurations"
        directory.mkdir()
        (directory / "homeassistant.conf.json").write_text(json.dumps({
            "sources": {"dependency": {"git-remote": {
                "uri": str(self.repo), "branch": "main", "rev": self.initial,
            }}},
            "bitbake-setup": {"configurations": [
                {"name": ci.CONFIGURATION, "oe-fragments": []},
            ]},
        }))
        newer = self.commit("fork-file", "fork changes")
        setup = self.state / "bitbake-builds" / ci.CONFIGURATION
        (setup / "build").mkdir(parents=True)
        (setup / "build/init-build-env").touch()
        layer = setup / "layers/dependency"
        layer.parent.mkdir()
        REAL_RUN(["git", "clone", "--quiet", str(self.repo), str(layer)], check=True)
        (layer / "untracked-work").write_text("obsolete work")

        ci.cleanup_wrappers(self.state)

        def initialize(command, **kwargs):
            if command[0] == "git":
                return REAL_RUN(command, **kwargs)
            self.assertFalse(layer.exists())
            self.assertIn("init", command)
            self.assertNotIn("update", command)
            self.assertFalse(setup.exists())
            self.assertEqual(list(setup.parent.glob(f"{ci.CONFIGURATION}.previous-*")), [])
            (setup / "build").mkdir(parents=True)
            (setup / "build/init-build-env").touch()
            layer.parent.mkdir()
            REAL_RUN(["git", "clone", "--quiet", str(self.repo), str(layer)], check=True)
            REAL_RUN(["git", "-C", str(layer), "checkout", "--quiet",
                      "--detach", self.initial], check=True)
            return subprocess.CompletedProcess(command, 0)

        with patch.object(ci.subprocess, "run", side_effect=initialize):
            ci.prepare(self.repo, self.state, self.root / "bootstrap")
        self.assertEqual(planner.git(layer, "rev-parse", "HEAD"), self.initial)
        ci.cleanup_wrappers(self.state)
        with patch.object(ci.subprocess, "run", side_effect=initialize):
            ci.prepare(self.repo, self.state, self.root / "bootstrap")
        self.assertEqual(list(setup.parent.glob(f"{ci.CONFIGURATION}.previous-*")), [])

        REAL_RUN(["git", "-C", str(layer), "checkout", "--quiet", "--detach", newer], check=True)
        ci.cleanup_wrappers(self.state)

        def wrong_checkout(command, **kwargs):
            if command[0] == "git":
                return REAL_RUN(command, **kwargs)
            (setup / "build").mkdir(parents=True)
            (setup / "build/init-build-env").touch()
            layer.parent.mkdir()
            REAL_RUN(["git", "clone", "--quiet", str(self.repo), str(layer)], check=True)
            return subprocess.CompletedProcess(command, 0)

        with patch.object(ci.subprocess, "run", side_effect=wrong_checkout):
            with self.assertRaisesRegex(RuntimeError, "expected configured pin"):
                ci.prepare(self.repo, self.state, self.root / "bootstrap")

    def test_build_preserves_arguments_and_streams_output(self):
        setup = self.root / "wrapper with spaces"
        (setup / "build").mkdir(parents=True)
        (setup / "build/init-build-env").write_text(
            'set -- replaced ignored\n'
            'bitbake() { test "$#" -eq 1 && test "$1" = core-image-homeassistant-full; }\n'
        )
        ci.validate(self.repo, setup, ci.TARGET)
        with patch.object(ci.subprocess, "run") as run:
            ci.validate(self.repo, setup, ci.TARGET)
        self.assertTrue(run.call_args.kwargs["check"])
        self.assertNotIn("stdout", run.call_args.kwargs)

    def test_variable_query_excludes_environment_banner(self):
        setup = self.root / "wrapper"
        (setup / "build").mkdir(parents=True)
        (setup / "build/init-build-env").write_text(
            'echo "Build environment ready"\n'
            'set -- replaced\n'
            'bitbake-getvar() { printf "python3-one python3-two\\n"; }\n'
        )
        self.assertEqual(
            ci.get_variable(self.repo, setup, "meta-homeassistant-image-ptest", "PTESTS_META_HOMEASSISTANT"),
            "python3-one python3-two",
        )

    def test_failed_variable_query_reports_captured_bitbake_error(self):
        setup = self.root / "wrapper"
        (setup / "build").mkdir(parents=True)
        (setup / "build/init-build-env").write_text(
            'bitbake-getvar() { echo "ERROR: Unable to parse recipe"; return 7; }\n'
        )
        stderr = io.StringIO()

        def query(*args):
            ci.get_variable(self.repo, setup, "meta-homeassistant-image-ptest",
                            "PTESTS_META_HOMEASSISTANT")

        with patch.object(ci, "execute", side_effect=query), \
                patch.object(sys, "argv", ["ci-validate.py", "ptests",
                                          "--state-root", str(self.state)]), \
                contextlib.redirect_stderr(stderr):
            with self.assertRaises(SystemExit) as error:
                ci.main()
        self.assertEqual(error.exception.code, 1)
        self.assertIn("ERROR: Unable to parse recipe", stderr.getvalue())
        self.assertIn("CI ptests failed:", stderr.getvalue())

    def test_pipeline_and_new_branch_reuse_the_same_build_without_retesting(self):
        setup = self.state / "bitbake-builds" / ci.CONFIGURATION
        (setup / "build").mkdir(parents=True)
        commands = self.root / "build-commands"
        def initialize_wrapper(repo, state, bootstrap):
            (setup / "build").mkdir(parents=True)
            (setup / "build/init-build-env").write_text(
                'set -- changed-by-wrapper\n'
                'bitbake-getvar() { printf "python3-one python3-two\\n"; }\n'
                'bitbake() { printf "%s\\n" "$*" >> ' + shlex.quote(str(commands)) + '; }\n'
            )
            return setup

        def clone_only(command, **kwargs):
            if command[:2] == ["git", "clone"]:
                return subprocess.CompletedProcess(command, 0)
            return REAL_RUN(command, **kwargs)

        for ref in ("refs/heads/main", "refs/heads/new-branch"):
            with patch.dict(os.environ, {"CI_REF": ref}):
                ci.execute("acquire", self.repo, self.state)
                try:
                    ci.execute("plan", self.repo, self.state)
                    ci.execute("cleanup", self.repo, self.state)
                    with (
                        patch.object(ci, "prepare", side_effect=initialize_wrapper),
                        patch.object(ci.subprocess, "run", side_effect=clone_only),
                    ):
                        ci.execute("prepare", self.repo, self.state)
                    ci.execute("ptests", self.repo, self.state)
                    ci.execute("image", self.repo, self.state)
                    ci.execute("finish", self.repo, self.state)
                finally:
                    ci.execute("release", self.repo, self.state)
                self.assertTrue(ci.baseline_path(self.state).is_file())
        self.assertEqual(commands.read_text().splitlines(), [
            ci.TARGET,
        ])
        self.batch.assert_called_once()
        self.assertEqual(self.clean_image.call_count, 2)
        self.assertEqual(len(list((self.state / "baselines").glob("*.json"))), 2)
        self.assertFalse((self.state / "build.lock").exists())

    def test_successful_image_cleanup_uses_clean_not_cleansstate(self):
        setup = self.root / "wrapper"
        with patch.object(ci.subprocess, "run") as run:
            CLEAN_IMAGE(self.repo, setup, "meta-homeassistant-image-ptest-python3-one")
        self.assertEqual(
            run.call_args.args[0][-4:],
            ["bitbake", "-c", "clean", "meta-homeassistant-image-ptest-python3-one"],
        )
        self.assertTrue(run.call_args.kwargs["check"])

    def test_workflow_independent_required_steps_and_unconditional_release(self):
        workflow = (Path(__file__).resolve().parents[2] / ".gitea/workflows/build-HA.yaml").read_text()
        for stage in ("acquire", "plan", "cleanup", "prepare", "ptests", "image", "finish", "release"):
            self.assertIn(f"ci-validate.py {stage} ", workflow)
        self.assertIn(
            "- name: Clean obsolete build wrappers\n"
            "        id: cleanup\n"
            "        shell: bash\n"
            "        run: python3 scripts/ci-validate.py cleanup --state-root \"$CI_STATE_ROOT\"",
            workflow,
        )
        self.assertLess(workflow.index("ci-validate.py plan "), workflow.index("ci-validate.py cleanup "))
        self.assertLess(workflow.index("ci-validate.py cleanup "), workflow.index("ci-validate.py prepare "))
        self.assertIn("!cancelled() && steps.prepare.outcome == 'success'", workflow)
        self.assertIn("- name: Release shared build\n        if: always()", workflow)


if __name__ == "__main__":
    unittest.main()
