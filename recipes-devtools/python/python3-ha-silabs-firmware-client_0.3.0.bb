SUMMARY = "Home Assistant client for firmwares released with `silabs-firmware-builder`"
HOMEPAGE = "https://github.com/home-assistant-libs/ha-silabs-firmware-client"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI = "git://github.com/home-assistant-libs/ha-silabs-firmware-client.git;protocol=https;branch=dev"
SRC_URI[sha256sum] = "9291d462daab534d1da45e0b114e655d6e28ada00686d67e1c23b19f6583ccb9"
SRCREV = "aa118e885ecf50709029d8faac8af9ef8ef2dc55"

DEPENDS += "\
    python3-setuptools-git-versioning-native \
"

inherit python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} = "\
    python3-aiohttp \
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
