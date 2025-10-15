SUMMARY = "Python API for accessing information from Samsung FamilyHub fridges locally."
HOMEPAGE = "https://github.com/Klathmon/python-family-hub-local"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=adc1f231c76ee2f1f36025d56926ba2c"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "6db38195427883e1ce7098a1101033de5b0747d1a7d3bcfcb2dd7815115e25b7"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-aiohttp python3-async-timeout python3-pillow"

PYPI_PACKAGE = "python-family-hub-local"
PYPI_PACKAGE_EXT = "zip"
