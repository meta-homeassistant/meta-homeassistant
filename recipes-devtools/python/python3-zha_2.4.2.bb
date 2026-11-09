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
           file://0001-relax-build-requirement.patch \
           "
SRCREV = "c048c4a82cd0b227778d553fe570aabf1e0fc10e"

inherit python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-zigpy-ziggurat (>=1.2.0) \
    python3-attrs \
    python3-frozendict \
    python3-zigpy (>=2.4.1) \
    python3-bellows (>=1.2.1) \
    python3-zigpy-znp (>=1.1.1) \
    python3-zigpy-deconz (>=1.1.1) \
    python3-zigpy-xbee (>=0.22.0) \
    python3-zigpy-zigate (>=0.14.0) \
    python3-zha-quirks (>=2.4.0) \
    python3-statistics \
    python3-zoneinfo \
    python3-tzdata \
"

# Test-only dependencies (upstream "testing" dependency group)
RDEPENDS:${PN}-ptest += "\
    python3-coloredlogs \
    python3-freezegun \
    python3-looptime \
    python3-pytest-asyncio \
    python3-pytest-timeout \
    python3-python-slugify \
"

do_install_ptest:append() {
    install ${S}/pyproject.toml ${D}${PTEST_PATH}/
}

do_install:append() {
    # Drop host-build artifacts that can be picked up from contaminated source trees.
    rm -rf ${D}${PYTHON_SITEPACKAGES_DIR}/oe-workdir
    rm -rf ${D}${PYTHON_SITEPACKAGES_DIR}/build
    # The wheel also ships the repository's development scripts as a
    # top-level "tools" package. zigpy and zha both do, so their files
    # collide in the rootfs; nothing imports it at runtime.
    # Fixed upstream in 2da1a5b5676158ac7b603ce6b9f42641cb90e7a0 (after 2.4.2);
    # drop this with the next release.
    rm -rf ${D}${PYTHON_SITEPACKAGES_DIR}/tools
}
