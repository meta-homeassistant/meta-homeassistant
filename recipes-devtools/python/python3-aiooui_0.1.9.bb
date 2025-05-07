SUMMARY = "Async OUI lookups"
HOMEPAGE = "https://github.com/bluetooth-devices/aiooui"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c8ea148e26a1546c1b0a99524d4da3f7"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS = "\
    python3-aiohttp-native \
    python3-requests-native \
    python3-charset-normalizer-native \
"

SRC_URI[sha256sum] = "e8c8bc59ab352419e0747628b4cce7c4e04d492574c1971e223401126389c5d8"

inherit pypi python_poetry_core

RDEPENDS:${PN} = "\
    python3-core (>3.9) \
"

RDEPENDS:${PN}-dev = "\
    python3-requests (>=2.31.0) \
"

