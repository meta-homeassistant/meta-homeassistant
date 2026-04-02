SUMMARY = "Library implementing Zigpy quirks for ZHA in Home Assistant"
HOMEPAGE = "https://github.com/zigpy/zha-device-handlers"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS += "\
    python3-setuptools-git-versioning-native \
"

SRC_URI = "\
    git://github.com/zigpy/zha-device-handlers;protocol=https;tag=${PV};branch=dev \
    file://0001-Allow-setuptools-git-versioning-3.patch \
    file://run-ptest \
"
SRCREV = "2e721867bf69e0b9967252d43bf29dc725c32058"

inherit python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-zigpy (>=1.2.1) \
"

RDEPENDS:${PN}-ptest += "\
    python3-pytest-xdist \
    python3-codecov \
    python3-pytest-asyncio \
    python3-pytest-cov \
    python3-pytest-sugar \
    python3-pytest-timeout \
    python3-time-machine \
    python3-zoneinfo \
    python3-tzdata \
"

do_install:append() {
    # Drop host-build artifacts that can be picked up from contaminated source trees.
    rm -rf ${D}${PYTHON_SITEPACKAGES_DIR}/oe-workdir
    rm -rf ${D}${PYTHON_SITEPACKAGES_DIR}/build
}
