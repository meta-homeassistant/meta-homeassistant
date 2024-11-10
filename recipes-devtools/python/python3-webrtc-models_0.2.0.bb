SUMMARY = "Python WebRTC models"
HOMEPAGE = "https://pypi.org/project/webrtc-models"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

DEPENDS = "python3-hatchling-native"
SRC_URI[sha256sum] = "ec7b1009b14a6a82b05044b58e0e072eea46829b0c81729e2ddd6c822651c7b3"

inherit pypi python_hatchling

PYPI_PACKAGE = "webrtc_models"

RDEPENDS:${PN} = "\
    python3-mashumaro (>=3.13) \
    python3-orjson (>=3.10.7) \
"
