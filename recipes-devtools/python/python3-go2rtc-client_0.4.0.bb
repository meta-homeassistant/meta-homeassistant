SUMMARY = "Python client for go2rtc"
HOMEPAGE = "https://pypi.org/project/go2rtc-client"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS = "python3-hatchling-native"
SRC_URI[sha256sum] = "9eff2630f8c9953a56d1aa8eb1eceb71d60c61c631aaadc3f8dc122831217858"

inherit pypi python_hatchling

PYPI_PACKAGE = "go2rtc_client"
RDEPENDS:${PN} = "\
    python3-aiohttp \
    python3-awesomeversion \
    python3-mashumaro \
    python3-orjson \
    python3-webrtc-models \
"
