SUMMARY = "Home Assistant client for firmwares released with `silabs-firmware-builder`"
HOMEPAGE = "https://github.com/home-assistant-libs/ha-silabs-firmware-client"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI[sha256sum] = "9291d462daab534d1da45e0b114e655d6e28ada00686d67e1c23b19f6583ccb9"

DEPENDS += "\
    python3-setuptools-git-versioning-native \
"

inherit pypi python_setuptools_build_meta ptest-python-pytest

PYPI_PACKAGE = "ha_silabs_firmware_client"
RDEPENDS:${PN} = "\
    python3-aiohttp \
    python3-yarl \
"
