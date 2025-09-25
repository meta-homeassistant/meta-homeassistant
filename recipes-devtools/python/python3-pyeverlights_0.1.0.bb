SUMMARY = "A library for controlling an EverLights lighting system."
HOMEPAGE = "https://github.com/joncar/pyeverlights"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=8227180126797a0148f94f483f3e1489"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "f25b410abd9554f5be818a924b3fe9d99276481b78900ebf4a7f20e2d6eb0c76"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-aiohttp"

PYPI_PACKAGE = "pyeverlights"
