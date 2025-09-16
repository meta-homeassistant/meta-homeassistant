SUMMARY = "Asynchronous Python client for DirecTV (SHEF)."
HOMEPAGE = "https://github.com/ctalkington/python-directv"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=10abb65256392e3f6889e706d0f753b2"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "f13f5f8eed587a2c589e581abd5b90f483d9eb7336c8bf20fcecc53c8cd8b501"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-aiohttp (>=3.6.2) \
    python3-yarl (>=1.4.2) \
"

PYPI_PACKAGE = "directv"
