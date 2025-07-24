SUMMARY = "Library to read data from BeeWi SmartClim sensor using Bluetooth LE"
HOMEPAGE = "https://github.com/alemuro/beewi_smartclim"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=8227180126797a0148f94f483f3e1489"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "d677e9e0b6f8ab80da8971f3514c9de4d5301fb13b420adeabd5397cc5f54bad"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    bluepy \
    python3-btlewrap (>=0.0.8) \
"

PYPI_PACKAGE = "beewi_smartclim"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
