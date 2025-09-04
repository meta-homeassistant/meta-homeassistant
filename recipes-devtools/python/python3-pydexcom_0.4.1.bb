SUMMARY = "Python API to interact with Dexcom Share API"
HOMEPAGE = "https://gagebenne.github.io/pydexcom"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8853e403bf86aa829627e9e4a780ebb4"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS = "python3-hatch-vcs-native python3-hatchling-native"
SRC_URI[sha256sum] = "0e308ce4b5370a4e8bbb6a62b6ae881eef11de808d2dae0e163945758d6528b5"

inherit pypi python_hatchling ptest-python-pytest

PYPI_PACKAGE = "pydexcom"
RDEPENDS:${PN} = "python3-requests (>=2.0)"
