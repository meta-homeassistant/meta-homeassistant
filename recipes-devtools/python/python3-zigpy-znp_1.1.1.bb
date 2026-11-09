SUMMARY = "A library for zigpy which communicates with TI ZNP radios"
HOMEPAGE = "https://github.com/zigpy/zigpy-znp"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS += "\
    python3-setuptools-git-versioning-native \
"

SRC_URI:append = "\
    file://0001-Allow-setuptools-git-versioning-3.patch \
    file://run-ptest \
"
SRC_URI[sha256sum] = "95edd2eed8432f27d59177d292f8ef56d897c722885b757510ca2cdc1eca9250"

inherit pypi python_setuptools_build_meta ptest-python-pytest


RDEPENDS:${PN} = "\
    python3-zigpy (>=0.91.2) \
    python3-voluptuous \
    python3-coloredlogs \
    python3-jsonschema \
"

RDEPENDS:${PN}-ptest += "\
    python3-pytest-asyncio \
    python3-pytest-timeout \
    python3-pytest-mock \
    python3-pytest-cov \
"

do_install:append() {
    # Drop host-build artifacts that can be picked up from contaminated source trees.
    rm -rf ${D}${PYTHON_SITEPACKAGES_DIR}/oe-workdir
    rm -rf ${D}${PYTHON_SITEPACKAGES_DIR}/build
}
