SUMMARY = "Library implementing ZHA for Home Assistant"
HOMEPAGE = "https://github.com/zigpy/zha"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS += "\
    python3-setuptools-git-versioning-native \
"

SRC_URI = "git://github.com/zigpy/zha;protocol=https;tag=${PV};branch=dev \
           file://0001-Repair-test-event-loop.patch \
           "
SRCREV = "c1841332ab590362c6d004de326bbb3cbbe36e19"

inherit python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-zigpy (>=1.1.1) \
    python3-bellows (>=0.49.0) \
    python3-zigpy-znp (>=0.14.3) \
    python3-zigpy-deconz (>=0.25.5) \
    python3-zigpy-xbee (>=0.21.1) \
    python3-zigpy-zigate (>=0.13.4) \
    python3-zha-quirks (>=1.0.1) \
    python3-pyserial (>=3.5) \
    python3-pyserial-asyncio-fast \
    python3-looptime \
    python3-statistics \
    python3-zoneinfo \
    python3-freezegun \
    python3-tzdata \
"

do_install_ptest:append() {
    install ${S}/pyproject.toml ${D}${PTEST_PATH}/
}

do_install:append() {
    # Drop host-build artifacts that can be picked up from contaminated source trees.
    rm -rf ${D}${PYTHON_SITEPACKAGES_DIR}/oe-workdir
    rm -rf ${D}${PYTHON_SITEPACKAGES_DIR}/build
    # Remove conflicting test files
    rm -rf ${D}${libdir}/${PYTHON_DIR}/site-packages/tools/__init__.py
    rm -rf ${D}${libdir}/${PYTHON_DIR}/site-packages/tools/__pycache__/__init__.cpython-314.pyc
}
