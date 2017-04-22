This README file contains information on the contents of the
homeassistant layer. It contains recipes to run https://home-assistant.io/
on a OE target.

Please see the corresponding sections below for details.


Dependencies
============

This layer depends on:

- [bitbake (master)](https://github.com/openembedded/bitbake)
- [openembedded-core (master)](https://github.com/openembedded/openembedded-core)
- [meta-oe (master)](https://github.com/openembedded/meta-openembedded/tree/master/meta-oe)
- [meta-python (master)](https://github.com/openembedded/meta-openembedded/tree/master/meta-python)
- [meta-security (master)](http://git.yoctoproject.org/cgit/cgit.cgi/meta-security)

Contributing
============

Please submit any patches against the homeassistant as Pull Requests on Github.


Table of Contents
=================

  I. Adding the homeassistant layer to your build

I. Adding the homeassistant layer to your build
=================================================

In order to use this layer, you need to make the build system aware of
it.

Assuming the homeassistant layer exists at the top-level of your
yocto build tree, you can add it to the build system by adding the
location of the homeassistant layer to bblayers.conf, along with any
other layers needed. e.g.:

```
BBLAYERS ?= " \
  /path/to/yocto/meta \
  /path/to/yocto/meta-poky \
  /path/to/yocto/meta-yocto-bsp \
  /path/to/yocto//meta-openembedded/meta-oe \
  /path/to/yocto/meta-openembedded/meta-python \
  /path/to/yocto/meta-security \
  /path/to/yocto/meta-homeassistant \
"
 ```
