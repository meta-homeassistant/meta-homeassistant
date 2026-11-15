# Test Home Assistant images and packages

There are two different kinds of tests in this layer:

- **Image runtime tests** boot the complete Linux image in QEMU and check
  services and basic system functions such as SSH and networking.
- **Package tests (ptests)** run tests installed by an individual software
  recipe. For example, `python3-homeassistant` has tests for Home Assistant
  Core, and Python dependency recipes may have their own separate tests.

A successful BitBake build only confirms that the selected recipe or image
was built. It does not, by itself, mean that either kind of test ran. Check
the build output for `do_testimage` and its test summary, or inspect the ptest
results.

## Choose the entry point

Use the task set that belongs to the checkout you are working in. The layer's
own tasks and shell helpers target its `homeassistant-x86` build. When the
layer is included in another project, use that project's test helper instead
of the layer-local package-image scripts: the parent project owns the machine,
firmware, and QEMU arguments.

### Standalone layer checkout

In VS Code, run **Tasks: Run Task** and choose one of these tasks from
`.vscode/tasks.json`:

| Task | What it does |
|---|---|
| `Bitbake Setup - Init HomeAssistant` | Creates the `homeassistant-x86` BitBake setup. |
| `Build HomeAssistant Target` | Builds `core-image-homeassistant-full`. |
| `Run HomeAssistant QEMU Image` | Boots that image with `runqemu`. |
| `Test HomeAssistant Basic Tests` | Builds the full image with the base runtime checks and Core ptest package enabled. |
| `Test HomeAssistant Layer - Single Package` | Builds and tests one dependency ptest image; prompts for the recipe name. |
| `Test HomeAssistant Layer - All Packages` | Builds and tests all dependency images in the fast and slow lists. |
| `Test Plain Pytest Tests` | Runs a selected package's ptest over SSH in the already-built image. |
| `Test HomeAssistant Offline Unit Tests` | Runs the Python unit tests under `tests/unit/`; it does not build or boot an image. |
| `Upgrade Home Assistant Release` | Runs the Core release upgrade workflow; prompts for a release tag. |

These tasks use the layer's own wrapper. Equivalent command-line entry points
from the layer root are:

| Script | Example invocation | Purpose |
|---|---|---|
| `tests/image/test-basic-homeassistant.sh` | `bash tests/image/test-basic-homeassistant.sh --source` | Builds the full image and runs its base runtime checks. |
| `tests/image/test-single-layer-packages.sh` | `bash tests/image/test-single-layer-packages.sh --source python3-accuweather` | Builds and tests one listed dependency's ptest image. The argument is a recipe name. |
| `tests/image/test-all-layer-packages.sh` | `bash tests/image/test-all-layer-packages.sh --source` | Builds and tests every fast/slow dependency ptest image; this can take a long time. |
| `tests/image/test-pytest-plain.sh` | See [Run Home Assistant Core's ptest](#run-home-assistant-cores-ptest). | Boots an existing image and runs an installed ptest over SSH. |

The first three helpers enable the layer's `homeassistant/enable-testing-base`
fragment. Check the fragment state before running, because a pre-existing
enabled fragment should not be disabled afterward. If a command fails, inspect
and restore temporary fragment state before using the wrapper again.

The layer's VS Code tasks are conveniences for this standalone setup; they
are not the integration project's tasks.

### When this layer is included in another Yocto project

Use the integrating project's runtime/ptest helper for dependency image tests.
For example, from a project root whose helper accepts the shown interface:

```sh
bash tests/run-testimage.sh \
    --wrapper <wrapper> \
    --target meta-homeassistant-image-ptest-python3-accuweather \
    --mode ptest
```

Replace `<wrapper>` with that project's configured wrapper. This helper
applies the project's machine-specific test configuration. Do not call the
layer-local `test-single-layer-packages.sh` or
`test-all-layer-packages.sh` for this case: they source the layer's own
`homeassistant-x86` wrapper.

For Home Assistant Core, use the project's equivalent of its plain-Core
ptest task. For example, the project may wrap
`tests/image/test-pytest-plain.sh` and provide its setup directory and
machine-specific boot options. The layer helper accepts `--setup-dir`,
`--wrapper`, `--target`, and repeatable `--runqemu-arg` options; see its
`--help` output. A secure x86 UEFI image generally needs a WIC image and
OVMF arguments, while the sample layer image uses ext4.

## Maintenance scripts and offline tests

The scripts are not all independent command-line tools:

| Path | Role and invocation |
|---|---|
| `scripts/upgrade_homeassistant.py` | Main release-upgrade workflow. See [Core upgrade workflow](core-upgrade.md) for standalone and integrating-project commands. |
| `scripts/integration_inventory.py` | Upgrade-workflow module that compares upstream integration requirements and tests with this layer's metadata; not a separate metadata-editing command. |
| `scripts/ci-validate.py` and `.gitea/actions/github-status/status.py` | CI-only entry points called by `.gitea/workflows/build-HA.yaml`. The validator requires the workflow's CI environment and shared state root; use the workflow rather than invoking it as a local image test. |

The Core upgrade workflow reports dependency and integration metadata changes
for review; it does not automatically edit the integration metadata.

### Gitea validation pipeline

[The workflow](../.gitea/workflows/build-HA.yaml) has separate validation steps:

1. Test the CI scripts.
2. Acquire exclusive access to the shared build and detect changed recipes.
3. Initialize a fresh `homeassistant-x86` wrapper from the current configuration
   with both `TEST_FRAGMENTS` from [the stage runner](../scripts/ci-validate.py).
4. Build and test the selected `meta-homeassistant-image-ptest-<recipe>`
   targets together in one `bitbake -k` invocation. Failures are named
   individually and independent dependencies still run. This stage is advisory:
   failed or unfinished tests retry on the next run without blocking the
   full-image stage.
5. Build `core-image-homeassistant-full` with automatic `testimage`, even if
   dependency ptests failed, provided preparation succeeded.
6. Record the required results, advance the baseline only on success, and
   release exclusive access even on failure/cancellation.

[The planner](../scripts/ci-plan.py) compares full-image inputs against the
branch's last image-successful ancestor, including changes preceding a failed
image run. This full-image baseline advances when setup and full-image tests
pass, even if dependency ptests fail.
A new branch can reuse the nearest validated ancestor from another branch in
the same repository/configuration. Git ancestry is used for image-baseline
planning, not as proof that dependency ptests ran against the current inputs.
The full-image stage still runs on every push.

Dependency ptest reuse has a separate, branch-independent provenance cache:

- The environment fingerprint covers actual external layer HEADs and origins,
  configured sources, resolved rolling revisions, the selected configuration,
  generated build settings, and shared Home Assistant metadata. Shared metadata
  includes configuration, classes, includes, image/packagegroup policy, OEQA
  code, and image test helpers.
- Each recipe fingerprint covers its recipe, appends, and recipe-local files,
  including patches, test runners, and executable permissions. Unrelated
  documentation commits do not invalidate successes. Changed external layers
  or shared metadata conservatively invalidate all ptests for that environment;
  changing one recipe's local inputs selects that recipe again.
- Only matching successes are reused. Failed and pending tests retry on the
  next run. Returning to a previously tested layer combination or recipe
  content can reuse successes across branches, even without a validated Git
  ancestor. Legacy results without provenance are revalidated.
- CI checks the environment before and after execution and refuses to cache
  results if it changed during the batch.

Results live under
`$CI_STATE_ROOT/ptest-cache/<repository-and-configuration-hash>/<environment-hash>/`.
Each directory contains a readable `environment.json` manifest and a result
JSON per recipe-input fingerprint, recording the recipe, status, environment,
Home Assistant commit, branch, and originating workflow run. This is the only
source of reusable ptest results. Current run reports and image-baseline history
retain reporting snapshots; legacy `ptest-state/` files are no longer read or
updated. Keep the provenance version in sync with changes to the fingerprinting
policy.

Only effective fast/slow inventories generate dependency images; disabled
inventories do not. This is conservative metadata-based reuse, not complete
dynamic-include or transitive dependency analysis. BitBake independently decides
which compilation tasks need rebuilding.

Selected dependency images are submitted together in one `bitbake -k`
invocation, allowing BitBake to share the dependency graph and schedule
independent builds and QEMU tests concurrently. Per-image `do_testimage`
completion events record passes and failures; images that never reach test
completion remain pending. A fresh result directory for each batch prevents
old test results from being reused. Independent images continue after a task
failure, and successful results are saved even when another image fails.

Disk policy:

- All branches use one wrapper at
  `/cache/builddir/homeassistant-ci/bitbake-builds/homeassistant-x86`.
  Downloads and sstate retain the existing shared cache paths.
- CI enables `rm_work` to remove successful intermediate work.
- Every preparation uses `bitbake-setup init`. Previous complete or incomplete
  wrappers are preserved with a `.previous-<timestamp>` suffix. They may consume
  significant disk space; inspect them and confirm no job needs them before
  removing them manually. Validation history and the ptest cache live outside
  the wrapper and survive its replacement.
- Successful dependency images are cleaned with `bitbake -c clean <image>`
  after the batch finishes; package recipes and shared sstate are not cleaned.
  Failed images are retained for diagnosis. Test logs are kept outside image
  work directories in the wrapper's `build/ci-test-logs/<image>`.
- Branch baselines are small JSON files under `baselines/`. Old per-branch
  build trees from the previous pipeline are not automatically deleted.
- Small per-commit records under `baselines/history/` preserve validated fork
  points after the original branch advances.
- Shared downloads/sstate and retained logs still need an operator-managed
  retention policy; this workflow does not delete shared caches.

The exclusive lock covers **all** stages, not just individual BitBake commands.
An atomic owner file persists across workflow steps; contenders wait up to six
hours. Normal failure/cancellation releases it in an `always()` step, and only
its owning run may release it. If the runner/container is forcibly terminated
before cleanup, confirm the owning run has stopped before manually removing
`/cache/builddir/homeassistant-ci/build.lock`. Do not remove a live lock.
Other workflows using this wrapper must use the same locking protocol.
Drain old workflow runs before rollout: the previous pipeline used a different
lock and its image-only baselines cannot establish dependency ptest coverage.
The first new run without a compatible validated ancestor tests all enabled
dependency ptests.

Future layer lint and all-integration builds should be independent workflow
steps. Initially use `continue-on-error: true` for advisory checks. The result
stage promotes the full-image baseline based on successful `prepare` and
`image` results only. It reports pending ptests, but they do not block
baseline advancement. Optional checks must not modify these required results.
Do not introduce a second concurrent build using the shared wrapper, and
restore any temporary integration feature/fragment before subsequent stages.

Offline Python tests do not boot QEMU. From the layer root, run the unit
suite with:

```sh
.venv/bin/python -m unittest discover -s tests/unit -t .
```

The Gitea workflow runs the CI-planner and status-action tests from the same
directory:

```sh
python3 -m unittest tests.unit.test_ci_validation tests.unit.test_github_status
```

All offline Python tests are under `tests/unit/`. `tests/image/` contains
scripts that build or boot test images. The Gitea workflow runs its CI-planner
and status-action tests before invoking `scripts/ci-validate.py`.

## Run image runtime tests

The `homeassistant/enable-testing-base` build fragment enables Yocto's
`testimage` class and this runtime test suite: date, disk-space, ping, ptest,
SCP, and SSH checks. It adds `ptest-runner` to tested images. With the
fragment enabled, building an image automatically boots it in QEMU and runs
the configured checks.

From the layer checkout, enable the fragment, build an image, and then
disable the fragment when the test run is complete:

First check whether the fragment is already active in
`bitbake-builds/homeassistant-x86/build/conf/toolcfg.conf`. If it is already
active, leave it enabled and omit the enable/disable commands below.

```sh
LAYER_DIR="$PWD"
SETUP_DIR="$LAYER_DIR/bitbake-builds/homeassistant-x86"
(
    set -e
    source "$SETUP_DIR/build/init-build-env"
    bitbake-config-build enable-fragment homeassistant/enable-testing-base
    bitbake core-image-homeassistant-full
    bitbake-config-build disable-fragment homeassistant/enable-testing-base
)
```

If the build or QEMU test stops before the final command, disable the
temporary fragment yourself before continuing:

```sh
bitbake-config-build disable-fragment homeassistant/enable-testing-base
```

Do not disable a fragment that was enabled in your build before you started.
For other build environments, substitute the relevant wrapper and image.
QEMU boot options and firmware requirements depend on the selected machine.

## Run a dependency recipe's ptest

Dependency test images are generated from the fast and slow package lists in
[`ptest-packagelists-meta-homeassistant.inc`](../conf/include/ptest-packagelists-meta-homeassistant.inc).
For a listed recipe, the generated image target is
`meta-homeassistant-image-ptest-<recipe>`. For example,
`python3-accuweather` has the target
`meta-homeassistant-image-ptest-python3-accuweather`.

Enable the test fragment before building the target so BitBake runs the image
runtime tests and the dependency's ptest in QEMU. If the fragment is already
active, leave it enabled and omit the enable/disable commands:

```sh
source bitbake-builds/homeassistant-x86/build/init-build-env
bitbake-config-build enable-fragment homeassistant/enable-testing-base
bitbake meta-homeassistant-image-ptest-python3-accuweather
bitbake-config-build disable-fragment homeassistant/enable-testing-base
```

Replace the example recipe with one in the fast or slow list. The target
tests that dependency package's own tests; it does not run the Home Assistant
Core or integration test suites. The aggregate
`meta-homeassistant-image-ptest-all` builds and tests every recipe in both
lists and can take substantially longer. Start with one dependency target
when diagnosing a failure.

## Run Home Assistant Core's ptest

The Core ptest is a different test subject from dependency ptests. The
provided `tests/image/test-pytest-plain.sh` helper connects to a running QEMU
image over SSH and runs the ptest files installed for `python3-homeassistant`.
The image must already be built, include the Core ptest files, and provide
SSH access.

To run Core's ptest under testimage, enable the base testing fragment and the
Core test-dependencies fragment, then rebuild the full image. The base
fragment adds `ptest-runner`; the Core fragment adds the ptest package only
to the full Home Assistant image. Check both fragments in
`bitbake-builds/homeassistant-x86/build/conf/toolcfg.conf` first. The example
assumes both were disabled; if one was already active, leave it enabled and
omit its enable and cleanup commands.

```sh
LAYER_DIR="$PWD"
SETUP_DIR="$LAYER_DIR/bitbake-builds/homeassistant-x86"
(
    set -e
    source "$SETUP_DIR/build/init-build-env"
    bitbake-config-build enable-fragment homeassistant/enable-testing-base
    bitbake-config-build enable-fragment homeassistant/add-homeassistant-image-test-deps
    bitbake core-image-homeassistant-full
    bitbake-config-build disable-fragment homeassistant/add-homeassistant-image-test-deps
    bitbake-config-build disable-fragment homeassistant/enable-testing-base
)
```

If the build fails before the final commands, disable only the fragments that
this run enabled. Then run the ptest helper for the supplied x86 wrapper and
full image:

```sh
bash tests/image/test-pytest-plain.sh \
    --wrapper homeassistant-x86 \
    --target core-image-homeassistant-full \
    --package python3-homeassistant \
    --no-default-runqemu-args \
    --runqemu-arg slirp \
    --runqemu-arg snapshot \
    --runqemu-arg nographic
```

The `homeassistant/add-homeassistant-image-test-deps` fragment can also be
used alone when you only need the Core ptest package and do not want to enable
testimage. The example uses the image's default filesystem rather than forcing
a WIC disk image. The helper starts QEMU, waits for SSH, runs the tests, and
writes logs under `test-logs/`. For another project or machine, use its correct
boot arguments and ensure the image includes the ptest package and an SSH
server.

## Upgrade testing

The Core upgrade script runs dependency builds and available dependency
ptests before building the Core recipe and selected image. It then runs the
Core ptest. Read [Core upgrade workflow](core-upgrade.md) for the complete
sequence, test-helper options, and where to find the reports.
