SUMMARY = "A simple interface to GPIO devices with Raspberry Pi"
HOMEPAGE = "https://gpiozero.readthedocs.io/"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.rst;md5=f7edfe7aeac02cb6c394726db07eb41c"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "d4ea1952689ec7e331f9d4ebc9adb15f1d01c2c9dcfabb72e752c9869ab7e97e"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-colorzero"

PYPI_PACKAGE = "gpiozero"
