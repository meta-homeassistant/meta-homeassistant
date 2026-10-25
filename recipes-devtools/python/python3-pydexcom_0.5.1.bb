SUMMARY = "Python API to interact with Dexcom Share API"
HOMEPAGE = "https://gagebenne.github.io/pydexcom"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8853e403bf86aa829627e9e4a780ebb4"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "1789408929547d8cb48a53369cc0f1b25f0377e5770e9eb2f4e7c249d8325d2e"

DEPENDS = "python3-hatch-vcs-native"

inherit pypi python_hatchling ptest-python-pytest

RDEPENDS:${PN} = "python3-requests (>=2.0)"

RDEPENDS:${PN}-ptest += "python3-vcrpy"
