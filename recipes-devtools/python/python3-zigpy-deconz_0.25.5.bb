SUMMARY = "A library which communicates with Deconz radios for zigpy"
HOMEPAGE = "https://github.com/zigpy/zigpy-deconz"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS += "\
    python3-setuptools-git-versioning-native \
"

SRC_URI = "\
    git://github.com/zigpy/zigpy-deconz;protocol=https;tag=${PV};branch=dev \
    file://0001-Allow-setuptools-git-versioning-3.patch \
    file://run-ptest \
"
SRCREV = "d7d73ba0d1019b97490cecfe0fda391370ede7fc"

inherit python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} = "\
    python3-voluptuous \
    python3-zigpy (>=0.80.0) \
"

RDEPENDS:${PN}-ptest:append = " \
    python3-pytest-asyncio \
    python3-pytest-cov \
    python3-pytest-mock \
    python3-pytest-timeout \
"

do_install:append() {
    # Drop host-build artifacts that can be picked up from contaminated source trees.
    rm -rf ${D}${PYTHON_SITEPACKAGES_DIR}/oe-workdir
    rm -rf ${D}${PYTHON_SITEPACKAGES_DIR}/build
}
