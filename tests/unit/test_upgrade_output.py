"""Offline unit tests for upgrade workflow command output handling."""

import sys
import tempfile
import unittest
from contextlib import redirect_stdout
from io import StringIO
from pathlib import Path
from unittest.mock import MagicMock, patch

from scripts.upgrade_homeassistant import _run


class UpgradeOutputTests(unittest.TestCase):
    def test_preserves_terminal_control_characters_and_final_partial_line(self):
        expected = "\x1b[2K\rInitialising: 88%\r\n\x1b[1A\rInitialising: 100%\r\nDone"
        with tempfile.TemporaryDirectory() as temp_dir:
            capture = StringIO()
            with redirect_stdout(capture):
                result = _run(
                    sys.executable,
                    ["-c", f"import sys; sys.stdout.buffer.write({expected.encode()!r})"],
                    Path(temp_dir),
                )
        self.assertEqual(result.returncode, 0)
        self.assertEqual(capture.getvalue(), expected)
        self.assertEqual(result.stdout, expected)

    def test_combines_stderr_and_preserves_failure_exit_status(self):
        with tempfile.TemporaryDirectory() as temp_dir:
            capture = StringIO()
            with redirect_stdout(capture):
                result = _run(
                    sys.executable,
                    ["-c", "import os; os.write(1, b'progress\\r'); "
                     "os.write(2, b'error\\r\\n'); raise SystemExit(7)"],
                    Path(temp_dir),
                )
        self.assertEqual(result.returncode, 7)
        self.assertEqual(result.stdout, "progress\rerror\r\n")
        self.assertEqual(capture.getvalue(), result.stdout)

    def test_decodes_multibyte_characters_across_chunks_without_waiting_for_newline(self):
        process = MagicMock()
        process.stdout.read1.side_effect = [b"\xe2", b"\x82", b"\xac\r", b""]
        process.wait.return_value = 0
        capture = StringIO()
        with (
            patch("scripts.upgrade_homeassistant.subprocess.Popen", return_value=process),
            patch("scripts.upgrade_homeassistant.locale.getencoding", return_value="utf-8"),
            redirect_stdout(capture),
        ):
            result = _run("example", [], Path.cwd())
        self.assertEqual(result.stdout, "\u20ac\r")
        self.assertEqual(capture.getvalue(), "\u20ac\r")


if __name__ == "__main__":
    unittest.main()
