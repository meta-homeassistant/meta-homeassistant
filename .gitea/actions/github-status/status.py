#!/usr/bin/env python3
"""Mirror validation status without exposing API responses or credentials."""

import json
import os
import re
import sys
import time
import urllib.error
import urllib.request


def main() -> int:
    token = os.environ.get("STATUS_TOKEN", "")
    if not token:
        print("STATUS_TOKEN is not configured; skipping GitHub status update.")
        return 0

    repository = os.environ.get("GITHUB_STATUS_REPOSITORY", "")
    revision = os.environ.get("GIT_COMMIT_SHA", "")
    state = os.environ.get("STATUS_STATE", "")
    context = os.environ.get("GITHUB_STATUS_CONTEXT", "")
    if (
        not re.fullmatch(r"[A-Za-z0-9_.-]+/[A-Za-z0-9_.-]+", repository)
        or not re.fullmatch(r"[0-9a-fA-F]{40}", revision)
        or state not in ("pending", "success", "failure")
        or not context
    ):
        print("Invalid GitHub status configuration.", file=sys.stderr)
        return 1

    descriptions = {
        "pending": "HomeAssistant validation is running on Gitea",
        "success": "HomeAssistant validation passed on Gitea",
        "failure": "HomeAssistant validation failed or was cancelled on Gitea",
    }
    request = urllib.request.Request(
        f"https://api.github.com/repos/{repository}/statuses/{revision}",
        data=json.dumps({
            "state": state, "context": context, "description": descriptions[state],
        }).encode(),
        headers={
            "Accept": "application/vnd.github+json",
            "Authorization": f"Bearer {token}",
            "X-GitHub-Api-Version": "2022-11-28",
            "Content-Type": "application/json",
        },
        method="POST",
    )
    for attempt in range(1, 13):
        try:
            with urllib.request.urlopen(request, timeout=30):
                print(f"GitHub validation status set to {state}.")
                return 0
        except urllib.error.HTTPError as error:
            code = error.code
            error.close()
            print(f"GitHub status update failed (HTTP {code}, attempt {attempt}/12).",
                  file=sys.stderr)
            if code not in (403, 408, 429) and code < 500:
                return 1
        except (urllib.error.URLError, TimeoutError, OSError):
            print(f"GitHub status update failed (connection error, attempt {attempt}/12).",
                  file=sys.stderr)
        if attempt < 12:
            time.sleep(10)
    return 1


if __name__ == "__main__":
    sys.exit(main())
