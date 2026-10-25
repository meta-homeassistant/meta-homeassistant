# Build a Home Assistant image

This guide builds a bootable Home Assistant image for the x86-64 QEMU virtual
machine. It assumes you have a Linux build host that meets the
[Yocto Project system requirements](https://docs.yoctoproject.org/ref-manual/system-requirements.html).
Yocto builds download many source archives and use substantial disk space.

In Yocto terminology, a **layer** is a collection of recipes and configuration,
a **distro** selects system-wide policy, and a **machine** describes the
hardware or virtual machine the image will boot on. The provided
configurations select the layers, distro, and machine together.

## Choose an image

An image is the installable filesystem and boot configuration for a target
machine. This layer provides these common image recipes:

- `core-image-homeassistant`: a smaller image that installs Home Assistant
  Core.
- `core-image-homeassistant-full`: a larger image that explicitly includes
  the layer's supported integration packages and an OpenSSH server.

An integration is a Home Assistant component that connects to a device,
service, or data source. Use the full image to try the broadest set of
integrations; use the smaller image as a starting point for a customized
product image. Package recommendations can add packages beyond those listed
directly by an image recipe.

The examples below use `qemux86-64`, so they build for QEMU rather than a
physical device. For another machine, select a build configuration that
provides that machine and check its boot and test settings.

## Recommended: build with bitbake-setup

`bitbake-setup` reads a JSON build configuration, obtains the configured
layer sources, and creates a build directory with the selected layers,
machine, and distro. The supplied
[`homeassistant.conf.json`](../configurations/homeassistant.conf.json)
configuration sets up an x86-64 QEMU build at
`bitbake-builds/homeassistant-x86`.

Run the following from the root of the meta-homeassistant checkout. The
BitBake source checkout must be available at `sources/bitbake`. If it is
missing, clone it first:

```sh
mkdir -p sources
git clone https://git.openembedded.org/bitbake sources/bitbake
```

```sh
sources/bitbake/bin/bitbake-setup init \
    configurations/homeassistant.conf.json homeassistant-x86
```

The setup command may take time because it fetches the configured source
repositories. Once initialization finishes, build the full image:

```sh
source bitbake-builds/homeassistant-x86/build/init-build-env
bitbake core-image-homeassistant-full
```

Sourcing `init-build-env` prepares the shell for this build directory. It can
change the current directory; run BitBake commands in that same shell.

After changing the layer list, machine, distro, or build fragments, update
the generated configuration:

```sh
sources/bitbake/bin/bitbake-setup update \
    --setup-dir bitbake-builds/homeassistant-x86 \
    --update-bb-conf yes
```

The init and build commands are also available as the **Bitbake Setup - Init
HomeAssistant** and **Build HomeAssistant Target** tasks in
[`.vscode/tasks.json`](../.vscode/tasks.json).

The configuration selects the `wrynose` branch family and pins some
dependencies to known commits. Use this configuration consistently for a
build directory; do not mix its source revisions with another build setup.

The sample configuration accepts some packages with commercial license
flags so that the full image can be built. Review the licenses for the
packages you include and confirm your right to redistribute them before
shipping an image.

## Deprecated: kas

The kas-based setup is deprecated; use `bitbake-setup` for new builds.
The files under `kas/` are retained for existing users and older build
environments, but they follow upstream development branches and may not use
the same source revisions as `configurations/homeassistant.conf.json`.
Do not combine the kas source revisions with a `bitbake-setup` build
directory.

## Required layers and version compatibility

The supplied configurations select the layers and revisions required by this
project. The main dependencies are:

- Poky/OpenEmbedded Core and BitBake: the build system and base recipes.
- `meta-openembedded`: Python, networking, multimedia, and filesystem
  recipes used by Home Assistant and its integrations.
- `meta-python-ai`, `meta-clang-revival`, and `meta-virtualization`: recipes
  required by some Python packages, including scientific-computing packages.
- `meta-sca`: native tools used while building some integrations.
- `meta-homeassistant`: Home Assistant Core, integration, and image recipes.

Home Assistant and its Python dependencies change frequently. Use the
revisions selected by the configuration you chose; mixing arbitrary layer
branches can result in missing recipes or incompatible dependency versions.
This layer primarily follows current upstream development and does not claim
support for older Yocto releases.

## Customize the image

The `python3-homeassistant` recipe installs the Home Assistant Core server.
Supported integrations are packaged separately. To explicitly include an
integration in a product image, add its package (usually named
`python3-homeassistant-<integration>`) to `IMAGE_INSTALL`. See
[`core-image-homeassistant-full.bb`](../recipes-homeassistant/images/core-image-homeassistant-full.bb)
and
[`homeassistant-integrations.inc`](../recipes-homeassistant/images/homeassistant-integrations.inc)
for the supplied full-image package list.

Some dependency versions need distro-level preferences so BitBake selects
compatible providers. The sample `homeassistant` distro includes preferences
for known conflicts; see
[`homeassistant.conf`](../conf/distro/homeassistant.conf).
