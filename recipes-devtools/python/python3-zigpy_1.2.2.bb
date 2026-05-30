SUMMARY = "Library implementing a Zigbee stack"
HOMEPAGE = "https://github.com/zigpy/zigpy"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS += "\
    python3-setuptools-git-versioning-native \
"

SRC_URI = "git://github.com/zigpy/zigpy;protocol=https;tag=${PV};branch=dev \
           file://run-ptest \
           file://0001-relax-build-requirement.patch \
           "
SRCREV = "7ff64c33ff4f15881b21284a51614bd9f3dca0ee"

inherit python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} = "\
    python3-attrs \
    python3-aiohttp \
    python3-aiosqlite (>=0.20.0) \
    python3-crccheck \
    python3-cryptography \
    python3-voluptuous \
    python3-jsonschema \
    python3-pyserial-asyncio-fast \
    python3-typing-extensions \
    python3-frozendict \
"

RDEPENDS:${PN}-ptest:append = " \
    python3-aioresponses \
    python3-asynctest \
    python3-freezegun \
    python3-pytest-asyncio \
    python3-pytest-cov \
    python3-pytest-timeout \
    python3-tomli \
    python3-zoneinfo \
    python3-tzdata \
    python3-pytest-xdist \
    python3-filelock \
"

do_install:append() {
    # Drop host-build artifacts that can be picked up from contaminated source trees.
    rm -rf ${D}${PYTHON_SITEPACKAGES_DIR}/oe-workdir
    rm -rf ${D}${PYTHON_SITEPACKAGES_DIR}/build
}
