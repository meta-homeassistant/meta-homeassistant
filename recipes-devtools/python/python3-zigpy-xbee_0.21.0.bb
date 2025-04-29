SUMMARY = "A library which communicates with XBee radios for zigpy"
HOMEPAGE = "https://github.com/zigpy/zigpy-xbee"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS += "\
    python3-setuptools-git-versioning-native \
"

SRC_URI += "file://0001-Allow-setuptools-git-versioning-3.patch"
SRC_URI[sha256sum] = "63f9f06e864f58fd4b2c6c0b0ef00b126e6711faf6ccba4ec9c610f0f51c8d3e"

inherit pypi python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} += "python3-zigpy (>=0.70.0)"

PYPI_PACKAGE = "zigpy_xbee"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
