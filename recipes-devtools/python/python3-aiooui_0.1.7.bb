SUMMARY = "Async OUI lookups"
HOMEPAGE = "https://github.com/bluetooth-devices/aiooui"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c8ea148e26a1546c1b0a99524d4da3f7"

DEPENDS = "\
    python3-requests-native \
    python3-charset-normalizer-native \
"

SRC_URI[sha256sum] = "b390c9e602de1faecf3c1f0b98270a95e2d00a4da208a62d507a9635ab8a5d05"

inherit pypi python_poetry_core

RDEPENDS:${PN} = "\
    python3-core (>3.9) \
"

RDEPENDS:${PN}-dev = "\
    python3-requests (>=2.31.0) \
"

