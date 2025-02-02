SUMMARY = "Python module to talk to Atag One."
HOMEPAGE = "https://github.com/MatsNl/pyatag"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=8227180126797a0148f94f483f3e1489"

SRC_URI[sha256sum] = "c6676aee47e6005ddbab31a36568ee988dc438a6383b02a7e274aaae751b08b2"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-aiohttp"

PYPI_PACKAGE = "pyatag"
