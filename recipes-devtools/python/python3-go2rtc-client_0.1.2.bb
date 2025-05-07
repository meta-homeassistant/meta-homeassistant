SUMMARY = "Python client for go2rtc"
HOMEPAGE = "https://pypi.org/project/go2rtc-client"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS = "python3-hatchling-native"
SRC_URI[sha256sum] = "07cb27bb0252749effe43dbb791caea8ec12df97fee6cff5501544fe163e52cd"

inherit pypi python_hatchling

RDEPENDS:${PN} += "\
    python3-aiohttp (>= 3.10) \
    python3-awesomeversion (>=24.6) \
    python3-mashumaro (>=3.13) \
    python3-orjson (>=3.10) \
    python3-webrtc-models (>=0.1) \
"

PYPI_PACKAGE = "go2rtc_client"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
