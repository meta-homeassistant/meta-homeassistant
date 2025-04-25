SUMMARY = "Python WebRTC models"
HOMEPAGE = "https://github.com/home-assistant-libs/python-webrtc-models"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS = "python3-hatchling-native"
SRC_URI[sha256sum] = "559c743e5cc3bcc8133be1b6fb5e8492a9ddb17151129c21cbb2e3f2a1166526"

inherit pypi python_hatchling

PYPI_PACKAGE = "webrtc_models"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"

RDEPENDS:${PN} = "\
    python3-mashumaro (>=3.13) \
    python3-orjson (>=3.10.7) \
"
