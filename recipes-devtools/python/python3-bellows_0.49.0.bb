SUMMARY = "Library implementing EZSP"
HOMEPAGE = "https://github.com/zigpy/bellows"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS += "\
    python3-setuptools-git-versioning-native \
"

SRC_URI = "git://github.com/zigpy/bellows.git;protocol=https;branch=dev \
           file://0001-Relax-gitversioning-version.patch \
           file://run-ptest \
"
SRCREV = "0d5b1b7be8c62595f7af607878d448954168177e"

inherit python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} = "\
    python3-click \
    python3-click-log (>=0.2.1) \
    python3-voluptuous \
    python3-zigpy (>=0.87.0) \
"

RDEPENDS:${PN}-ptest += "\
    python3-pytest-asyncio \
    python3-pytest-timeout \
    python3-pytest-mock \
    python3-pytest-cov \
    python3-statistics \
"

do_install:append() {
    # Drop host-build artifacts that can be picked up from contaminated source trees.
    rm -rf ${D}${PYTHON_SITEPACKAGES_DIR}/oe-workdir
    rm -rf ${D}${PYTHON_SITEPACKAGES_DIR}/build
}
