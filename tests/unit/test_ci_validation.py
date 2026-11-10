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
        return {
            "policy": planner.POLICY,
            "scope": {**ci.scope(), "ref": ref or os.environ["CI_REF"]},
            "revision": revision or self.initial,
            "enabled_ptests": ["python3-one", "python3-two"],
            "ptest_results": {
                recipe: {"fingerprint": "previous", "status": "passed"}
                for recipe in ("python3-one", "python3-two")
            },
        }

    def save_baseline(self, baseline, name="main"):
        directory = self.state / "baselines"
        directory.mkdir(exist_ok=True)
        ci.write_json(directory / f"{name}.json", baseline)

    def report(self, **values):
        report = planner.plan(self.repo, self.baseline(), self.git("rev-parse", "HEAD"))
        report.update(scope=ci.scope(), revision=self.git("rev-parse", "HEAD"), results={})
        report.update(values)
        return report

    def test_accumulated_recipe_change_survives_documentation_commit(self):
        self.commit("recipes-devtools/python/python3-one_1.bb", "recipe")
        self.commit("README.md", "docs last")
        report = planner.plan(self.repo, self.baseline(), self.git("rev-parse", "HEAD"))
        self.assertEqual(report["recipes"], ["python3-one"])
        self.assertFalse(report["all_ptests"])

    def test_docs_and_shared_configuration_do_not_select_all_dependencies(self):
        self.commit("conf/distro/homeassistant.conf", 'DISTRO_FEATURES = ""')
        self.commit("README.md", "documentation")
        report = planner.plan(self.repo, self.baseline(), self.git("rev-parse", "HEAD"))
        self.assertEqual(report["recipes"], [])
        self.assertFalse(report["all_ptests"])

    def test_homeassistant_build_configuration_change_selects_all_ptests(self):
        self.commit("configurations/homeassistant.conf.json", '{"version": "1"}')
        report = planner.plan(self.repo, self.baseline(), self.git("rev-parse", "HEAD"))
        self.assertEqual(report["recipes"], [])
        self.assertTrue(report["all_ptests"])
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

    def test_first_run_selects_all(self):
        self.assertTrue(planner.plan(self.repo, None, self.initial)["all_ptests"])

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

    def test_first_run_tests_every_enabled_dependency_in_one_batch(self):
        report = self.report(all_ptests=True, baseline_ptests=[], ptest_results={})
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
            all_ptests=True,
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
        report = self.report(all_ptests=True, baseline_ptests=[], ptest_results={})
        self.ptest_statuses = {"python3-one": "failed"}
        self.batch_status = 1
        with (
            patch.object(ci, "get_variable", return_value="python3-one python3-two"),
        ):
            with self.assertRaisesRegex(RuntimeError, "python3-one"):
                ci.ptests(self.repo, self.root, self.state, report)
        self.batch.assert_called_once()
        self.assertEqual(report["ptest_results"], {
            "python3-one": {"fingerprint": report["ptest_results"]["python3-one"]["fingerprint"],
                            "status": "failed"},
            "python3-two": {"fingerprint": report["ptest_results"]["python3-two"]["fingerprint"],
                            "status": "passed"},
        })
        saved = json.loads(ci.ptest_state_path(self.state).read_text())
        self.assertEqual(saved, report["ptest_results"])
        self.clean_image.assert_called_once_with(
            self.repo, self.root, "meta-homeassistant-image-ptest-python3-two",
        )

    def test_followup_run_does_not_retry_unchanged_failed_dependencies(self):
        first = self.report(all_ptests=True, baseline_ptests=[], ptest_results={})
        self.ptest_statuses = {"python3-one": "failed"}
        self.batch_status = 1
        with (
            patch.object(ci, "get_variable", return_value="python3-one python3-two"),
        ):
            with self.assertRaisesRegex(RuntimeError, "python3-one"):
                ci.ptests(self.repo, self.root, self.state, first)

        followup = self.report(
            baseline_ptests=["python3-one", "python3-two"],
            ptest_results=json.loads(ci.ptest_state_path(self.state).read_text()),
        )
        self.ptest_statuses = {}
        self.batch_status = 0
        self.batch.reset_mock()
        with (
            patch.object(ci, "get_variable", return_value="python3-one python3-two"),
        ):
            with self.assertRaisesRegex(RuntimeError, "python3-one"):
                ci.ptests(self.repo, self.root, self.state, followup)

        self.assertEqual(followup["selected_ptests"], [])
        self.batch.assert_not_called()
        self.assertEqual(followup["ptest_results"]["python3-two"]["status"], "passed")
        self.assertEqual(followup["ptest_results"]["python3-one"]["status"], "failed")

    def test_failed_ptests_are_not_retried_after_image_baseline_advances(self):
        first = self.report(all_ptests=True, baseline_ptests=[], ptest_results={})
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
        self.assertEqual(followup["ptest_results"]["python3-one"]["status"], "failed")
        self.batch.reset_mock()
        with (
            patch.object(ci, "get_variable", return_value="python3-one python3-two"),
        ):
            with self.assertRaisesRegex(RuntimeError, "python3-one"):
                ci.ptests(self.repo, self.root, self.state, followup)
        self.assertEqual(followup["selected_ptests"], [])
        self.batch.assert_not_called()

    def test_changed_recipe_inputs_reselect_a_failed_dependency(self):
        recipe_path = "recipes-devtools/python/python3-one_1.bb"
        self.commit(recipe_path, "recipe v1")
        report = self.report(
            recipes=["python3-one"],
            changed_files=[recipe_path],
            baseline_ptests=["python3-one", "python3-two"],
            ptest_results={
                "python3-one": {"fingerprint": "previous", "status": "failed"},
                "python3-two": {"fingerprint": "previous", "status": "passed"},
            },
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
            json.loads(ci.ptest_state_path(self.state).read_text()), report["ptest_results"],
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
            self.assertTrue((directory / "classes/ha-ci-ptest-results.bbclass").is_file())
            self.run_ptest_batch(repo, setup, selected, directory)
            return status

        self.batch.side_effect = run_batch
        with patch.object(ci, "get_variable", return_value="python3-one python3-two"):
            for _ in range(2):
                ci.ptests(
                    self.repo, self.root, self.state,
                    self.report(baseline_ptests=[], ptest_results={}),
                )
        self.assertEqual(len(set(directories)), 2)
        self.assertTrue(all(not directory.exists() for directory in directories))

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
        with patch.object(ci, "validate") as build:
            ci.execute("image", self.repo, self.state)
        self.assertEqual(build.call_args.args[2], ci.TARGET)
        saved = json.loads((self.state / "run.json").read_text())
        self.assertEqual(saved["results"], {"prepare": "passed", "ptests": "failed", "image": "passed"})
        ci.release(self.state)

    def test_failed_build_is_recorded_before_execution(self):
        ci.acquire(self.state, timeout=0)
        ci.write_json(self.state / "run.json", self.report())
        with patch.object(ci, "validate", side_effect=subprocess.CalledProcessError(7, "bitbake")):
            with self.assertRaises(subprocess.CalledProcessError):
                ci.execute("image", self.repo, self.state)
        self.assertEqual(json.loads((self.state / "run.json").read_text())["results"]["image"], "failed")
        ci.release(self.state)

    def test_prepare_uses_shared_wrapper_fragments_and_rm_work(self):
        directory = self.repo / "configurations"
        directory.mkdir()
        (directory / "homeassistant.conf.json").write_text(json.dumps({
            "sources": {},
            "bitbake-setup": {"configurations": [
                {"name": ci.CONFIGURATION, "oe-fragments": ["machine/qemux86-64"]},
            ]},
        }))
        setup = self.state / "bitbake-builds" / ci.CONFIGURATION

        def initialize(command, **kwargs):
            (setup / "build").mkdir(parents=True, exist_ok=True)
            (setup / "build/init-build-env").touch()
            (setup / "layers").mkdir(exist_ok=True)
            return subprocess.CompletedProcess(command, 0)

        with patch.object(ci.subprocess, "run", side_effect=initialize) as command:
            self.assertEqual(ci.prepare(self.repo, self.state, self.root / "bootstrap"), setup)
            self.assertIn("init", command.call_args.args[0])
            with patch.dict(os.environ, {"CI_REF": "refs/heads/another"}):
                self.assertEqual(ci.prepare(self.repo, self.state, self.root / "bootstrap"), setup)
            self.assertIn("update", command.call_args.args[0])
            (setup / "build/init-build-env").unlink()
            marker = setup / "layers/preserved-input"
            marker.write_text("keep incomplete setup")
            self.assertEqual(ci.prepare(self.repo, self.state, self.root / "bootstrap"), setup)
            self.assertIn("init", command.call_args.args[0])
            preserved = list(setup.parent.glob(f"{ci.CONFIGURATION}.incomplete-*"))
            self.assertEqual(len(preserved), 1)
            self.assertEqual(
                (preserved[0] / "layers/preserved-input").read_text(),
                "keep incomplete setup",
            )
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

    def test_pipeline_and_new_branch_reuse_the_same_build_without_retesting(self):
        setup = self.state / "bitbake-builds" / ci.CONFIGURATION
        (setup / "build").mkdir(parents=True)
        commands = self.root / "build-commands"
        (setup / "build/init-build-env").write_text(
            'set -- changed-by-wrapper\n'
            'bitbake-getvar() { printf "python3-one python3-two\\n"; }\n'
            'bitbake() { printf "%s\\n" "$*" >> ' + shlex.quote(str(commands)) + '; }\n'
        )

        def clone_only(command, **kwargs):
            if command[:2] == ["git", "clone"]:
                return subprocess.CompletedProcess(command, 0)
            return REAL_RUN(command, **kwargs)

        for ref in ("refs/heads/main", "refs/heads/new-branch"):
            with patch.dict(os.environ, {"CI_REF": ref}):
                ci.execute("acquire", self.repo, self.state)
                try:
                    ci.execute("plan", self.repo, self.state)
                    with (
                        patch.object(ci, "prepare", return_value=setup),
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
            ci.TARGET, ci.TARGET,
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
        for stage in ("acquire", "plan", "prepare", "ptests", "image", "finish", "release"):
            self.assertIn(f"ci-validate.py {stage} ", workflow)
        self.assertIn("!cancelled() && steps.prepare.outcome == 'success'", workflow)
        self.assertIn("- name: Release shared build\n        if: always()", workflow)


if __name__ == "__main__":
    unittest.main()
