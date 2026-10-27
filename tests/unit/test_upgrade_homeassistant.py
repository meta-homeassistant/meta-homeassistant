"""Offline unit tests for the Home Assistant Core upgrade workflow."""

import tempfile
import subprocess
import shlex
import unittest
from contextlib import redirect_stdout
from io import StringIO
from unittest.mock import patch
from pathlib import Path

from scripts.upgrade_homeassistant import (
    _add_new_regular_tests,
    _active_layer_paths,
    _check_provider_versions,
    _load_upgrade_state,
    _parse_active_recipe_versions,
    _parse_devtool_workspace_recipes,
    _provider_plan_actions,
    _ensure_fresh_artifacts,
    _prepare_run_log,
    _reconcile_core_recipe,
    _redirect_staged_integration_requires,
    _resolve_provider_srcrev,
    _replace_integration_dependencies,
    _remove_removed_integrations,
    _stage_insufficient_providers,
    _run_dependency_ptests,
    _run,
    _run_in_setup,
    _staged_integration_metadata_paths,
    _staged_source_matches_release,
    _save_upgrade_state,
    _verify_wrapper,
    _verify_local_source_mapping,
    RunLog,
    run_upgrade,
)


class ProviderCatalogTests(unittest.TestCase):
    def test_parses_bitbake_layer_path_column(self):
        with tempfile.TemporaryDirectory() as temp_dir:
            layer = Path(temp_dir) / "layer"
            layer.mkdir()
            paths = _active_layer_paths(f"layer-name {layer} 8\n")
        self.assertEqual(paths, [layer.resolve()])

    def test_parses_bitbake_recipe_summary(self):
        self.assertEqual(
            _parse_active_recipe_versions(
                "python3-alpha :1.2.3\npython3-beta :4.5-r0\nother-recipe :2.0\n"
            ),
            {"python3-alpha": "1.2.3", "python3-beta": "4.5"},
        )

    def test_parses_devtool_workspace_recipe_listing(self):
        self.assertEqual(
            _parse_devtool_workspace_recipes(
                "NOTE: Starting bitbake server...\n"
                "python3-alpha: /workspace/sources/python3-alpha "
                "(/workspace/recipes/python3-alpha/python3-alpha.bb)\n"
                "python3-beta: /workspace/sources/python3-beta "
                "(/workspace/recipes/python3-beta/python3-beta.bb)\n"
            ),
            {"python3-alpha", "python3-beta"},
        )

    def test_bitbake_recipe_revision_does_not_break_provider_version_check(self):
        active_recipes = _parse_active_recipe_versions(
            "python3-anel-pwrctrl-homeassistant :0.0.1.dev2-r0\n"
        )

        blockers = _check_provider_versions(
            {"anel_pwrctrl": {"python3-anel-pwrctrl-homeassistant": "0.0.1.dev2"}},
            {"anel_pwrctrl"},
            active_recipes,
        )
        staged, staging_blockers = _stage_insufficient_providers(
            {"python3-anel-pwrctrl-homeassistant": "0.0.1.dev2"},
            active_recipes,
            Path("/unused/setup"),
            "2026.3.1",
            [],
            lambda *_args: self.fail("an up-to-date provider must not be upgraded"),
            RunLog("2026.3.1"),
        )

        self.assertEqual(blockers, [])
        self.assertEqual(staged, [])
        self.assertEqual(staging_blockers, [])

    def test_provider_plan_summarizes_satisfied_versions_and_lists_actions(self):
        actions = _provider_plan_actions(
            {
                "python3-ready": "1.0",
                "python3-update": "2.0",
                "python3-missing": "1.0",
            },
            {"python3-ready": "1.1", "python3-update": "1.9"},
        )

        self.assertEqual(len(actions), 4)
        self.assertIn("Reuse 1 providers", actions[1])
        self.assertIn("python3-update (1.9 -> 2.0)", actions[2])
        self.assertIn("python3-missing (no exact active provider)", actions[3])
        self.assertNotIn("Reuse python3-ready", "\n".join(actions))

    def test_resolves_requested_git_tag_to_commit_without_mutating_remote(self):
        with patch(
            "scripts.upgrade_homeassistant._run_in_setup",
            side_effect=[
                subprocess.CompletedProcess([], 0, "old-commit\n"),
                subprocess.CompletedProcess(
                    [],
                    0,
                    "git://github.com/example/provider.git;protocol=https;tag=0.46.0;branch=main\n",
                ),
                subprocess.CompletedProcess([], 0, "0.46.0\n"),
            ],
        ), patch(
            "scripts.upgrade_homeassistant._run",
            return_value=subprocess.CompletedProcess(
                [],
                0,
                "0123456789abcdef0123456789abcdef01234567\trefs/tags/0.46.2\n",
            ),
        ) as run_git:
            revision, blocker = _resolve_provider_srcrev(
                "python3-provider",
                "0.46.2",
                Path("/setup"),
                lambda command, args, cwd: run_git(command, args, cwd),
                RunLog("2026.3.1"),
            )

        self.assertEqual(revision, "0123456789abcdef0123456789abcdef01234567")
        self.assertIsNone(blocker)
        self.assertEqual(run_git.call_args.args[0], "git")
        self.assertEqual(run_git.call_args.args[1][0], "ls-remote")

    def test_blocks_git_source_without_versioned_tag(self):
        with patch(
            "scripts.upgrade_homeassistant._run_in_setup",
            side_effect=[
                subprocess.CompletedProcess([], 0, "old-commit\n"),
                subprocess.CompletedProcess(
                    [],
                    0,
                    "git://github.com/example/provider.git;protocol=https;branch=main\n",
                ),
                subprocess.CompletedProcess([], 0, "0.46.0\n"),
            ],
        ):
            revision, blocker = _resolve_provider_srcrev(
                "python3-provider",
                "0.46.2",
                Path("/setup"),
                lambda *_args: self.fail("must not query an ambiguous Git ref"),
                RunLog("2026.3.1"),
            )

        self.assertIsNone(revision)
        self.assertIn("derive the requested Git tag", blocker or "")


class UpgradeArtifactTests(unittest.TestCase):
    def test_log_path_is_stable_and_named_for_release(self):
        with tempfile.TemporaryDirectory() as temp_dir:
            report_path, log_path = _ensure_fresh_artifacts(Path(temp_dir), "2026.3.1")

        self.assertEqual(report_path.name, "integration-summary-2026.3.1.md")
        self.assertEqual(log_path.name, "2026.3.1.md")
        self.assertEqual(log_path.parent.name, "upgrade-logs")

    def test_preparing_log_replaces_previous_same_release_log(self):
        with tempfile.TemporaryDirectory() as temp_dir:
            log_path = Path(temp_dir) / "upgrade-logs/2026.3.1.md"
            log_path.parent.mkdir()
            log_path.write_text("previous run", encoding="utf-8")

            _prepare_run_log(log_path)

            self.assertTrue(log_path.is_file())
            self.assertEqual(log_path.read_text(encoding="utf-8"), "")

    def test_reports_only_insufficient_active_providers(self):
        blockers = _check_provider_versions(
            {"sensor": {"python3-sensor": "2.0", "python3-missing": "1.0"}},
            {"sensor"},
            {"python3-sensor": "1.9"},
        )
        self.assertEqual(blockers, ["python3-sensor provider 1.9 is below required 2.0"])

    def test_validates_local_source_mapping_relative_to_config_file(self):
        with tempfile.TemporaryDirectory() as temp_dir:
            root = Path(temp_dir)
            layer = root / "sources/meta-homeassistant"
            layer.mkdir(parents=True)
            config_dir = root / "configurations"
            config_dir.mkdir()
            (config_dir / "local-sources.json").write_text(
                '{"sources":{"meta-homeassistant":{"local":{"path":"../sources/meta-homeassistant"}}}}',
                encoding="utf-8",
            )
            _verify_local_source_mapping(layer)

    def test_wrapper_target_failure_is_returned_as_blocker_not_exception(self):
        with tempfile.TemporaryDirectory() as temp_dir:
            root = Path(temp_dir)
            layer = root / "layer"
            layer.mkdir()
            setup = root / "setup"
            (setup / "build").mkdir(parents=True)
            (setup / "build/init-build-env").write_text("", encoding="utf-8")
            (setup / "layer").mkdir()
            calls = [
                subprocess.CompletedProcess([], 0, f"homeassistant {layer}\n"),
                subprocess.CompletedProcess([], 1, "missing dependency"),
            ]
            with patch("scripts.upgrade_homeassistant._run_in_setup", side_effect=calls):
                active_layers, blockers = _verify_wrapper(
                    layer,
                    setup,
                    "wrapper",
                    "homeassistant-image",
                    lambda *_args: subprocess.CompletedProcess([], 0, ""),
                    RunLog("2026.3.1"),
                )

        self.assertEqual(active_layers, [layer.resolve()])
        self.assertEqual(len(blockers), 1)
        self.assertIn("currently unbuildable", blockers[0])


class CommandOutputTests(unittest.TestCase):
    def test_quiet_setup_command_emits_output_only_on_failure(self):
        with tempfile.TemporaryDirectory() as temp_dir:
            setup_dir = Path(temp_dir)
            build_dir = setup_dir / "build"
            build_dir.mkdir()
            (build_dir / "init-build-env").write_text("", encoding="utf-8")

            with redirect_stdout(StringIO()):
                success = _run_in_setup(
                    setup_dir,
                    "printf 'quiet-success-output'",
                    _run,
                    quiet_success=True,
                )
                failure = _run_in_setup(
                    setup_dir,
                    "printf 'quiet-failure-diagnostic'; exit 7",
                    _run,
                    quiet_success=True,
                )

        self.assertEqual(success.returncode, 0)
        self.assertEqual(success.stdout, "")
        self.assertEqual(failure.returncode, 7)
        self.assertIn("quiet-failure-diagnostic", failure.stdout)


class UpgradeStateTests(unittest.TestCase):
    def test_run_log_omits_successful_command_transcripts(self):
        log = RunLog("2026.3.1")
        log.planned_actions.append("Build homeassistant-image after compiling changed recipes.")
        log.record(
            "Query active recipe catalog",
            ["bitbake", "-s"],
            subprocess.CompletedProcess([], 0, "thousands of recipe rows"),
        )
        rendered = log.render()

        self.assertNotIn("Query active recipe catalog", rendered)
        self.assertNotIn("thousands of recipe rows", rendered)
        self.assertIn("## Planned actions", rendered)
        self.assertIn("Build homeassistant-image after compiling changed recipes.", rendered)

    def test_run_log_retains_failed_command_diagnostics(self):
        log = RunLog("2026.3.1")
        log.record(
            "Build image",
            ["bitbake", "homeassistant-image"],
            subprocess.CompletedProcess([], 1, "ERROR: No provider for missing-recipe"),
        )
        rendered = log.render()

        self.assertIn("## Build image (exit 1)", rendered)
        self.assertIn("ERROR: No provider for missing-recipe", rendered)

    def test_state_round_trip_supports_resuming_staged_recipes(self):
        with tempfile.TemporaryDirectory() as temp_dir:
            setup = Path(temp_dir)
            state = _load_upgrade_state(setup, "2026.3.1")
            state["staged_dependencies"] = {
                "python3-provider": {"owner": "/layers/meta-ha", "requested": "1.2.3"}
            }
            _save_upgrade_state(setup, "2026.3.1", state)
            resumed = _load_upgrade_state(setup, "2026.3.1")

        self.assertEqual(resumed, state)

    def test_resumes_a_staged_provider_using_saved_owner(self):
        with tempfile.TemporaryDirectory() as temp_dir:
            root = Path(temp_dir)
            setup = root / "setup"
            recipe_dir = setup / "build/workspace/recipes/python3-provider"
            recipe_dir.mkdir(parents=True)
            owner = root / "layers/meta-provider"
            owner.mkdir(parents=True)
            state = _load_upgrade_state(setup, "2026.3.1")
            state["staged_dependencies"] = {
                "python3-provider": {
                    "owner": str(owner),
                    "requested": "1.2.0",
                    "status": "staged",
                }
            }
            _save_upgrade_state(setup, "2026.3.1", state)

            staged, blockers = _stage_insufficient_providers(
                {"python3-provider": "1.2.0"},
                {"python3-provider": "1.2.0"},
                setup,
                "2026.3.1",
                [owner],
                lambda *_args: self.fail("resuming a staged provider must not rerun devtool"),
                RunLog("2026.3.1"),
            )

        self.assertEqual(staged, [("python3-provider", owner)])
        self.assertEqual(blockers, [])

    def test_preserves_existing_modify_workspace_without_rerunning_devtool(self):
        with tempfile.TemporaryDirectory() as temp_dir:
            root = Path(temp_dir)
            setup = root / "setup"
            (setup / "build/workspace/sources/python3-provider").mkdir(parents=True)
            appends = setup / "build/workspace/appends"
            appends.mkdir(parents=True)
            (appends / "python3-provider_1.0.bbappend").write_text("", encoding="utf-8")
            owner = root / "layers/meta-provider"
            owner.mkdir(parents=True)
            state = _load_upgrade_state(setup, "2026.3.1")
            state["staged_dependencies"] = {
                "python3-provider": {
                    "owner": str(owner),
                    "requested": "2.0.0",
                    "status": "staging",
                }
            }
            _save_upgrade_state(setup, "2026.3.1", state)
            log = RunLog("2026.3.1")

            staged, blockers = _stage_insufficient_providers(
                {"python3-provider": "2.0.0"},
                {"python3-provider": "1.0.0"},
                setup,
                "2026.3.1",
                [owner],
                lambda *_args: self.fail("must not rerun devtool for an existing source workspace"),
                log,
            )

        self.assertEqual(staged, [])
        self.assertEqual(len(blockers), 1)
        self.assertIn("Existing devtool workspace", blockers[0])
        self.assertIn("preserved for review", blockers[0])
        self.assertEqual(
            log.recipe("python3-provider").devtool_upgrade,
            "incomplete; workspace preserved",
        )

    def test_retries_pristine_partial_upgrade_without_creating_backup(self):
        with tempfile.TemporaryDirectory() as temp_dir:
            root = Path(temp_dir)
            setup = root / "setup"
            source_dir = setup / "build/workspace/sources/python3-provider"
            source_dir.mkdir(parents=True)
            owner = root / "layers/meta-provider"
            owner.mkdir(parents=True)
            recipe_file = owner / "recipes/python3-provider/python3-provider.bb"
            recipe_file.parent.mkdir(parents=True)
            recipe_file.write_text("", encoding="utf-8")
            subprocess.run(["git", "init", "-q"], cwd=source_dir, check=True)
            (source_dir / "source.txt").write_text("upstream source", encoding="utf-8")
            subprocess.run(
                ["git", "add", "source.txt"], cwd=source_dir, check=True
            )
            subprocess.run(
                [
                    "git",
                    "-c",
                    "user.name=Test",
                    "-c",
                    "user.email=test@example.com",
                    "commit",
                    "-qm",
                    "upstream source",
                ],
                cwd=source_dir,
                check=True,
            )
            subprocess.run(
                ["git", "tag", "devtool-base-2.0.0"], cwd=source_dir, check=True
            )
            state = _load_upgrade_state(setup, "2026.3.1")
            state["staged_dependencies"] = {
                "python3-provider": {
                    "owner": str(owner),
                    "requested": "2.0.0",
                    "status": "staging",
                }
            }
            _save_upgrade_state(setup, "2026.3.1", state)

            def runner(command, args, cwd):
                if command == "git":
                    result = subprocess.run(
                        [command, *args], cwd=cwd, capture_output=True, text=True
                    )
                    return subprocess.CompletedProcess(
                        [command, *args], result.returncode, result.stdout + result.stderr
                    )
                shell_command = args[-1]
                if "bitbake-getvar FILE" in shell_command:
                    return subprocess.CompletedProcess(args, 0, f"{recipe_file}\n")
                if "bitbake -s" in shell_command:
                    return subprocess.CompletedProcess(args, 0, "python3-provider :2.0.0\n")
                self.fail(f"Unexpected command: {shell_command}")

            def retry_upgrade(_label, _command, _setup, _runner, _log):
                self.assertFalse(source_dir.exists())
                source_dir.mkdir(parents=True)
                (source_dir / "fresh-retry.txt").write_text("retry", encoding="utf-8")
                return subprocess.CompletedProcess([], 0, "")

            with (
                patch(
                    "scripts.upgrade_homeassistant._resolve_provider_srcrev",
                    return_value=(None, None),
                ),
                patch(
                    "scripts.upgrade_homeassistant._run_logged",
                    side_effect=retry_upgrade,
                ) as run_logged,
            ):
                log = RunLog("2026.3.1")
                staged, blockers = _stage_insufficient_providers(
                    {"python3-provider": "2.0.0"},
                    {"python3-provider": "1.0.0"},
                    setup,
                    "2026.3.1",
                    [owner],
                    runner,
                    log,
                )

            original_source_discarded = not (source_dir.parent / "python3-provider.failed-2026.3.1").exists()
            retry_source_created = (source_dir / "fresh-retry.txt").is_file()

        self.assertEqual(blockers, [], blockers)
        self.assertEqual(staged, [("python3-provider", owner)])
        self.assertEqual(run_logged.call_count, 1)
        self.assertTrue(original_source_discarded)
        self.assertTrue(retry_source_created)
        self.assertTrue(any("Discarded pristine partial" in item for item in log.outcomes))

    def test_does_not_retry_dirty_partial_upgrade_workspace(self):
        with tempfile.TemporaryDirectory() as temp_dir:
            root = Path(temp_dir)
            setup = root / "setup"
            source_dir = setup / "build/workspace/sources/python3-provider"
            source_dir.mkdir(parents=True)
            owner = root / "layers/meta-provider"
            owner.mkdir(parents=True)
            subprocess.run(["git", "init", "-q"], cwd=source_dir, check=True)
            (source_dir / "local-change.txt").write_text("keep me", encoding="utf-8")
            state = _load_upgrade_state(setup, "2026.3.1")
            state["staged_dependencies"] = {
                "python3-provider": {
                    "owner": str(owner),
                    "requested": "2.0.0",
                    "status": "staging",
                }
            }
            _save_upgrade_state(setup, "2026.3.1", state)

            def runner(command, args, cwd):
                if command != "git":
                    self.fail(f"Unexpected command: {command} {args}")
                result = subprocess.run(
                    [command, *args], cwd=cwd, capture_output=True, text=True
                )
                return subprocess.CompletedProcess(
                    [command, *args], result.returncode, result.stdout + result.stderr
                )

            with patch(
                "scripts.upgrade_homeassistant._run_logged",
                side_effect=AssertionError("dirty workspace must not be retried"),
            ):
                staged, blockers = _stage_insufficient_providers(
                    {"python3-provider": "2.0.0"},
                    {"python3-provider": "1.0.0"},
                    setup,
                    "2026.3.1",
                    [owner],
                    runner,
                    RunLog("2026.3.1"),
                )
                self.assertTrue((source_dir / "local-change.txt").is_file())

        self.assertEqual(staged, [])
        self.assertIn("has local changes", blockers[0])

    def test_accepts_new_sufficient_provider_without_layer_owner(self):
        with tempfile.TemporaryDirectory() as temp_dir:
            setup = Path(temp_dir)
            recipe_dir = setup / "build/workspace/recipes/python3-fitbit-web-api"
            recipe_dir.mkdir(parents=True)
            log = RunLog("2026.3.1")

            staged, blockers = _stage_insufficient_providers(
                {"python3-fitbit-web-api": "2.15.0"},
                {"python3-fitbit-web-api": "2.15.0"},
                setup,
                "2026.3.1",
                [],
                lambda *_args: self.fail("an adequate new provider must not be upgraded"),
                log,
            )

        self.assertEqual(staged, [("python3-fitbit-web-api", None)])
        self.assertEqual(blockers, [])
        self.assertEqual(
            log.recipe("python3-fitbit-web-api").devtool_upgrade,
            "existing provider accepted (new recipe; no layer owner)",
        )
        self.assertEqual(len(log.open_tasks), 1)
        task = log.open_tasks[0]
        self.assertIn("Choose a destination layer for new provider python3-fitbit-web-api", task)
        self.assertIn("after successful validation and review", task)
        self.assertIn("devtool finish python3-fitbit-web-api <destination-layer>", task)
        self.assertIn("devtool finish moves the recipe and associated files into that layer", task)
        self.assertIn("do not move them manually beforehand", task)

    def test_stops_provider_staging_after_first_upgrade_failure(self):
        with tempfile.TemporaryDirectory() as temp_dir:
            root = Path(temp_dir)
            setup = root / "setup"
            setup.mkdir()
            owner = root / "layer"
            owner.mkdir()
            recipe_file = owner / "recipes/python3-a/python3-a.bb"
            recipe_file.parent.mkdir(parents=True)
            recipe_file.write_text("", encoding="utf-8")
            failed = subprocess.CompletedProcess([], 1, "devtool failure")
            provider_info = subprocess.CompletedProcess(
                [], 0, f"{recipe_file}\n"
            )
            with (
                patch(
                    "scripts.upgrade_homeassistant._run_in_setup",
                    return_value=provider_info,
                ) as run_setup,
                patch(
                    "scripts.upgrade_homeassistant._resolve_provider_srcrev",
                    return_value=("0123456789abcdef0123456789abcdef01234567", None),
                ),
                patch(
                    "scripts.upgrade_homeassistant._run_logged",
                    return_value=failed,
                ) as run_logged,
            ):
                staged, blockers = _stage_insufficient_providers(
                    {"python3-a": "2.0", "python3-b": "2.0"},
                    {"python3-a": "1.0", "python3-b": "1.0"},
                    setup,
                    "2026.3.1",
                    [owner],
                    lambda *_args: self.fail("provider shell command should be mocked"),
                    RunLog("2026.3.1"),
                )

        self.assertEqual(staged, [])
        self.assertEqual(len(blockers), 1)
        self.assertIn("could not upgrade python3-a", blockers[0])
        self.assertEqual(run_setup.call_count, 1)
        self.assertEqual(run_logged.call_count, 1)
        self.assertIn("--srcrev 0123456789abcdef0123456789abcdef01234567", run_logged.call_args.args[1])

    def test_run_log_lists_attention_tasks_and_completed_steps(self):
        log = RunLog("2026.3.1")
        log.outcomes.append("Completed: inspect providers (exit 0)")
        log.open_tasks.append("Add a provider for python3-missing")
        log.manual_actions.append("source setup/build/init-build-env && devtool finish python3-homeassistant layer")
        log.recipe("python3-homeassistant").devtool_upgrade = "passed (to 2026.3.1)"
        log.recipe("python3-homeassistant").compilation = "passed"
        log.recipe("python3-homeassistant").ptest_present = "yes"
        log.recipe("python3-homeassistant").ptest_passed = "yes"
        rendered = log.render()

        self.assertIn("## Open tasks requiring attention", rendered)
        self.assertIn("Add a provider for python3-missing", rendered)
        self.assertIn("## Manual Finish After Review", rendered)
        self.assertIn("The workflow did not execute these commands", rendered)
        self.assertIn("devtool finish python3-homeassistant layer", rendered)
        self.assertIn("## Completed steps", rendered)
        self.assertIn("inspect providers (exit 0)", rendered)
        self.assertIn("## Recipe Validation Summary", rendered)
        self.assertIn("| python3-homeassistant | passed (to 2026.3.1) | passed | yes | yes |", rendered)


class StagedSourceRevisionTests(unittest.TestCase):
    def test_accepts_requested_release_with_declared_recipe_patch_only(self):
        with tempfile.TemporaryDirectory() as temp_dir:
            root = Path(temp_dir)
            source_dir = root / "source"
            source_dir.mkdir()

            def git(*args: str) -> subprocess.CompletedProcess[str]:
                return subprocess.run(
                    ["git", *args],
                    cwd=source_dir,
                    text=True,
                    stdout=subprocess.PIPE,
                    stderr=subprocess.STDOUT,
                    check=False,
                )

            git("init", "-q")
            git("config", "user.email", "test@example.invalid")
            git("config", "user.name", "Test")
            (source_dir / "pyproject.toml").write_text(
                '[build-system]\n'
                'requires = ["setuptools==78.1.1"]\n'
                'build-backend = "setuptools.build_meta"\n\n'
                '[project]\ndependencies = []\n',
                encoding="utf-8",
            )
            component = source_dir / "homeassistant/components/example"
            component.mkdir(parents=True)
            (component / "manifest.json").write_text('{"domain":"example"}\n', encoding="utf-8")
            test_dir = source_dir / "tests/components/example"
            test_dir.mkdir(parents=True)
            (test_dir / "test_example.py").write_text("def test_example(): pass\n", encoding="utf-8")
            (source_dir / "requirements_test.txt").write_text("pytest==9.0\n", encoding="utf-8")
            self.assertEqual(git("add", ".").returncode, 0)
            self.assertEqual(git("commit", "-qm", "release").returncode, 0)
            revision = git("rev-parse", "HEAD").stdout.strip()

            layer_dir = root / "layer"
            patch_dir = layer_dir / "recipes-homeassistant/homeassistant/python3-homeassistant"
            patch_dir.mkdir(parents=True)
            patch_path = patch_dir / "0001-relax-setuptools.patch"
            actual_patch = (
                Path(__file__).resolve().parents[2]
                / "recipes-homeassistant/homeassistant/python3-homeassistant/0001-Relax-setuptools.patch"
            )
            patch_path.write_text(actual_patch.read_text(encoding="utf-8"), encoding="utf-8")
            recipe_path = root / "python3-homeassistant_2026.3.1.bb"
            recipe_path.write_text(
                f'SRCREV = "{revision}"\nSRC_URI = "file://0001-relax-setuptools.patch"\n',
                encoding="utf-8",
            )
            (source_dir / "pyproject.toml").write_text(
                '[build-system]\n'
                'requires = ["setuptools>=78.1.0"]\n'
                'build-backend = "setuptools.build_meta"\n\n'
                '[project]\ndependencies = []\n',
                encoding="utf-8",
            )
            self.assertEqual(git("add", ".").returncode, 0)
            self.assertEqual(git("commit", "-qm", "apply recipe patch").returncode, 0)
            self.assertEqual(git("merge-base", "--is-ancestor", revision, "HEAD").returncode, 0)
            self.assertEqual(git("status", "--porcelain").stdout, "")
            reverse_patch = git("apply", "--reverse", "--check", str(patch_path))
            self.assertEqual(reverse_patch.returncode, 0, reverse_patch.stdout)

            self.assertTrue(
                _staged_source_matches_release(
                    source_dir,
                    revision,
                    recipe_path,
                    layer_dir,
                    lambda command, args, cwd: subprocess.run(
                        [command, *args],
                        cwd=cwd,
                        text=True,
                        stdout=subprocess.PIPE,
                        stderr=subprocess.STDOUT,
                        check=False,
                    ),
                )
            )

            (component / "manifest.json").write_text('{"domain":"changed"}\n', encoding="utf-8")
            self.assertEqual(git("add", ".").returncode, 0)
            self.assertEqual(git("commit", "-qm", "unexpected source change").returncode, 0)
            self.assertFalse(
                _staged_source_matches_release(
                    source_dir,
                    revision,
                    recipe_path,
                    layer_dir,
                    lambda command, args, cwd: subprocess.run(
                        [command, *args],
                        cwd=cwd,
                        text=True,
                        stdout=subprocess.PIPE,
                        stderr=subprocess.STDOUT,
                        check=False,
                    ),
                )
            )


class IntegrationReconciliationTests(unittest.TestCase):
    def test_reconciles_devtool_metadata_without_touching_layer_checkout(self):
        with tempfile.TemporaryDirectory() as temp_dir:
            root = Path(temp_dir)
            setup = root / "setup"
            layer_metadata_dir = (
                root / "layer/recipes-homeassistant/homeassistant/python3-homeassistant"
            )
            layer_metadata_dir.mkdir(parents=True)
            staged_recipe_dir = (
                setup / "build/workspace/recipes/python3-homeassistant"
            )
            staged_recipe_dir.mkdir(parents=True)
            staged_metadata_dir = staged_recipe_dir / "python3-homeassistant"
            staged_metadata_dir.mkdir()

            layer_integrations = layer_metadata_dir / "integrations.inc"
            layer_tests = layer_metadata_dir / "integrations-tests.inc"
            layer_integrations.write_text("original layer integrations\n", encoding="utf-8")
            layer_tests.write_text("original layer tests\n", encoding="utf-8")
            staged_integrations = staged_metadata_dir / "integrations.inc"
            staged_integrations.write_text(
                'INTEGRATIONS = "\\\n    ${PN}-sensor \\\n"\n'
                'RDEPENDS:${PN}-sensor = "\\\n    python3-sensor (>=1.0) \\\n"\n',
                encoding="utf-8",
            )
            staged_tests = staged_metadata_dir / "integrations-tests.inc"
            staged_tests.write_text(
                'COMPONENT_TEST_PACKAGES:append = "\\\n'
                '    ${PN}-sensor \\\n'
                "    ${@bb.utils.contains('PACKAGECONFIG', 'integration-tests', '', '', d)}\"\n",
                encoding="utf-8",
            )
            staged_recipe = staged_recipe_dir / "python3-homeassistant_2026.3.1.bb"
            staged_recipe.write_text(
                "require recipes-homeassistant/homeassistant/python3-homeassistant/integrations.inc\n"
                "require recipes-homeassistant/homeassistant/python3-homeassistant/integrations-tests.inc\n",
                encoding="utf-8",
            )

            integration_path, tests_path = _staged_integration_metadata_paths(setup)
            recipe_before = _redirect_staged_integration_requires(staged_recipe)
            blockers = _replace_integration_dependencies(
                integration_path,
                {"sensor": {"python3-sensor": "2.0"}},
                {"sensor"},
                {"python3-sensor": "2.1"},
            )
            _add_new_regular_tests(tests_path, {"sensor", "new_domain"}, {"sensor"})

            staged_recipe_text = staged_recipe.read_text(encoding="utf-8")
            staged_integrations_text = staged_integrations.read_text(encoding="utf-8")
            staged_tests_text = staged_tests.read_text(encoding="utf-8")
            original_layer_integrations = layer_integrations.read_text(encoding="utf-8")
            original_layer_tests = layer_tests.read_text(encoding="utf-8")

        self.assertEqual(integration_path, staged_integrations)
        self.assertEqual(tests_path, staged_tests)
        self.assertIn("${THISDIR}/python3-homeassistant/integrations.inc", staged_recipe_text)
        self.assertIn("${THISDIR}/python3-homeassistant/integrations-tests.inc", staged_recipe_text)
        self.assertIn("recipes-homeassistant/homeassistant", recipe_before)
        self.assertEqual(blockers, [])
        self.assertIn("python3-sensor (>=2.0)", staged_integrations_text)
        self.assertIn("${PN}-new-domain", staged_tests_text)
        self.assertEqual(original_layer_integrations, "original layer integrations\n")
        self.assertEqual(original_layer_tests, "original layer tests\n")

    def test_reconciles_each_integration_to_only_its_manifest_dependencies(self):
        metadata = '''INTEGRATIONS = "\\
    ${PN}-blue-current \\
    ${PN}-blockchain \\
"
RDEPENDS:${PN}-blue-current = "\\
    python3-python-blockchain-api (>=0.0.1) \\
"
RDEPENDS:${PN}-blockchain = "\\
    python3-bluecurrent-api (>=1.3.1) \\
"
'''
        with tempfile.TemporaryDirectory() as temp_dir:
            integrations_path = Path(temp_dir) / "integrations.inc"
            integrations_path.write_text(metadata, encoding="utf-8")
            blockers = _replace_integration_dependencies(
                integrations_path,
                {
                    "blockchain": {"python3-python-blockchain-api": "0.0.2"},
                    "blue_current": {"python3-bluecurrent-api": "1.3.2"},
                },
                {"blockchain", "blue_current"},
                {
                    "python3-python-blockchain-api": "0.0.2",
                    "python3-bluecurrent-api": "1.3.3",
                },
            )
            updated = integrations_path.read_text(encoding="utf-8")

        self.assertEqual(blockers, [])
        self.assertIn('RDEPENDS:${PN}-blue-current = "\\\n    python3-bluecurrent-api (>=1.3.2)', updated)
        self.assertNotIn("python3-python-blockchain-api (>=0.0.1)", updated)
        self.assertIn(
            'RDEPENDS:${PN}-blockchain = "\\\n    python3-python-blockchain-api (>=0.0.2)',
            updated,
        )
        self.assertNotIn("python3-bluecurrent-api (>=1.3.1)", updated)
        self.assertIn("python3-python-blockchain-api (>=0.0.2)", updated)
        self.assertNotIn("python3-bluecurrent-api (>=1.3.1)", updated)

    def test_removes_manifest_obsolete_packages_from_existing_integration(self):
        metadata = '''INTEGRATIONS = "\\
    ${PN}-matter \\
"
ALLOW_EMPTY:${PN}-matter = "1"
RDEPENDS:${PN}-matter = "\\
    python3-obsolete-matter-client (>=1.0) \\
    python3-python-matter-server (>=8.1.0) \\
"
'''
        with tempfile.TemporaryDirectory() as temp_dir:
            integrations_path = Path(temp_dir) / "integrations.inc"
            integrations_path.write_text(metadata, encoding="utf-8")
            blockers = _replace_integration_dependencies(
                integrations_path,
                {"matter": {"python3-python-matter-server": "8.2.0"}},
                {"matter"},
                {"python3-python-matter-server": "8.2.0"},
            )
            updated = integrations_path.read_text(encoding="utf-8")

        self.assertEqual(blockers, [])
        self.assertIn("python3-python-matter-server (>=8.2.0)", updated)
        self.assertNotIn("python3-obsolete-matter-client", updated)

    def test_removes_integrations_missing_upstream_and_their_tests(self):
        integrations = '''INTEGRATIONS = "\\
    ${PN}-matter \\
    ${PN}-sensor \\
"
ALLOW_EMPTY:${PN}-matter = "1"
RDEPENDS:${PN}-matter = "\\
    python3-python-matter-server (>=8.1.0) \\
"
ALLOW_EMPTY:${PN}-sensor = "1"
'''
        tests = '''COMPONENT_TEST_PACKAGES_FLAKY:append = "\\
    ${PN}-matter \\
    ${PN}-sensor \\
"
COMPONENT_TEST_PACKAGES:append = "\\
    ${PN}-matter \\
    ${PN}-sensor \\
"
'''
        image_integrations = '''IMAGE_INSTALL:append = "\\
    python3-homeassistant-matter \\
    python3-homeassistant-sensor \\
"
'''
        with tempfile.TemporaryDirectory() as temp_dir:
            integrations_path = Path(temp_dir) / "integrations.inc"
            tests_path = Path(temp_dir) / "integrations-tests.inc"
            image_integrations_path = Path(temp_dir) / "homeassistant-integrations.inc"
            integrations_path.write_text(integrations, encoding="utf-8")
            tests_path.write_text(tests, encoding="utf-8")
            image_integrations_path.write_text(image_integrations, encoding="utf-8")

            removed = _remove_removed_integrations(
                integrations_path, tests_path, image_integrations_path, {"sensor"}
            )
            updated_integrations = integrations_path.read_text(encoding="utf-8")
            updated_tests = tests_path.read_text(encoding="utf-8")
            updated_image_integrations = image_integrations_path.read_text(encoding="utf-8")

        self.assertEqual(removed, ["matter"])
        self.assertNotIn("${PN}-matter", updated_integrations)
        self.assertNotIn("ALLOW_EMPTY:${PN}-matter", updated_integrations)
        self.assertNotIn("RDEPENDS:${PN}-matter", updated_integrations)
        self.assertIn("${PN}-sensor", updated_integrations)
        self.assertNotIn("${PN}-matter", updated_tests)
        self.assertEqual(updated_tests.count("${PN}-sensor"), 2)
        self.assertNotIn("python3-homeassistant-matter", updated_image_integrations)
        self.assertIn("python3-homeassistant-sensor", updated_image_integrations)

    def test_removes_stale_image_entry_after_core_metadata_is_already_reconciled(self):
        integrations = '''INTEGRATIONS = "\\
    ${PN}-sensor \\
"
ALLOW_EMPTY:${PN}-sensor = "1"
'''
        tests = '''COMPONENT_TEST_PACKAGES:append = "\\
    ${PN}-sensor \\
"
'''
        image_integrations = '''IMAGE_INSTALL:append = "\\
    python3-homeassistant-matter \\
    python3-homeassistant-sensor \\
"
'''
        with tempfile.TemporaryDirectory() as temp_dir:
            integrations_path = Path(temp_dir) / "integrations.inc"
            tests_path = Path(temp_dir) / "integrations-tests.inc"
            image_integrations_path = Path(temp_dir) / "homeassistant-integrations.inc"
            integrations_path.write_text(integrations, encoding="utf-8")
            tests_path.write_text(tests, encoding="utf-8")
            image_integrations_path.write_text(image_integrations, encoding="utf-8")

            removed = _remove_removed_integrations(
                integrations_path, tests_path, image_integrations_path, {"sensor"}
            )
            updated_image_integrations = image_integrations_path.read_text(encoding="utf-8")

        self.assertEqual(removed, ["matter"])
        self.assertNotIn("python3-homeassistant-matter", updated_image_integrations)
        self.assertIn("python3-homeassistant-sensor", updated_image_integrations)

    def test_shared_dependency_is_added_without_owner_blocker(self):
        metadata = '''INTEGRATIONS = "\\
    ${PN}-acer-projector \\
    ${PN}-crownstone \\
    ${PN}-zwave-js \\
"
RDEPENDS:${PN}-acer-projector = "\\
"
RDEPENDS:${PN}-crownstone = "\\
    python3-pyserial (>=3.4) \\
"
RDEPENDS:${PN}-zwave-js = "\\
    python3-pyserial (>=3.5) \\
"
'''
        with tempfile.TemporaryDirectory() as temp_dir:
            integrations_path = Path(temp_dir) / "integrations.inc"
            integrations_path.write_text(metadata, encoding="utf-8")
            blockers = _replace_integration_dependencies(
                integrations_path,
                {"acer_projector": {"python3-pyserial": "3.5"}},
                {"acer_projector", "crownstone", "zwave_js"},
                {"python3-pyserial": "3.5"},
            )
            updated = integrations_path.read_text(encoding="utf-8")

        self.assertEqual(blockers, [])
        self.assertIn(
            'RDEPENDS:${PN}-acer-projector = "\\\n    python3-pyserial (>=3.5)',
            updated,
        )
        self.assertIn('RDEPENDS:${PN}-crownstone = "\\\n    python3-pyserial (>=3.4)', updated)
        self.assertIn('RDEPENDS:${PN}-zwave-js = "\\\n    python3-pyserial (>=3.5)', updated)

    def test_preserves_a_stronger_existing_floor(self):
        metadata = '''INTEGRATIONS = "\\
    ${PN}-sensor \\
"
RDEPENDS:${PN}-sensor = "\\
    python3-sensor (>=3.0) \\
"
'''
        with tempfile.TemporaryDirectory() as temp_dir:
            integrations_path = Path(temp_dir) / "integrations.inc"
            integrations_path.write_text(metadata, encoding="utf-8")
            blockers = _replace_integration_dependencies(
                integrations_path,
                {"sensor": {"python3-sensor": "2.0"}},
                {"sensor"},
                {"python3-sensor": "3.1"},
            )
            updated = integrations_path.read_text(encoding="utf-8")

        self.assertEqual(blockers, [])
        self.assertIn("python3-sensor (>=3.0)", updated)

    def test_adds_new_tests_only_to_regular_list(self):
        tests = '''COMPONENT_TEST_PACKAGES_FLAKY:append = "\\
    ${PN}-flaky \\
    ${@bb.utils.contains('PACKAGECONFIG', 'integration-tests', '', '', d)}"
COMPONENT_TEST_PACKAGES:append = "\\
    ${PN}-existing \\
    ${@bb.utils.contains('PACKAGECONFIG', 'integration-tests', '', '', d)}"
'''
        with tempfile.TemporaryDirectory() as temp_dir:
            tests_path = Path(temp_dir) / "integrations-tests.inc"
            tests_path.write_text(tests, encoding="utf-8")
            _add_new_regular_tests(tests_path, {"flaky", "existing", "new_domain"}, {"flaky", "existing"})
            updated = tests_path.read_text(encoding="utf-8")

        self.assertIn("${PN}-flaky", updated)
        self.assertIn("${PN}-new-domain", updated)
        self.assertEqual(updated.count("${PN}-new-domain"), 1)
        self.assertEqual(updated.count("${PN}-flaky"), 1)


class CoreRecipeReconciliationTests(unittest.TestCase):
    def test_missing_provider_blocker_identifies_upstream_requirement(self):
        with tempfile.TemporaryDirectory() as temp_dir:
            root = Path(temp_dir)
            source_dir = root / "source"
            source_dir.mkdir()
            (source_dir / "pyproject.toml").write_text(
                '[project]\nrequires-python = ">=3.14"\ndependencies = []\n',
                encoding="utf-8",
            )
            (source_dir / "requirements_test.txt").write_text(
                "pylint-per-file-ignores==1.0\n",
                encoding="utf-8",
            )
            recipe_path = root / "python3-homeassistant_2026.3.1.bb"
            recipe_path.write_text(
                'RDEPENDS:${PN} += "\\\n"\n'
                'RDEPENDS:${PN}-ptest = "\\\n    bash \\\n"\n',
                encoding="utf-8",
            )

            blockers = _reconcile_core_recipe(recipe_path, source_dir, {})

        self.assertEqual(len(blockers), 1)
        self.assertIn("requirements_test.txt", blockers[0])
        self.assertIn("pylint-per-file-ignores", blockers[0])
        self.assertIn("python3-pylint-per-file-ignores", blockers[0])
        self.assertIn("no exact active recipe provider", blockers[0])

    def test_applies_runtime_and_filtered_ptest_requirements(self):
        with tempfile.TemporaryDirectory() as temp_dir:
            root = Path(temp_dir)
            source_dir = root / "source"
            source_dir.mkdir()
            (source_dir / "pyproject.toml").write_text(
                '[project]\nrequires-python = ">=3.14.2"\n'
                'dependencies = ["core-dep==2.0"]\n',
                encoding="utf-8",
            )
            (source_dir / "requirements_test_pre_commit.txt").write_text(
                "ruff==1.0\n", encoding="utf-8"
            )
            (source_dir / "requirements_test.txt").write_text(
                "-c package_constraints.txt\n"
                "-r requirements_test_pre_commit.txt\n"
                "pytest==9.0\n"
                "pytest-cov==7.0\n"
                "pylint==4.0\n"
                "mypy==1.0\n"
                "types-example==1.0\n",
                encoding="utf-8",
            )
            recipe_path = root / "python3-homeassistant_2026.3.1.bb"
            recipe_path.write_text(
                'RDEPENDS:${PN} += "\\\n'
                '    python3-old-dependency (>=1.0) \\\n'
                '    python3-statistics \\\n'
                '"\n'
                'RDEPENDS:${PN}-ptest = "\\\n'
                '    python3-old-test (>=1.0) \\\n'
                '    python3-go2rtc-client (>=0.4.0) \\\n'
                '    bash \\\n'
                '    tzdata \\\n'
                '    ${@bb.utils.contains(\'PACKAGECONFIG\', \'integration-tests\', \'python3-pytest-rerunfailures\', \'\', d)} \\\n'
                '"\n',
                encoding="utf-8",
            )

            blockers = _reconcile_core_recipe(
                recipe_path,
                source_dir,
                {
                    "python3-core-dep": "2.1",
                    "python3-pytest-cov": "7.1",
                    "python3-pylint": "4.1",
                },
            )
            updated = recipe_path.read_text(encoding="utf-8")

        self.assertEqual(blockers, [])
        self.assertIn("python3-core-dep (>=2.0)", updated)
        self.assertIn("python3-core (>=3.14.2)", updated)
        self.assertIn("python3-statistics", updated)
        self.assertIn("python3-go2rtc-client", updated)
        self.assertIn("python3-pylint (>=4.0)", updated)
        self.assertIn("python3-pytest-cov (>=7.0)", updated)
        self.assertNotIn("python3-mypy", updated)
        self.assertNotIn("python3-types-example", updated)
        self.assertNotIn("python3-ruff", updated)
        self.assertIn("python3-pytest-rerunfailures", updated)


class UpgradeWorkflowTests(unittest.TestCase):
    def setUp(self):
        self.root = Path(self.enterContext(tempfile.TemporaryDirectory()))
        self.layer = self.root / "layer with spaces"
        self.setup = self.root / "setup with spaces"
        metadata = self.setup / "build/workspace/recipes/python3-homeassistant/python3-homeassistant"
        metadata.mkdir(parents=True)
        self.recipe = metadata.parent / "python3-homeassistant_2026.3.1.bb"
        self.recipe.write_text(
            'require original/integrations.inc\nrequire original/integrations-tests.inc\n',
            encoding="utf-8",
        )
        (metadata / "integrations.inc").write_text(
            'INTEGRATIONS = "\\\n    ${PN}-sensor \\\n"\n',
            encoding="utf-8",
        )
        (metadata / "integrations-tests.inc").write_text("", encoding="utf-8")
        images = self.layer / "recipes-homeassistant/images"
        images.mkdir(parents=True)
        (images / "homeassistant-integrations.inc").write_text(
            'IMAGE_INSTALL:append = "\\\n    python3-homeassistant-sensor \\\n"\n',
            encoding="utf-8",
        )
        self.events = []
        self.failed_command = None
        self.dependency_blockers = []
        self.core_returncode = 0
        self.expected_core_ptest_runqemu_args = ["slirp", "snapshot", "nographic"]
        self.devtool_status_outputs = ["", ""]
        self.devtool_status_calls = 0
        self.dependency_ptest_dependencies = []
        self.dependency_ptest_tracked_recipes = []
        self.enterContext(redirect_stdout(StringIO()))
        self.enterContext(patch("sys.stderr", new=StringIO()))

        mocks = {
            "_verify_local_source_mapping": None,
            "resolve_release_commit": "revision",
            "_verify_wrapper": ([self.layer], []),
            "_existing_stage_matches": True,
            "_staged_source_matches_release": True,
            "_git_output": "patched-head",
            "_reconcile_core_recipe": [],
            "build_report": "# Integration inventory\n",
        }
        for name, result in mocks.items():
            self.enterContext(patch(f"scripts.upgrade_homeassistant.{name}", return_value=result))
        self.upstream = self.enterContext(
            patch(
                "scripts.upgrade_homeassistant.read_upstream_integrations",
                return_value=({"sensor": {}}, set(), []),
            )
        )
        self.enterContext(
            patch("scripts.upgrade_homeassistant._run_in_setup", side_effect=self.run_setup)
        )
        self.enterContext(
            patch(
                "scripts.upgrade_homeassistant._stage_insufficient_providers",
                side_effect=self.stage_providers,
            )
        )
        self.enterContext(
            patch(
                "scripts.upgrade_homeassistant._run_dependency_ptests",
                side_effect=self.dependency_ptests,
            )
        )

    def stage_providers(self, *args):
        args[-1].recipe("python3-provider").devtool_upgrade = "resumed staged upgrade"
        return [("python3-provider", self.layer)], []

    def run_setup(self, setup_dir, command, runner, quiet_success=False):
        self.assertEqual(setup_dir, self.setup)
        self.events.append(command)
        if command == "devtool status":
            output = self.devtool_status_outputs[
                min(self.devtool_status_calls, len(self.devtool_status_outputs) - 1)
            ]
            self.devtool_status_calls += 1
            return subprocess.CompletedProcess([], 0, output)
        return subprocess.CompletedProcess(
            [], int(command == self.failed_command), "python3-provider :1.0\n"
        )

    def dependency_ptests(self, *args):
        self.events.append("dependency ptests")
        self.dependency_ptest_dependencies = args[0]
        self.dependency_ptest_tracked_recipes = args[6]
        return self.dependency_blockers

    def run_core_ptest(self, command, args, cwd):
        self.events.append("Core ptest")
        self.assertEqual(command, "bash")
        self.assertEqual(cwd, self.layer)
        self.assertEqual(
            list(args),
            [
                str(self.layer / "tests/image/test-pytest-plain.sh"),
                "--wrapper", "selected-wrapper",
                "--target", "selected-ptest-image",
                "--package", "python3-homeassistant",
                "--setup-dir", str(self.setup),
                "--no-default-runqemu-args",
                *[
                    item
                    for arg in self.expected_core_ptest_runqemu_args
                    for item in ("--runqemu-arg", arg)
                ],
            ],
        )
        return subprocess.CompletedProcess([], self.core_returncode, "Core ptest output")

    def run_workflow(self, image_test_helper=None, core_ptest_runqemu_args=None):
        self.expected_core_ptest_runqemu_args = (
            core_ptest_runqemu_args
            if core_ptest_runqemu_args is not None
            else ["slirp", "snapshot", "nographic"]
        )
        return run_upgrade(
            release="2026.3.1",
            layer_dir=self.layer,
            setup_dir=self.setup,
            wrapper="selected-wrapper",
            target="selected-image",
            core_ptest_target="selected-ptest-image",
            core_ptest_runqemu_args=core_ptest_runqemu_args,
            image_test_helper=image_test_helper,
            runner=self.run_core_ptest,
        )

    def test_success_preserves_gate_order_and_only_suggests_finish(self):
        self.assertEqual(self.run_workflow(), 0)
        self.assertEqual(
            self.events,
            [
                "devtool status",
                "bitbake -s",
                "devtool status",
                "bitbake python3-provider",
                "dependency ptests",
                "bitbake python3-homeassistant",
                "bitbake selected-image",
                "Core ptest",
            ],
        )
        self.upstream.assert_called_once()
        report = (self.layer / "integration-summary-2026.3.1.md").read_text()
        self.assertIn("devtool finish python3-provider", report)
        self.assertIn("devtool finish python3-homeassistant", report)
        self.assertTrue(self.recipe.is_file())
        log = (self.layer / "upgrade-logs/2026.3.1.md").read_text()
        self.assertIn("upgrade is ready for manual review", log)

    def test_external_image_helper_runs_selected_image_in_base_mode(self):
        helper = self.root / "external project/tests/run-testimage.sh"
        helper.parent.mkdir(parents=True)
        helper.touch()

        self.assertEqual(self.run_workflow(helper), 0)

        self.assertIn(
            shlex.join([
                "bash",
                str(helper),
                "--wrapper",
                "selected-wrapper",
                "--setup-dir",
                str(self.setup),
                "--target",
                "selected-image",
                "--mode",
                "base",
            ]),
            self.events,
        )
        self.assertNotIn("bitbake selected-image", self.events)
        self.assertIn("Core ptest", self.events)

    def test_core_ptest_accepts_custom_runqemu_arguments(self):
        custom_args = ["slirp", "snapshot", "wic", "ovmf.code", "ovmf.vars", "kvm"]

        self.assertEqual(self.run_workflow(core_ptest_runqemu_args=custom_args), 0)

        self.assertEqual(self.expected_core_ptest_runqemu_args, custom_args)

    def test_new_workspace_recipes_are_planned_built_and_tested_as_dependencies(self):
        self.devtool_status_outputs = [
            "",
            "python3-workspace-added: /workspace/sources/python3-workspace-added "
            "(/workspace/recipes/python3-workspace-added/python3-workspace-added.bb)\n",
        ]

        self.assertEqual(self.run_workflow(), 0)

        self.assertIn("bitbake python3-workspace-added", self.events)
        self.assertEqual(
            self.dependency_ptest_dependencies,
            [
                ("python3-provider", self.layer),
                ("python3-workspace-added", None),
            ],
        )
        self.assertEqual(
            self.dependency_ptest_tracked_recipes,
            ["python3-provider", "python3-workspace-added"],
        )
        log = (self.layer / "upgrade-logs/2026.3.1.md").read_text()
        self.assertIn(
            "Compile workspace dependency recipes and run their available fast/slow ptests: "
            "python3-provider, python3-workspace-added.",
            log,
        )
        self.assertIn("Review the owner and destination layer for workspace recipe", log)

    def test_preexisting_workspace_recipes_are_included_in_dependency_validation(self):
        workspace = (
            "python3-homeassistant: /workspace/sources/python3-homeassistant\n"
            "python3-provider: /workspace/sources/python3-provider\n"
            "python3-aiointercept: /external source/python3-aiointercept\n"
            "python3-ddt: /workspace/sources/python3-ddt\n"
        )
        self.devtool_status_outputs = [workspace, workspace]

        self.assertEqual(self.run_workflow(), 0)

        self.assertEqual(
            self.dependency_ptest_dependencies,
            [
                ("python3-aiointercept", None),
                ("python3-ddt", None),
                ("python3-provider", self.layer),
            ],
        )
        for recipe in ("python3-aiointercept", "python3-ddt", "python3-provider"):
            self.assertEqual(self.events.count(f"bitbake {recipe}"), 1)
            self.assertLess(
                self.events.index(f"bitbake {recipe}"),
                self.events.index("dependency ptests"),
            )
            self.assertIn(recipe, self.dependency_ptest_tracked_recipes)
        self.assertEqual(self.events.count("bitbake python3-homeassistant"), 1)
        log = (self.layer / "upgrade-logs/2026.3.1.md").read_text()
        self.assertIn(
            "Compile workspace dependency recipes and run their available fast/slow ptests: "
            "python3-aiointercept, python3-ddt, python3-provider.",
            log,
        )
        self.assertIn("| python3-aiointercept |", log)
        self.assertIn("| python3-ddt |", log)

    def test_saved_initial_inventory_does_not_exclude_workspace_recipes_on_resume(self):
        workspace = "python3-ddt: /workspace/sources/python3-ddt\n"
        self.devtool_status_outputs = [workspace, workspace]
        state = _load_upgrade_state(self.setup, "2026.3.1")
        state["initial_workspace_recipes"] = ["python3-ddt"]
        state["staged_dependencies"] = {
            "python3-ddt": {"owner": str(self.layer), "status": "staged"},
        }
        _save_upgrade_state(self.setup, "2026.3.1", state)

        self.assertEqual(self.run_workflow(), 0)

        self.assertIn(("python3-ddt", self.layer), self.dependency_ptest_dependencies)
        self.assertEqual(self.events.count("bitbake python3-ddt"), 1)
        report = (self.layer / "integration-summary-2026.3.1.md").read_text()
        self.assertIn("devtool finish python3-ddt", report)

    def test_build_failure_stops_before_later_builds_and_ptests(self):
        for failed in (
            "bitbake python3-provider",
            "bitbake python3-homeassistant",
            "bitbake selected-image",
        ):
            with self.subTest(command=failed):
                self.events.clear()
                self.failed_command = failed
                self.assertEqual(self.run_workflow(), 1)
                self.assertEqual(self.events[-1], failed)
                self.assertFalse((self.layer / "integration-summary-2026.3.1.md").exists())
                self.assertTrue(self.recipe.is_file())

    def test_dependency_failure_prevents_core_and_image_builds_and_ptest(self):
        self.dependency_blockers = ["Dependency ptest failed for python3-provider"]
        self.assertEqual(self.run_workflow(), 1)
        self.assertEqual(
            self.events,
            [
                "devtool status",
                "bitbake -s",
                "devtool status",
                "bitbake python3-provider",
                "dependency ptests",
            ],
        )
        self.assertFalse((self.layer / "integration-summary-2026.3.1.md").exists())
        self.assertTrue(self.recipe.is_file())

    def test_core_failure_is_logged_without_publishing_success(self):
        self.core_returncode = 7
        self.assertEqual(self.run_workflow(), 1)
        self.assertEqual(self.events[-1], "Core ptest")
        self.assertFalse((self.layer / "integration-summary-2026.3.1.md").exists())
        log = (self.layer / "upgrade-logs/2026.3.1.md").read_text()
        self.assertIn("Core ptest failed", log)
        self.assertIn("exit 7", log)

    def test_interruption_preserves_workspace_and_writes_log(self):
        with patch(
            "scripts.upgrade_homeassistant._run_dependency_ptests",
            side_effect=KeyboardInterrupt,
        ):
            self.assertEqual(self.run_workflow(), 130)
        self.assertNotIn("Core ptest", self.events)
        self.assertNotIn("bitbake python3-homeassistant", self.events)
        self.assertNotIn("bitbake selected-image", self.events)
        self.assertTrue(self.recipe.is_file())
        self.assertFalse((self.layer / "integration-summary-2026.3.1.md").exists())
        log = (self.layer / "upgrade-logs/2026.3.1.md").read_text()
        self.assertIn("Interrupted by user", log)

    def test_existing_success_report_is_not_overwritten(self):
        report = self.layer / "integration-summary-2026.3.1.md"
        report.write_text("previous success", encoding="utf-8")
        self.assertEqual(self.run_workflow(), 1)
        self.assertEqual(self.events, [])
        self.assertEqual(report.read_text(), "previous success")


class DependencyPtestTests(unittest.TestCase):
    def test_fragment_is_disabled_when_dependency_ptest_fails(self):
        with tempfile.TemporaryDirectory() as temp_dir:
            layer_dir = Path(temp_dir) / "layer"
            include_dir = layer_dir / "conf/include"
            include_dir.mkdir(parents=True)
            (include_dir / "ptest-packagelists-meta-homeassistant.inc").write_text(
                'PTESTS_FAST_META_HOMEASSISTANT = "\\\n'
                '    python3-fast-package \\\n'
                '    python3-second-package \\\n'
                '"\n'
                'PTESTS_SLOW_META_HOMEASSISTANT = "\\\n"\n',
                encoding="utf-8",
            )
            run_log = RunLog("2026.3.1")
            successful = subprocess.CompletedProcess([], 0, "")
            failed = subprocess.CompletedProcess([], 1, "ptest failure")
            with (
                patch("scripts.upgrade_homeassistant._run_in_setup", side_effect=[successful, successful]) as run_setup,
                patch("scripts.upgrade_homeassistant._run_logged", return_value=failed) as run_logged,
            ):
                blockers = _run_dependency_ptests(
                    [
                        ("python3-fast-package", layer_dir),
                        ("python3-second-package", layer_dir),
                    ],
                    layer_dir,
                    Path(temp_dir) / "setup",
                    lambda *_args: successful,
                    run_log,
                    {
                        "python3-fast-package": True,
                        "python3-second-package": True,
                    },
                    ["python3-fast-package", "python3-second-package"],
                )

        self.assertEqual(blockers, ["Dependency ptest failed for python3-fast-package"])
        self.assertEqual(run_setup.call_count, 2)
        self.assertIn("disable-fragment", run_setup.call_args.args[1])
        self.assertEqual(run_logged.call_count, 1)
        self.assertEqual(run_log.recipe("python3-fast-package").ptest_present, "yes")
        self.assertEqual(run_log.recipe("python3-fast-package").ptest_passed, "no (exit 1)")
        self.assertEqual(run_log.recipe("python3-second-package").ptest_passed, "not run")

    def test_reports_missing_ptest_support_for_staged_dependency(self):
        with tempfile.TemporaryDirectory() as temp_dir:
            layer_dir = Path(temp_dir) / "layer"
            include_dir = layer_dir / "conf/include"
            include_dir.mkdir(parents=True)
            (include_dir / "ptest-packagelists-meta-homeassistant.inc").write_text(
                'PTESTS_FAST_META_HOMEASSISTANT = "\\\n    python3-other \\\n"\n'
                'PTESTS_SLOW_META_HOMEASSISTANT = "\\\n"\n',
                encoding="utf-8",
            )
            log = RunLog("2026.3.1")
            blockers = _run_dependency_ptests(
                [("python3-no-ptest", Path(temp_dir))],
                layer_dir,
                Path(temp_dir) / "setup",
                lambda *_args: self.fail("no ptest command should run"),
                log,
                {"python3-no-ptest": True},
                ["python3-no-ptest"],
            )

        self.assertEqual(blockers, [])
        self.assertEqual(log.recipe("python3-no-ptest").ptest_present, "no")
        self.assertEqual(log.recipe("python3-no-ptest").ptest_passed, "not available")
        self.assertTrue(any("Review ptest coverage" in task for task in log.open_tasks))


if __name__ == "__main__":
    unittest.main()
