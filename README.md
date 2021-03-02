This README file contains information on the contents of the
homeassistant layer. It contains recipes to run https://home-assistant.io/
on a OE target.

If you need help or like to discuss a topic please join the [`#meta-homeassistant:matrix.org`](https://matrix.to/#/#meta-homeassistant:matrix.org) room on [matrix.org](https://matrix.org/).


Please see the corresponding sections below for details.

# Quickstart

```sh

git clone https://github.com/openembedded/openembedded-core.git
cd openembedded-core
git clone https://github.com/openembedded/meta-openembedded.git
git clone https://git.ostc-eu.org/OSTC/OHOS/meta-python-dunfellplus.git
git clone https://github.com/openembedded/bitbake.git
git clone https://git.yoctoproject.org/git/meta-security
git clone https://github.com/meta-homeassistant/meta-homeassistant.git

. ./oe-init-build-env

bitbake-layers add-layer ../meta-openembedded/meta-oe
bitbake-layers add-layer ../meta-openembedded/meta-python
bitbake-layers add-layer ../meta-openembedded/meta-networking
bitbake-layers add-layer ../meta-openembedded/meta-perl
bitbake-layers add-layer ../meta-python-dunfellplus
bitbake-layers add-layer ../meta-security
bitbake-layers add-layer ../meta-homeassistant

bitbake core-image-homeassistant

runqemu qemux86 nographic

```

You should now be able to access Home Assistant via web browser usually under the address: http://192.168.7.2:8123

# Dependencies

```
URI: https://github.com/openembedded/openembedded-core.git
branch: dunfell
revision: HEAD

URI: git://github.com/openembedded/meta-openembedded.git
branch: dunfell
revision: HEAD

URI: https://git.ostc-eu.org/OSTC/OHOS/meta-python-dunfellplus.git
branch: dunfell
revision: HEAD

URI: https://github.com/openembedded/bitbake.git
branch: 1.46
revision: HEAD

URI: https://git.yoctoproject.org/git/meta-security
branch: dunfell
revision: HEAD

```

Why are these needed?

- [meta-oe (dunfell)](https://github.com/openembedded/meta-openembedded/tree/dunfell/meta-oe) : contains meta-python
- [meta-python (dunfell)](https://github.com/openembedded/meta-openembedded/tree/dunfell/meta-python) : contains many of the required python3 packages
- [meta-python-dunfellplus (dunfell)](https://git.ostc-eu.org/OSTC/OHOS/meta-python-dunfellplus/-/tree/dunfell) : contains meta-python backported recipe versions for dunfell
- [meta-security (dunfell)](http://git.yoctoproject.org/cgit/cgit.cgi/meta-security/log/?h=dunfell): required for nmap used for presence detection

# Build configuration

Home Assistant requires specific versions of some of its python dependencies. The recipe makes sure those dependencies are satisfied at root filesystem generation time but that doesn't give any gurantees that `bitbake` will pick a version that satisfies the version restriction in `RDEPENDS`. In order for the build to select the right versions, your distro file should include the version selection in `conf/distro/include/ha-versions.inc` when you are building `python3-homeassistant`. A sample distro (that can also be used as such, is provided - see `homeassistant.conf`).

# Contributing

Please submit any patches against the homeassistant as Pull Requests on Github.

## Maintainers

* Pascal Bach <pascal.bach@nextrem.ch>
