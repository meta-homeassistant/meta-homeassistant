This README file contains information on the contents of the
homeassistant layer. It contains recipes to run https://home-assistant.io/
on a OE target.

If you need help or like to discuss a topic please join the [`#meta-homeassistant:matrix.org`](https://matrix.to/#/#meta-homeassistant:matrix.org) room on [matrix.org](https://matrix.org/).


Please see the corresponding sections below for details.

# Quickstart

```sh

git clone https://git.yoctoproject.org/git/poky
cd poky
git clone https://github.com/openembedded/meta-openembedded.git
git clone https://github.com/meta-homeassistant/meta-homeassistant.git

. ./oe-init-build-env

bitbake-layers add-layer ../meta-openembedded/meta-oe
bitbake-layers add-layer ../meta-openembedded/meta-python
bitbake-layers add-layer ../meta-openembedded/meta-networking
bitbake-layers add-layer ../meta-homeassistant

bitbake core-image-homeassistant

runqemu qemux86 nographic

```

You should now be able to access Home Assistant via web browser usually under the address: http://192.168.7.2:8123

# Dependencies

```
URI: https://git.yoctoproject.org/git/poky
branch: master
revision: HEAD

URI: https://github.com/openembedded/meta-openembedded.git
branch: master
revision: HEAD
```

Why are these needed?

- [meta-oe](https://github.com/openembedded/meta-openembedded/tree/mickledore/meta-oe) : contains meta-python
- [meta-python](https://github.com/openembedded/meta-openembedded/tree/mickledore/meta-python) : contains many of the required python3 packages
- [meta-networking](https://github.com/openembedded/meta-openembedded/tree/mickledore/meta-networking) : contains several networking oriented python3 packages

# Build configuration

Home Assistant requires specific versions of some of its python dependencies. The recipe makes sure those dependencies are satisfied at root filesystem generation time but that doesn't give any gurantees that `bitbake` will pick a version that satisfies the version restriction in `RDEPENDS`. In order for the build to select the right versions, your distro file should include the version selection in `conf/distro/include/ha-versions.inc` when you are building `python3-homeassistant`. A sample distro (that can also be used as such, is provided - see `homeassistant.conf`).

Also to note is that packages in HomeAssistant update very rapidly. This means that, in order to properly build this, the project is up to date with the layer branches on which this layer depends.
All missing recipes are backported into this layer to ensure functionality from meta-openembedded and poky.

# Configuring HA
Note that `python3-homeassistant-xxx.bb` only the critical components are directly installed via `RDEPENDS`. Any optional component is installed via `RRECOMMENDS`. 
So if you are missing something, ensure it is build so it will be installed.

# Layer structure
The layer is structured in the following way:

- recipes-homeassistant/homeassistant: contains the core recipe needed to run homeassistant via Yocto
- recipes-homeassistant/homeassistant-core-deps: contains recipes of components which are critical for a minimal homeassistant build. Without these HomeAssistant will not run
- recipes-homeassistant/homeassistant-deps: contains optional components for HomeAssistant

The recipes-devtools folder then contains all Yocto python recipes which do not fit the above categories. Most often these are tertiary dependencies.

# Contributing

Please submit any patches against the homeassistant as Pull Requests on Github.

## Maintainers

* Pascal Bach <pascal.bach@nextrem.ch>
* Tom Geelen <t.f.g.geelen@gmail.com>
