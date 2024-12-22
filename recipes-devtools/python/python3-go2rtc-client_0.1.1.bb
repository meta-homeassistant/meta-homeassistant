SUMMARY = "Python client for go2rtc"
HOMEPAGE = "https://pypi.org/project/go2rtc-client"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

DEPENDS = "python3-hatchling-native"
SRC_URI[sha256sum] = "9e18dd1f188b13aed9ef696ac52d1223e33d171dfd4592778d8db4efe8cda155"

inherit pypi python_hatchling

RDEPENDS:${PN} += "\
    python3-aiohttp (>= 3.10) \
    python3-awesomeversion (>=24.6) \
    python3-mashumaro (>=3.13) \
    python3-orjson (>=3.10) \
    python3-webrtc-models (>=0.1) \
"

PYPI_PACKAGE = "go2rtc_client"
