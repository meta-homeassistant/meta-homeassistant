SUMMARY = "A library which communicates with Deconz radios for zigpy"
HOMEPAGE = "https://github.com/zigpy/zigpy-deconz"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS += "\
    python3-setuptools-git-versioning-native \
"

SRC_URI += "file://0001-Allow-setuptools-git-versioning-3.patch"
SRC_URI[sha256sum] = "62430668a0ffb8ea54f1c748294ecfb662561681380db58aabaacb736580611d"

inherit pypi python_setuptools_build_meta ptest-python-pytest

PYPI_PACKAGE = "zigpy_deconz"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"

RDEPENDS:${PN} = "\
    python3-voluptuous \
    python3-zigpy (>=0.70.0) \
"
