# Meta-Homeassistant

This layer adds the software recipes and image definitions needed to build [Home Assistant](https://www.home-assistant.io/) for an OpenEmbedded/Yocto Linux system. It is not a prebuilt operating system: you use a Yocto build to combine this layer with the selected machine, distro, and other required layers.

For help or discussion, join the [`#meta-homeassistant:matrix.org`](https://matrix.to/#/#meta-homeassistant:matrix.org) room.

## Documentation

- [Build setup](docs/build-setup.md): set up a build with the recommended `bitbake-setup` workflow.
- [Testing](docs/testing.md): run image checks and packaged tests (ptests).
- [Core upgrade workflow](docs/core-upgrade.md): update and validate the recipe for a specific Home Assistant Core release.

## Quick start

Install the [Yocto host build requirements](https://docs.yoctoproject.org/ref-manual/system-requirements.html)
and make sure the BitBake checkout is available at `sources/bitbake`. From
the root of this layer checkout, initialize the supplied x86 build:

```sh
sources/bitbake/bin/bitbake-setup init \
    configurations/homeassistant.conf.json homeassistant-x86
```

Then build the full Home Assistant image for QEMU:

```sh
source bitbake-builds/homeassistant-x86/build/init-build-env
bitbake core-image-homeassistant-full
```

See [Build setup](docs/build-setup.md) for details, including how to start
the image in QEMU. The kas-based setup is deprecated; existing kas
configurations remain available for legacy builds.

## Automation and testing

Choose the task set for the checkout that owns the build:

- For a standalone layer build, use the task shortcuts in the layer's
  `.vscode/tasks.json` or run the scripts below from the layer root.
- When the layer is included in another Yocto project, use that project's
  test runner and build tasks. Its helper supplies machine-specific QEMU
  settings, such as WIC and OVMF for x86 UEFI. The [testing guide](docs/testing.md)
  lists the corresponding integrated-project tasks and commands.

### Standalone layer commands

| Goal | Command |
|---|---|
| Initialize the supplied build | VS Code task `Bitbake Setup - Init HomeAssistant` |
| Build the full image | VS Code task `Build HomeAssistant Target` |
| Run the full image in QEMU | VS Code task `Run HomeAssistant QEMU Image` |
| Run base image checks | `bash tests/image/test-basic-homeassistant.sh --source` |
| Test one listed dependency's ptest | `bash tests/image/test-single-layer-packages.sh --source python3-accuweather` |
| Test all listed dependency ptests | `bash tests/image/test-all-layer-packages.sh --source` |
| Run the Core upgrade workflow | VS Code task `Upgrade Home Assistant Release`; see [Core upgrade workflow](docs/core-upgrade.md) for the command-line form. |

The layer's `Test Plain Pytest Tests` task and
[`tests/image/test-pytest-plain.sh`](tests/image/test-pytest-plain.sh) run a
package ptest over SSH in an existing image. See
[testing](docs/testing.md#run-home-assistant-cores-ptest) for image setup and
the invocation.

[`scripts/upgrade_homeassistant.py`](docs/core-upgrade.md) is the supported
release-upgrade workflow. It compares a selected Core release with layer
metadata and writes a report for review; it does not automatically edit
integration metadata. `scripts/integration_inventory.py` provides the
comparison used by the workflow. The CI validator and status action run in
the repository's Gitea workflow, not as general local build commands.

`scripts/` contains maintenance and CI tools, `tests/image/` contains
image/QEMU test helpers, and `tests/unit/` contains all offline Python unit
tests. The [testing guide](docs/testing.md) maps these files to their purpose
and explains which helpers are suitable when this layer is embedded in
another project.

## Layer structure

- `recipes-homeassistant/`: Home Assistant Core, integration, and image recipes.
- `recipes-devtools/`: Python library recipes required by Home Assistant and its integrations.
- `recipes-support/`: supporting software recipes used by this layer.
- `conf/`: layer, distro, and machine configuration, plus build fragments.
- `classes/`: BitBake classes shared by recipes in this layer.
- `dynamic-layers/`: optional recipe extensions activated when other layers are present.
- `configurations/`: `bitbake-setup` build configurations.
- `kas/`: deprecated build configurations retained for existing users.
- `docs/`: build setup, testing, and Core upgrade guides.
- `scripts/`: Core upgrade, component-metadata, and CI tools.
- `tests/image/`: image runtime and package-ptest helpers.
- `tests/unit/`: offline Python unit tests for layer tools and CI helpers.
- `.vscode/tasks.json`: standalone-layer build and test task shortcuts.

## Contributing

Please submit patches as pull requests on GitHub.

## Maintainers

- Pascal Bach <pascal.bach@nextrem.ch>
- Tom Geelen <t.f.g.geelen@gmail.com>
- Tim "moto-timo" Orling <ticotimo@gmail.com>
