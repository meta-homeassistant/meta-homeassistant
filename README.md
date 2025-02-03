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

# Using [kas](https://github.com/siemens/kas)

The project provides files to quickly get started using [kas](https://github.com/siemens/kas).

The two main entry points are `kas/homeassistant-main.yml` and `kas/homeassistant-main-full.yml`.

To build against latest Yocto master use:
```
kas build kas/homeassistant-main.yml
```

## Updating lock file

The dependencies are locked to a given version. In order to update the layers run:

```
kas lock --update kas/homeassistant-main.yml
kas lock --update kas/homeassistant-main-full.yml
```

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

Note: HomeAssistant regularly uses the very latest versions of python packages in their builds. This also means that from a Yocto/OE perspective the team is forced to keep track of master as the very latest pushes to the dependency layers are often required for succesfull builds and satisfying dependency requirements. Therefore this repository tracks the upstream master branch and currently no older releases of Yocto are specifically supported.

# Build configuration

Home Assistant requires specific versions of some of its python dependencies. The recipe makes sure those dependencies are satisfied at root filesystem generation time but that doesn't give any gurantees that `bitbake` will pick a version that satisfies the version restriction in `RDEPENDS`. In order for the build to select the right versions, your distro file should include the version selection in `conf/distro/include/ha-versions.inc` when you are building `python3-homeassistant`. A sample distro (that can also be used as such, is provided - see `homeassistant.conf`).

Also to note is that packages in HomeAssistant update very rapidly. This means that, in order to properly build this, the project is up to date with the layer branches on which this layer depends.
All missing recipes are backported into this layer to ensure functionality from meta-openembedded and poky.

# Configuring HA
Note that with `python3-homeassistant.bb` only the critical components are directly installed via `RDEPENDS`.
Any optional component is installed via `RRECOMMENDS`.
So if you are missing something you can enforce it by specifically adding it to an `IMAGE_INSTALL`.

# Layer structure
The layer is structured in the following way:

- kas: contains all kas configuration.
- recipes-homeassistant/homeassistant: contains the core recipe needed to run homeassistant via Yocto
- recipes-homeassistant/images: contains sample images to build
- recipes-devtools: contains all Yocto python recipes which are needed for all the supported integrations.
- recipes-multimedia: contains a backported older version of ffmpeg. Current master support version 7 but HomeAssistant does not yet.
- scripts: convenience scripts for easier upgrades between versions.

# Testing
Ptest support is provided for homeassistant and all currently supported integrations. The list can be seen in `integrations-test.inc`.
Homeassistant is tested with qemux86-64 architecture to see if all ptest pass before upgrading versions.

# Contributing

Please submit any patches against the homeassistant as Pull Requests on Github.

## Maintainers

* Pascal Bach <pascal.bach@nextrem.ch>
* Tom Geelen <t.f.g.geelen@gmail.com>
* Tim "moto-timo" Orling <ticotimo@gmail.com>
