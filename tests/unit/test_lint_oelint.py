"""Tests for the layer metadata lint entry point."""

import json
import os
from pathlib import Path
import shutil
import subprocess
import tempfile
import unittest


SCRIPT = Path(__file__).resolve().parents[2] / "scripts/lint-oelint.sh"


class LintOelintTests(unittest.TestCase):
    def setUp(self):
        self.temp = tempfile.TemporaryDirectory()
        self.addCleanup(self.temp.cleanup)
        self.root = Path(self.temp.name)
        for directory in ("scripts", "bin", "recipes", "sources", "ignored"):
            (self.root / directory).mkdir()
        shutil.copy(SCRIPT, self.root / "scripts/lint-oelint.sh")
        (self.root / ".oelint.cfg").write_text("[oelint]\n")
        (self.root / ".gitignore").write_text("ignored/\n")
        for name in (
            "recipes/tracked recipe.bb",
            "recipes/untracked.bbappend",
            "sources/excluded.bb",
            "ignored/excluded.bb",
        ):
            (self.root / name).touch()
        fake_linter = self.root / "bin/oelint-adv"
        fake_linter.write_text(
            "#!/usr/bin/env python3\n"
            "import json, os, sys\n"
            "print(json.dumps([sys.argv[1:], os.environ['OELINT_CONFIG'], "
            "os.environ['OELINT_SKIP_CONFIG']]))\n"
            "sys.exit(int(os.environ.get('FAKE_LINT_EXIT', '0')))\n"
        )
        fake_linter.chmod(0o755)
        subprocess.run(["git", "init", "-q", str(self.root)], check=True)
        subprocess.run(
            ["git", "-C", str(self.root), "add",
             "recipes/tracked recipe.bb", "sources/excluded.bb"],
            check=True,
        )
        self.env = os.environ.copy()
        self.env["PATH"] = str(self.root / "bin") + os.pathsep + self.env["PATH"]
        self.env["OELINT_SKIP_CONFIG"] = "1"

    def run_lint(self):
        return subprocess.run(
            ["bash", str(self.root / "scripts/lint-oelint.sh")],
            cwd="/",
            env=self.env,
            capture_output=True,
            text=True,
        )

    def test_selects_layer_files_and_its_own_configuration(self):
        result = self.run_lint()
        self.assertEqual(result.returncode, 0, result.stderr)
        args, config, skip = json.loads(result.stdout)
        self.assertIn("recipes/tracked recipe.bb", args)
        self.assertIn("recipes/untracked.bbappend", args)
        self.assertNotIn("sources/excluded.bb", args)
        self.assertNotIn("ignored/excluded.bb", args)
        self.assertEqual(config, str(self.root / ".oelint.cfg"))
        self.assertEqual(skip, "")

    def test_linter_failure_is_reported(self):
        self.env["FAKE_LINT_EXIT"] = "2"
        self.assertNotEqual(self.run_lint().returncode, 0)
