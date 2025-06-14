SUMMARY = "A library which communicates with Deconz radios for zigpy"
HOMEPAGE = "https://github.com/zigpy/zigpy-deconz"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS += "\
    python3-setuptools-git-versioning-native \
"

SRC_URI += "file://0001-Allow-setuptools-git-versioning-3.patch"
SRC_URI[sha256sum] = "0572cb30b417c3014b7abab61d0cb776f7db759a86acb851c23cf7dccf5503fb"

inherit pypi python_setuptools_build_meta ptest-python-pytest

PYPI_PACKAGE = "zigpy_deconz"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"

RDEPENDS:${PN} = "\
    python3-voluptuous \
    python3-zigpy (>=0.70.0) \
"
