"""Offline unit tests for dependency ptest planning and helper integration."""

import shlex
import subprocess
import tempfile
import unittest
from pathlib import Path
from unittest.mock import patch

from scripts.upgrade_homeassistant import (
    RunLog,
    _run_dependency_ptests,
    build_parser,
)


class DependencyPtestHarnessTests(unittest.TestCase):
    def setUp(self):
        self.temp = self.enterContext(tempfile.TemporaryDirectory())
        self.root = Path(self.temp)
        self.layer = self.root / "layer"
        include = self.layer / "conf/include"
        include.mkdir(parents=True)
        (include / "ptest-packagelists-meta-homeassistant.inc").write_text(
            'PTESTS_FAST_META_HOMEASSISTANT = "\\\n'
            '    python3-aiohasupervisor \\\n'
            '    python3-second \\\n'
            '"\nPTESTS_SLOW_META_HOMEASSISTANT = "\\\n"\n',
            encoding="utf-8",
        )
        self.setup = self.root / "external setup"
        self.conf = self.setup / "build/conf/toolcfg.conf"
        self.conf.parent.mkdir(parents=True)
        self.conf.write_text('OE_FRAGMENTS += "machine/example"\n', encoding="utf-8")
        self.log = RunLog("2026.3.1")
        self.success = subprocess.CompletedProcess([], 0, "")
        self.failure = subprocess.CompletedProcess([], 1, "test failure")
        self.run_setup = self.enterContext(patch(
            "scripts.upgrade_homeassistant._run_in_setup", return_value=self.success,
        ))
        self.run_logged = self.enterContext(patch(
            "scripts.upgrade_homeassistant._run_logged", return_value=self.success,
        ))

    def run_ptests(self, helper=None):
        return _run_dependency_ptests(
            [("python3-aiohasupervisor", self.layer), ("python3-second", self.layer)],
            self.layer, self.setup, lambda *_args: self.success, self.log,
            {"python3-aiohasupervisor": True, "python3-second": True},
            ["python3-aiohasupervisor", "python3-second"],
            helper, "selected-wrapper",
        )

    def test_helper_receives_wrapper_setup_target_and_ptest_mode(self):
        helper = self.root / "project with spaces/tests/run-testimage.sh"
        self.assertEqual(self.run_ptests(helper), [])
        self.run_setup.assert_not_called()
        self.assertEqual(self.run_logged.call_count, 2)
        for call, recipe in zip(
            self.run_logged.call_args_list,
            ("python3-aiohasupervisor", "python3-second"),
        ):
            self.assertEqual(shlex.split(call.args[1]), [
                "bash", str(helper),
                "--wrapper", "selected-wrapper",
                "--setup-dir", str(self.setup),
                "--target", f"meta-homeassistant-image-ptest-{recipe}",
                "--mode", "ptest",
            ])
            self.assertEqual(self.log.recipe(recipe).ptest_passed, "yes")

    def test_helper_failure_stops_before_next_dependency(self):
        self.run_logged.return_value = self.failure
        self.assertEqual(self.run_ptests(self.root / "helper.sh"), [
            "Dependency ptest failed for python3-aiohasupervisor",
        ])
        self.run_setup.assert_not_called()
        self.run_logged.assert_called_once()
        self.assertEqual(self.log.recipe("python3-aiohasupervisor").ptest_passed, "no (exit 1)")
        self.assertEqual(self.log.recipe("python3-second").ptest_passed, "not run")

    def test_standalone_preserves_preexisting_fragment_on_failure(self):
        self.conf.write_text(
            'OE_FRAGMENTS += "machine/example homeassistant/enable-testing-base"\n',
            encoding="utf-8",
        )
        before = self.conf.read_text()
        self.run_logged.return_value = self.failure
        self.assertTrue(self.run_ptests())
        self.run_setup.assert_not_called()
        self.assertEqual(self.conf.read_text(), before)

    def test_standalone_restores_new_fragment_after_interruption(self):
        self.run_logged.side_effect = KeyboardInterrupt
        with self.assertRaises(KeyboardInterrupt):
            self.run_ptests()
        self.assertEqual(
            [call.args[1] for call in self.run_setup.call_args_list],
            [
                "bitbake-config-build enable-fragment homeassistant/enable-testing-base",
                "bitbake-config-build disable-fragment homeassistant/enable-testing-base",
            ],
        )

    def test_standalone_enable_failure_does_not_run_images(self):
        self.run_setup.return_value = self.failure
        self.assertEqual(self.run_ptests(), [
            "Could not enable the Home Assistant dependency ptest fragment",
        ])
        self.run_logged.assert_not_called()
        self.run_setup.assert_called_once()

    def test_parser_accepts_project_runtime_helper(self):
        args = build_parser().parse_args([
            "--release", "2026.3.1", "--setup-dir", str(self.setup),
            "--wrapper", "selected-wrapper", "--target", "homeassistant-image",
            "--dependency-ptest-helper", str(self.root / "helper.sh"),
            "--image-test-helper", str(self.root / "project-testimage.sh"),
            "--core-ptest-runqemu-arg", "wic",
            "--core-ptest-runqemu-arg", "ovmf.code",
        ])
        self.assertEqual(args.dependency_ptest_helper, self.root / "helper.sh")
        self.assertEqual(args.image_test_helper, self.root / "project-testimage.sh")
        self.assertEqual(args.core_ptest_runqemu_args, ["wic", "ovmf.code"])


if __name__ == "__main__":
    unittest.main()
