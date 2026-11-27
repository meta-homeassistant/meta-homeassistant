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
| `Lint: Meta HomeAssistant` | Runs `oelint-adv` on layer metadata using the checked-in configuration. |
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

The lint task requires `oelint-adv` on `PATH`. It also runs from the command
line with `bash scripts/lint-oelint.sh`, using the layer's `.oelint.cfg`.
It checks tracked and non-ignored untracked metadata, excluding `sources/`
and Git-ignored build artifacts.

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

| Path | Role and invocation |
|---|---|
| `scripts/upgrade_homeassistant.py` | Main release-upgrade workflow. See [Core upgrade workflow](core-upgrade.md) for standalone and integrating-project commands. |
| `scripts/integration_inventory.py` | Compares integration requirements and tests for the upgrade report. |

### Automated validation

Automated CI validation has these outcomes:

1. Offline unit tests run, layer metadata is linted, and dependency ptests are
   planned. Lint findings are advisory and do not block image validation.
2. Dependency ptest images are built and tested. These checks are advisory:
   dependency failures do not block a pull request by themselves.
3. `core-image-homeassistant-full` is built and boot-tested in QEMU. This
   image validation is required. A successful build alone is not enough; CI
   requires the runtime-test task and a successful OEQA summary.
4. A validation report and CI job logs are available for pull-request review.
   Inspect them for the affected package or image and the exact failure.

CI uses the project wrapper and host-specific build configuration. The wrapper
and host setup are maintained by the project; use the local or integrating-
project commands above rather than relying on CI host details.

#### Reusing validation results

CI checks all enabled dependency ptest images and `core-image-homeassistant-full`
in one signature-only BitBake invocation (`-S none -c testimage`). This resolves
their dependency graphs without compiling packages or booting QEMU. The log and
validation report include the signature-scan duration and reused/selected counts.

- Any external layer revision change, including BitBake, invalidates all results.
  Floating revisions such as `master` can therefore invalidate results even
  when the Home Assistant commit only changes a recipe.
- Shared Home Assistant configuration, classes, test infrastructure, CI policy,
  generated build configuration, or runner OS/kernel/architecture changes also
  invalidate dependency results.
- Recipe edits, appends, patches, and includes are handled by BitBake's resolved
  dependency signatures. A changed dependency invalidates consuming ptest
  images, not unrelated images. Recipe-local Git fingerprints additionally
  track the tested recipe's checked-in files and permissions.
- Full-image validation retains a fingerprint of all non-documentation layer
  inputs, so recipe changes invalidate `core-image-homeassistant-full` even if
  no dependency ptest image uses that recipe.
- Only successful, matching results are reused. Failed or missing results are
  retried. Dependencies must be declared correctly in BitBake metadata.

The test fingerprint combines `do_testimage`'s input/base hash and file checksums
with its direct dependencies' task hashes, including `do_image_complete`.
Dependency task hashes carry transitive build and package dependencies.
`do_testimage`'s own task hash is deliberately excluded: it contains a fresh
`nostamp` execution nonce and would otherwise prevent reuse on identical runs.
The normal build/test invocation still runs `do_testimage` for selected images.
The signature-export class is only inherited for the signature scan.

The signature scan is performed on cold caches too, to seed dependency-aware
results for subsequent runs. The cache policy version changes once when this
scheme is introduced; older result entries are retained but are not reused.
This result cache does not delete or disable BitBake's downloads or sstate cache.

Run the offline Python unit suite from the layer root with:

```sh
.venv/bin/python -m unittest discover -s tests/unit -t .
```

All offline Python tests are under `tests/unit/`. `tests/image/` contains
scripts that build or boot test images. CI runs focused unit tests before
validation.

An optional regression test runs real BitBake against a temporary miniature
metadata fixture. It checks stable repeat scans, transitive runtime dependencies,
includes, local patch checksums, and test-policy changes without executing tasks.
It never uses the shared CI build directory. Enable it with an existing BitBake
executable:

```sh
HA_CI_BITBAKE=/path/to/bitbake/bin/bitbake \
    python3 -m unittest tests.unit.test_ci_validation tests.unit.test_github_status
```

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
