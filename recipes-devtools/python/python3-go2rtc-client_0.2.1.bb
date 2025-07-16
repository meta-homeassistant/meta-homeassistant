SUMMARY = "Python client for go2rtc"
HOMEPAGE = "https://pypi.org/project/go2rtc-client"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS = "python3-hatchling-native"
SRC_URI[sha256sum] = "9b60e22a0f554c39f30b92b4abaf68efe41e6942aa2f25900efae7798c9747a8"

inherit pypi python_hatchling

PYPI_PACKAGE = "go2rtc_client"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
RDEPENDS:${PN} = "\
    python3-aiohttp \
    python3-awesomeversion \
    python3-mashumaro \
    python3-orjson \
    python3-webrtc-models \
"
