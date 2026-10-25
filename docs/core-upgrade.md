# Upgrade Home Assistant Core

This guide explains how to run `scripts/upgrade_homeassistant.py` to update
the layer's Yocto recipe for Home Assistant Core to a specific upstream
release.

Home Assistant Core is the server process. The layer also provides separate
recipes for Python libraries and Home Assistant integrations (components
that connect to devices and services). An upgrade changes the Core recipe
and checks that required library and integration recipes are compatible with
the selected Core release.

## Before you start

You need:

- A checkout of this layer and an existing BitBake build directory. The build
  directory must already have the correct layers, distro, machine, and
  image target for your project.
- A working network connection so the script can resolve the upstream Core
  release tag and BitBake can fetch source code.
- Python 3 and the script's Python packages. From the layer checkout, install
  them into a virtual environment if you do not already have one:

  ```sh
  python3 -m venv .venv
  .venv/bin/pip install -r scripts/requirements.txt
  ```

- An image that can boot in your test environment and, for the Core ptest,
  contains the Core ptest files and provides SSH access.

Do not use a different BitBake build directory from the one passed to the
script. A workspace created by `devtool` belongs to that build directory.

## Run with this layer's build configuration

The supplied `homeassistant-x86` build uses the sample Home Assistant distro
and the `qemux86-64` machine. If it is not initialized, see
[Build setup](build-setup.md). Choose an image target that exists in the
active build configuration; the example uses the full image.

The Core ptest uses `tests/image/test-pytest-plain.sh` to boot the selected
image and run its installed tests over SSH. By default, the upgrade workflow
passes `slirp`, `snapshot`, and `nographic` to `runqemu`, matching the sample
image's `ext4.zst` output without requiring WIC, KVM, or OVMF. The image still
needs to be bootable on the selected machine and provide SSH.

For a build that requires different boot options, pass each argument with a
separate `--core-ptest-runqemu-arg`. These replace the defaults. For example,
an x86 UEFI build that provides a WIC image and OVMF can use:

```sh
--core-ptest-runqemu-arg slirp \
--core-ptest-runqemu-arg snapshot \
--core-ptest-runqemu-arg wic \
--core-ptest-runqemu-arg ovmf.code \
--core-ptest-runqemu-arg ovmf.vars \
--core-ptest-runqemu-arg kvm \
--core-ptest-runqemu-arg nographic
```

Only include options supported by the image and host. For example, `kvm`
requires host KVM access, and `wic`/`ovmf.*` require a compatible WIC image
and firmware. A successful Core compile or image build does not by itself
mean the Core ptest passed.

The Core ptest needs the test files installed in the image. For the supplied
image, enable the `homeassistant/add-homeassistant-image-test-deps` fragment
before running the workflow. If it is already active, leave it enabled:

```sh
LAYER_DIR="$PWD"
SETUP_DIR="$LAYER_DIR/bitbake-builds/homeassistant-x86"
(
    source "$SETUP_DIR/build/init-build-env"
    bitbake-config-build enable-fragment homeassistant/add-homeassistant-image-test-deps
)
```

Keep this fragment enabled until the workflow finishes, then disable it:

```sh
(
    source "$SETUP_DIR/build/init-build-env"
    bitbake-config-build disable-fragment homeassistant/add-homeassistant-image-test-deps
)
```

If the workflow fails before cleanup, disable the temporary fragment yourself.
Do not disable it if it was already enabled before you started.

From the root of the layer checkout, run:

```sh
.venv/bin/python scripts/upgrade_homeassistant.py \
    --release 2026.3.1 \
    --layer-dir "$PWD" \
    --setup-dir "$PWD/bitbake-builds/homeassistant-x86" \
    --wrapper homeassistant-x86 \
    --target core-image-homeassistant-full \
    --core-ptest-target core-image-homeassistant-full
```

Replace `2026.3.1` with the exact release tag to upgrade to. Before staging
changes, the script verifies the release tag, confirms this layer is active
in the selected build directory, and checks that BitBake can resolve the
image target.

With no test-helper options, the script uses the layer's own
`homeassistant/enable-testing-base` fragment for dependency test images when
needed. It restores that fragment if it enabled it. The selected image is
built with plain BitBake using the build directory's current configuration.
Afterward, the Core ptest helper boots the selected image and runs the
installed Core tests over SSH. The fragment above adds
`python3-homeassistant-ptest` and `ptest-runner` to the sample image.

## Run from another Yocto project

When this layer is included in a larger project, use that project's testimage
helper. The project helper knows how to boot its images, including any
machine-specific requirements such as OVMF firmware for an x86 UEFI machine.
Pass the helper in both options:

- `--dependency-ptest-helper` runs each dependency test image with ptests
  enabled.
- `--image-test-helper` builds and runtime-tests the selected image in base
  mode, using the project's machine-specific test configuration.

For example, from the meta-homeassistant checkout:

```sh
PROJECT_SETUP=/path/to/project/bitbake-builds/homeassistant
PROJECT_TEST_HELPER=/path/to/project/tests/run-testimage.sh

.venv/bin/python scripts/upgrade_homeassistant.py \
    --release 2026.3.1 \
    --layer-dir "$PWD" \
    --setup-dir "$PROJECT_SETUP" \
    --wrapper homeassistant \
    --target homeassistant-image \
    --core-ptest-target homeassistant-image \
    --core-ptest-runqemu-arg slirp \
    --core-ptest-runqemu-arg snapshot \
    --core-ptest-runqemu-arg wic \
    --core-ptest-runqemu-arg ovmf.code \
    --core-ptest-runqemu-arg ovmf.vars \
    --core-ptest-runqemu-arg kvm \
    --core-ptest-runqemu-arg nographic \
    --dependency-ptest-helper "$PROJECT_TEST_HELPER" \
    --image-test-helper "$PROJECT_TEST_HELPER"
```

Replace the setup path, wrapper name, image targets, and helper path with
values from the integrating project. The helper must accept `--wrapper`,
`--setup-dir`, `--target`, and `--mode`. The integrating project must also
ensure the selected image installs `python3-homeassistant-ptest` and provides
SSH access for the Core ptest.

If `--image-test-helper` is omitted, the script builds the selected image
with plain `bitbake`. When `TESTIMAGE_AUTO` is enabled, BitBake then runs
`do_testimage` using only the test fragments already active in that build
directory. Use the image helper when the project needs to enable its own
test fragment for the selected image.

## Workflow and results

The workflow runs these gates in order and stops at the first failure:

1. Resolve the release tag and verify the active build setup.
2. Reuse a matching staged Core workspace or stage the release with
   `devtool`.
3. Compare the release's Core requirements and supported integrations with
   the layer's recipes and metadata.
4. Check dependency recipe versions; stage providers that are missing or too
   old.
5. Compile staged dependency recipes and run their ptests when they are
   included in the layer's fast or slow ptest lists.
6. Compile `python3-homeassistant`, build and runtime-test the selected
   image, then run the Core ptest.

Not every dependency has a ptest in the configured fast or slow groups. The
report records these coverage gaps; they are not treated as passing tests.
The Core ptest is the recipe's packaged test suite, not a test of every
Home Assistant integration or connected device.

Each run writes `upgrade-logs/<release>.md`. On successful validation, the
script also writes `integration-summary-<release>.md` and provides suggested
`devtool finish` commands for review. It does **not** run `devtool finish`:
review and export the staged recipe changes yourself. If a gate fails, read
the first actionable error in the run log and relevant BitBake task log
before rerunning. Existing workspace changes are preserved for review.

This workflow validates the configured recipes, image, and tests; it is not
a guarantee that every Home Assistant integration or device has been tested.
