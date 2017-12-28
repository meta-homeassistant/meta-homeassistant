SUMMARY = "CORS support for aiohttp"
HOMEPAGE = "https://github.com/aio-libs/aiohttp-cors"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fa818a259cbed7ce8bc2a22d35a464fc"

inherit pypi setuptools3

SRC_URI[md5sum] = "1a48a916a2d99358816347584506401c"
SRC_URI[sha256sum] = "a44d59cb27a9e53377f6d49cfbd486de1aa071df653652e2a58135c01b5915e4"

RDEPENDS_${PN} = "${PYTHON_PN}-aiohttp ${PYTHON_PN}-typing"
