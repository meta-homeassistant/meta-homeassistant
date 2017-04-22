SUMMARY = "CORS support for aiohttp"
HOMEPAGE = "https://github.com/aio-libs/aiohttp-cors"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fa818a259cbed7ce8bc2a22d35a464fc"

inherit pypi setuptools3

SRC_URI[md5sum] = "346f1f94c8b3e2b6182d5d5dcf327ae0"
SRC_URI[sha256sum] = "34a9b294764b1a65dd5dad27fadbec7a8f0d334ea7285a2831fe620a22411436"

RDEPENDS_${PN} = "${PYTHON_PN}-aiohttp ${PYTHON_PN}-typing"
