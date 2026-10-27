#!/usr/bin/env python3
"""Offline tests of the status action's payload and log boundaries."""

import contextlib
import importlib.util
import io
import json
import os
from pathlib import Path
import unittest
from unittest.mock import MagicMock, patch
import urllib.error


ACTION = Path(__file__).resolve().parents[2] / ".gitea/actions/github-status/status.py"
SPEC = importlib.util.spec_from_file_location("github_status", ACTION)
status = importlib.util.module_from_spec(SPEC)
SPEC.loader.exec_module(status)


class StatusTests(unittest.TestCase):
    def setUp(self):
        self.environment = {
            "STATUS_TOKEN": "private-token",
            "GITHUB_STATUS_REPOSITORY": "test/repository",
            "GIT_COMMIT_SHA": "a" * 40,
            "GITHUB_STATUS_CONTEXT": "gitea/homeassistant-build",
            "STATUS_STATE": "failure",
        }
        self.environment_patch = patch.dict(os.environ, self.environment, clear=True)
        self.environment_patch.start()
        self.addCleanup(self.environment_patch.stop)
        self.output = io.StringIO()
        self.stdout_patch = contextlib.redirect_stdout(self.output)
        self.stderr_patch = contextlib.redirect_stderr(self.output)
        self.stdout_patch.__enter__()
        self.stderr_patch.__enter__()
        self.addCleanup(self.stdout_patch.__exit__, None, None, None)
        self.addCleanup(self.stderr_patch.__exit__, None, None, None)

    def assert_private_values_not_logged(self):
        for value in ("private-token", "test/repository", "a" * 40,
                      "private-response", "Traceback", "api.github.com"):
            self.assertNotIn(value, self.output.getvalue())

    def test_success_never_reads_or_prints_response_body(self):
        response = MagicMock()
        response.read.return_value = b"private-response"
        with patch.object(status.urllib.request, "urlopen", return_value=response) as send:
            for state in ("pending", "success", "failure"):
                with self.subTest(state=state):
                    os.environ["STATUS_STATE"] = state
                    self.assertEqual(status.main(), 0)
                    request = send.call_args.args[0]
                    payload = json.loads(request.data)
                    self.assertEqual(payload["state"], state)
                    self.assertEqual(payload["description"], {
                        "pending": "HomeAssistant validation is running on Gitea",
                        "success": "HomeAssistant validation passed on Gitea",
                        "failure": "HomeAssistant validation failed or was cancelled on Gitea",
                    }[state])
                    self.assertEqual(request.get_header("Authorization"), "Bearer private-token")
                    self.assertEqual(send.call_args.kwargs["timeout"], 30)
        response.__enter__.return_value.read.assert_not_called()
        response.read.assert_not_called()
        self.assert_private_values_not_logged()

    def test_http_error_does_not_print_body_or_url(self):
        error = urllib.error.HTTPError(
            "https://api.github.com/private-response", 401, "private-response",
            {}, io.BytesIO(b"private-response"),
        )
        with patch.object(status.urllib.request, "urlopen", side_effect=error):
            self.assertEqual(status.main(), 1)
        self.assertIn("HTTP 401", self.output.getvalue())
        self.assert_private_values_not_logged()

    def test_transient_errors_retry_without_leaking_exception_details(self):
        error = urllib.error.URLError("private-response private-token")
        with (
            patch.object(status.urllib.request, "urlopen", side_effect=error) as send,
            patch.object(status.time, "sleep") as sleep,
        ):
            self.assertEqual(status.main(), 1)
        self.assertEqual(send.call_count, 12)
        self.assertEqual(sleep.call_count, 11)
        self.assert_private_values_not_logged()

    def test_missing_token_skips_network(self):
        os.environ["STATUS_TOKEN"] = ""
        with patch.object(status.urllib.request, "urlopen") as send:
            self.assertEqual(status.main(), 0)
        send.assert_not_called()

    def test_invalid_inputs_fail_without_network_or_echoing_values(self):
        for key in ("GITHUB_STATUS_REPOSITORY", "GIT_COMMIT_SHA", "STATUS_STATE",
                    "GITHUB_STATUS_CONTEXT"):
            with self.subTest(key=key), patch.dict(os.environ, {key: ""}):
                with patch.object(status.urllib.request, "urlopen") as send:
                    self.assertEqual(status.main(), 1)
                send.assert_not_called()
        self.assert_private_values_not_logged()


if __name__ == "__main__":
    unittest.main()
