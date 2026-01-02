SUMMARY = "Python client for go2rtc"
HOMEPAGE = "https://pypi.org/project/go2rtc-client"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS = "python3-hatchling-native"
SRC_URI[sha256sum] = "6609c7081b9858cc8cefeffb2202c48536904afed80240ed13e913cc03882a95"

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
