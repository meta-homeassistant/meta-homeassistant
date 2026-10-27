#!/usr/bin/env python3
"""Offline regression tests for the image-validation baseline."""

import contextlib
import copy
import hashlib
import importlib
import io
import json
import multiprocessing
import os
from pathlib import Path
import subprocess
import sys
import tempfile
import unittest
from unittest.mock import patch


sys.path.insert(0, str(Path(__file__).resolve().parents[2] / "scripts"))
ci = importlib.import_module("ci-validate")
REAL_RUN = subprocess.run


class ValidationTests(unittest.TestCase):
    def setUp(self):
        self.temporary = tempfile.TemporaryDirectory(prefix="ha-ci-test-")
        self.addCleanup(self.temporary.cleanup)
        self.root = Path(self.temporary.name)
        self.repo = self.root / "repo"
        self.repo.mkdir()
        self.command("init", "-q", "-b", "test")
        self.command("config", "user.name", "CI tests")
        self.command("config", "user.email", "ci@example.invalid")
        self.command("remote", "add", "origin", str(self.repo))
        self.initial = self.commit("README.md", "initial")
        self.scope = {"repository": "test/ha", "ref": "refs/heads/test", "configuration": ci.CONFIGURATION}
        self.inputs = {"sources": {"oe-core": "one"}, "builder": "test"}
        self.baseline = self.manifest(self.initial)
        self.state_root = self.root / "state"
        key = hashlib.sha256(json.dumps(self.scope, sort_keys=True).encode()).hexdigest()
        self.state = self.state_root / key
        self.state.mkdir(parents=True)
        self.baseline_path = self.state / "validated.json"

    def command(self, *args):
        return ci.git(self.repo, *args)

    def commit(self, path, text):
        target = self.repo / path
        target.parent.mkdir(parents=True, exist_ok=True)
        target.write_text(text)
        self.command("add", "--", path)
        self.command("commit", "-qm", text)
        return self.command("rev-parse", "HEAD")

    def manifest(self, revision):
        return {
            "policy": ci.POLICY, "scope": self.scope,
            "revision": revision, "inputs": copy.deepcopy(self.inputs),
        }

    def decision(self, baseline=None, force=False):
        return ci.plan(
            self.repo, self.baseline if baseline is None else baseline,
            self.manifest(self.command("rev-parse", "HEAD")), force,
        )

    def test_accumulated_recipe_change_survives_final_documentation_commit(self):
        self.commit("recipes-homeassistant/homeassistant/ha.bb", "dependency change")
        self.commit("README.md", "documentation last")
        result = self.decision()
        self.assertEqual(result["mode"], "validate")
        self.assertEqual(result["changed_files"], ["README.md", "recipes-homeassistant/homeassistant/ha.bb"])

    def test_documentation_skip_and_identical_inputs(self):
        self.commit("README.md", "documentation")
        self.commit(".vscode/tasks.json", "{}")
        self.assertEqual(self.decision()["mode"], "skip")

    def test_unknown_and_test_paths_fail_closed(self):
        for name in ("tests/image/test-pytest-plain.sh", "tests/unit/test_ci_validation.py",
                     "dynamic-layers/x/test.bbappend",
                     "recipes-support/test.bbappend", "sources/bitbake", "unknown-file"):
            with self.subTest(path=name):
                previous = self.manifest(self.command("rev-parse", "HEAD"))
                self.commit(name, name)
                self.assertEqual(self.decision(previous)["mode"], "validate")

    def test_deletions_and_renames_are_not_skipped(self):
        self.commit("recipes-devtools/python/test_1.bb", "recipe")
        previous = self.manifest(self.command("rev-parse", "HEAD"))
        self.command("mv", "recipes-devtools/python/test_1.bb", "README.md.new")
        self.command("commit", "-qm", "rename")
        self.assertEqual(self.decision(previous)["mode"], "validate")
        previous = self.manifest(self.command("rev-parse", "HEAD"))
        self.command("rm", "README.md.new")
        self.command("commit", "-qm", "delete")
        self.assertEqual(self.decision(previous)["mode"], "validate")

    def test_missing_incompatible_and_unavailable_baselines(self):
        current = self.manifest(self.initial)
        self.assertEqual(ci.plan(self.repo, None, current)["mode"], "validate")
        for change in ({"policy": 0}, {"scope": {}}, {"revision": "0" * 40}, {"revision": None}):
            with self.subTest(change=change):
                previous = {**self.baseline, **change}
                self.assertEqual(ci.plan(self.repo, previous, current)["mode"], "validate")

    def test_diverged_history_requires_validation(self):
        self.commit("README.md", "old branch")
        previous = self.manifest(self.command("rev-parse", "HEAD"))
        self.command("switch", "-qc", "rewritten", self.initial)
        self.commit("README.md", "new branch")
        self.assertEqual(self.decision(previous)["mode"], "validate")

    def test_input_changes_force_validation_even_without_a_layer_change(self):
        for key, value in (("sources", {"oe-core": "two"}), ("builder", "new"),
                           ("configuration", {"local.conf": "new"})):
            with self.subTest(input=key):
                current = self.manifest(self.initial)
                current["inputs"][key] = value
                self.assertEqual(ci.plan(self.repo, self.baseline, current)["mode"], "validate")

    def test_schedule_and_manual_runs_force_validation(self):
        self.assertEqual(self.decision(force=True)["mode"], "validate")

    def test_older_run_cannot_replace_a_validated_descendant(self):
        newer = self.commit("README.md", "newer")
        with self.assertRaisesRegex(RuntimeError, "Superseded"):
            ci.reject_stale_run(self.repo, self.manifest(newer), self.initial, self.scope["ref"])

    def test_intentional_branch_rollback_is_validated_instead_of_rejected(self):
        newer = self.commit("README.md", "newer")
        self.command("branch", "rollback", self.initial)
        ci.reject_stale_run(
            self.repo, self.manifest(newer), self.initial, "refs/heads/rollback",
        )
        decision = ci.plan(self.repo, self.manifest(newer), self.manifest(self.initial))
        self.assertEqual(decision["mode"], "validate")

    def test_invalid_baseline_is_reported_and_requires_validation(self):
        self.baseline_path.write_text("{broken")
        output = io.StringIO()
        with contextlib.redirect_stdout(output):
            self.assertIsNone(ci.read_baseline(self.baseline_path))
        self.assertIn("Invalid baseline", output.getvalue())

    def test_result_log_and_report_omit_runner_and_build_input_details(self):
        report_path = self.root / "private-state" / "report.json"
        report_path.parent.mkdir()
        step_summary = self.root / "step-summary.md"
        report = {
            "mode": "validate",
            "reason": "Resolved sources, build configuration or builder changed",
        }
        with (
            patch.dict(os.environ, {"GITHUB_STEP_SUMMARY": str(step_summary)}),
            contextlib.redirect_stdout(io.StringIO()) as output,
        ):
            ci.record_result(report_path, report, "failed")
        public_output = output.getvalue() + step_summary.read_text()
        saved_report = report_path.read_text()
        for private_value in (str(self.root), "test/ha", self.initial, "oe-core"):
            self.assertNotIn(private_value, public_output)
            self.assertNotIn(private_value, saved_report)
        self.assertIn("core-image-homeassistant-full", public_output)

    def fake_clone(self, command, **kwargs):
        if command[:2] == ["git", "clone"]:
            return subprocess.CompletedProcess(command, 0)
        return REAL_RUN(command, **kwargs)

    def execute(self, validation=None, snapshots=None, run_id="1"):
        with (
            patch.object(ci.subprocess, "run", side_effect=self.fake_clone),
            patch.object(ci, "prepare", return_value=self.root / "setup"),
            patch.object(ci, "snapshot", side_effect=snapshots, return_value=self.inputs),
            patch.object(ci, "validate", side_effect=validation) as validate,
            patch.dict(os.environ, {"GITHUB_STEP_SUMMARY": ""}),
            contextlib.redirect_stdout(io.StringIO()),
        ):
            ci.run(self.repo, self.state_root, self.scope, run_id, "test", False)
            return validate

    def test_success_promotes_and_documentation_does_not_advance_baseline(self):
        self.execute().assert_called_once()
        original = self.baseline_path.read_bytes()
        self.commit("README.md", "docs after success")
        self.execute(run_id="2").assert_not_called()
        self.assertEqual(self.baseline_path.read_bytes(), original)
        self.assertEqual(len(list((self.state / "reports").glob("*.json"))), 2)
        reports = [json.loads(path.read_text()) for path in (self.state / "reports").glob("*.json")]
        self.assertIn("not-required", [report["result"] for report in reports])
        self.assertTrue(all(set(report) == {"mode", "reason", "result"} for report in reports))

    def test_failure_leaves_previous_baseline_and_next_run_retests_changes(self):
        ci.write_json(self.baseline_path, self.baseline)
        original = self.baseline_path.read_bytes()
        self.commit("recipes-homeassistant/ha.bb", "needs validation")
        failure = subprocess.CalledProcessError(1, ["bitbake", ci.TARGET])
        with self.assertRaises(subprocess.CalledProcessError):
            self.execute(validation=failure)
        self.assertEqual(self.baseline_path.read_bytes(), original)
        report = next((self.state / "reports").glob("*.json"))
        self.assertEqual(json.loads(report.read_text())["result"], "failed")
        self.commit("README.md", "docs after failure")
        self.execute(run_id="2").assert_called_once()
        self.assertEqual(json.loads(self.baseline_path.read_text())["revision"],
                         self.command("rev-parse", "HEAD"))

    def test_cancellation_does_not_promote(self):
        with self.assertRaises(KeyboardInterrupt):
            self.execute(validation=KeyboardInterrupt())
        self.assertFalse(self.baseline_path.exists())

    def test_changed_inputs_during_validation_prevent_promotion(self):
        with self.assertRaisesRegex(RuntimeError, "inputs changed"):
            self.execute(snapshots=[self.inputs, {"sources": "changed"}])
        self.assertFalse(self.baseline_path.exists())

    def test_modified_layer_during_validation_prevents_promotion(self):
        def modify_layer(*args):
            (self.repo / "README.md").write_text("changed during build")

        with self.assertRaisesRegex(RuntimeError, "clean tracked"):
            self.execute(validation=modify_layer)
        self.assertFalse(self.baseline_path.exists())

    def test_moved_checkout_during_validation_prevents_promotion(self):
        def move_checkout(*args):
            self.commit("README.md", "new commit during build")

        with self.assertRaisesRegex(RuntimeError, "inputs changed"):
            self.execute(validation=move_checkout)
        self.assertFalse(self.baseline_path.exists())

    def test_lock_blocks_planning_and_is_released_after_failure(self):
        import fcntl

        started = multiprocessing.Event()
        finished = multiprocessing.Event()

        def worker():
            started.set()
            with contextlib.suppress(subprocess.CalledProcessError):
                self.execute(validation=subprocess.CalledProcessError(1, "bitbake"))
            finished.set()

        with (self.state_root / "validation.lock").open("a") as lock:
            fcntl.flock(lock, fcntl.LOCK_EX)
            process = multiprocessing.get_context("fork").Process(target=worker)
            process.start()
            try:
                self.assertTrue(started.wait(5))
                self.assertFalse(finished.wait(0.2))
                fcntl.flock(lock, fcntl.LOCK_UN)
                self.assertTrue(finished.wait(5))
            finally:
                process.join(5)
                if process.is_alive():
                    process.terminate()
                    process.join()
            self.assertEqual(process.exitcode, 0)
        self.execute().assert_called_once()

    def test_prepare_maps_current_checkout_and_keeps_tests_enabled(self):
        directory = self.repo / "configurations"
        directory.mkdir()
        config = {
            "sources": {"meta-homeassistant": {"local": {"path": "../../.."}}},
            "bitbake-setup": {"configurations": [
                {"name": ci.CONFIGURATION, "oe-fragments": ["machine/qemux86-64"]},
            ]},
        }
        (directory / "homeassistant.conf.json").write_text(json.dumps(config))
        setup = self.state / "bitbake-builds" / ci.CONFIGURATION

        def initialize(command, **kwargs):
            (setup / "build").mkdir(parents=True, exist_ok=True)
            (setup / "build/init-build-env").touch()
            (setup / "layers").mkdir(exist_ok=True)
            return subprocess.CompletedProcess(command, 0)

        with patch.object(ci.subprocess, "run", side_effect=initialize) as command:
            self.assertEqual(ci.prepare(self.repo, self.state, self.root / "bootstrap"), setup)
            self.assertIn("init", command.call_args.args[0])
            self.assertIn(str(self.state / "configuration.conf.json"), command.call_args.args[0])
            ci.prepare(self.repo, self.state, self.root / "bootstrap")
            self.assertIn("update", command.call_args.args[0])
            self.assertIn("--update-bb-conf", command.call_args.args[0])
        generated = json.loads((self.state / "configuration.conf.json").read_text())
        self.assertEqual(generated["sources"]["meta-homeassistant"]["local"]["path"], str(self.repo))
        fragments = generated["bitbake-setup"]["configurations"][0]["oe-fragments"]
        self.assertEqual(fragments, ["machine/qemux86-64", *ci.TEST_FRAGMENTS])
        self.assertIn('/cache/sstate-cache', (setup.parent / "site.conf").read_text())

    def test_validate_sources_the_selected_wrapper_and_propagates_failure(self):
        setup = self.root / "wrapper with spaces"
        build = setup / "build"
        build.mkdir(parents=True)
        (build / "init-build-env").write_text(
            'set --\n'
            'bitbake() { test "$1" = core-image-homeassistant-full; return 7; }\n'
        )
        with self.assertRaises(subprocess.CalledProcessError) as error:
            ci.validate(self.repo, setup)
        self.assertEqual(error.exception.returncode, 7)

    def test_validate_preserves_target_when_wrapper_replaces_positional_arguments(self):
        setup = self.root / "wrapper with spaces"
        build = setup / "build"
        build.mkdir(parents=True)
        (build / "init-build-env").write_text(
            'set -- changed-build-directory ignored\n'
            'bitbake() { test "$#" -eq 1 && test "$1" = core-image-homeassistant-full; }\n'
        )
        ci.validate(self.repo, setup)

    def test_validate_inherits_bitbake_output_and_avoids_command_dump(self):
        setup = self.root / "wrapper"
        build = setup / "build"
        build.mkdir(parents=True)
        (build / "init-build-env").write_text(
            'set --\n'
        )
        result = subprocess.CompletedProcess(["bitbake", ci.TARGET], 1)
        with patch.object(ci.subprocess, "run", return_value=result) as run:
            with self.assertRaises(subprocess.CalledProcessError) as error:
                ci.validate(self.repo, setup)
        self.assertEqual(error.exception.returncode, 1)
        self.assertEqual(error.exception.cmd, ci.TARGET)
        self.assertNotIn("stdout", run.call_args.kwargs)
        self.assertNotIn("stderr", run.call_args.kwargs)
        self.assertNotIn("capture_output", run.call_args.kwargs)

    def test_main_reports_expected_build_failure_without_python_traceback(self):
        failure = subprocess.CalledProcessError(1, ci.TARGET)
        with (
            patch.object(ci, "run", side_effect=failure),
            patch.object(sys, "argv", ["ci-validate.py", "--state-root", str(self.state_root)]),
            patch.dict(os.environ, {
                "CI_REPOSITORY": "test/ha",
                "CI_REF": "refs/heads/test",
                "CI_RUN_ID": "1",
                "CI_BUILDER_ID": "test",
                "CI_EVENT": "push",
            }),
            contextlib.redirect_stderr(io.StringIO()) as error_output,
        ):
            with self.assertRaises(SystemExit) as error:
                ci.main()
        self.assertEqual(error.exception.code, 1)
        self.assertEqual(error_output.getvalue(), "Validation failed (exit code 1).\n")
        self.assertNotIn("Traceback", error_output.getvalue())
        self.assertNotIn(str(self.root), error_output.getvalue())

    def test_snapshot_uses_real_source_revisions_and_build_configuration(self):
        setup = self.root / "snapshot-wrapper"
        (setup / "config").mkdir(parents=True)
        (setup / "build/conf").mkdir(parents=True)
        (setup / "layers").mkdir()
        (setup / "layers/meta-homeassistant").symlink_to(self.repo, target_is_directory=True)
        (setup / "layers/dependency").symlink_to(self.repo, target_is_directory=True)
        fixed = {"sources": {
            "meta-homeassistant": {"local": {"path": str(self.repo)}},
            "dependency": {"git-remote": {"rev": self.initial}},
        }}
        ci.write_json(setup / "config/sources-fixed-revisions.json", fixed)
        (setup / "build/conf/local.conf").write_text('MACHINE = "qemux86-64"\n')
        inputs = ci.snapshot(self.repo, setup, self.repo, "test")
        self.assertEqual(inputs["sources"], {"dependency": self.initial})
        self.assertEqual(inputs["bootstrap"], self.initial)
        self.assertIn("local.conf", inputs["configuration"])
        (self.repo / "README.md").write_text("uncommitted")
        with self.assertRaisesRegex(RuntimeError, "tracked modifications"):
            ci.snapshot(self.repo, setup, self.repo, "test")


if __name__ == "__main__":
    unittest.main()
