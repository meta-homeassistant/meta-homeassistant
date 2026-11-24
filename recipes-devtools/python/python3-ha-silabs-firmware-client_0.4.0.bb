SUMMARY = "Home Assistant client for firmwares released with `silabs-firmware-builder`"
HOMEPAGE = "https://github.com/home-assistant-libs/ha-silabs-firmware-client"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI = "git://github.com/home-assistant-libs/ha-silabs-firmware-client.git;protocol=https;branch=dev;tag=v${PV} \
           file://0001-relax-build-requirement.patch \
           "
SRCREV = "12e69a7e731a7e649ae1b175cf57f7c165c6af14"

DEPENDS += "\
    python3-setuptools-git-versioning-native \
"

inherit python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} = "\
    python3-aiohttp \
    python3-packaging \
    python3-yarl \
"

RDEPENDS:${PN}-ptest += "\
    python3-pytest-xdist \
    python3-pytest-asyncio \
    python3-aioresponses \
    python3-pytest-timeout \
"

do_install_ptest:append() {
    install ${S}/pyproject.toml ${D}${PTEST_PATH}/
}
