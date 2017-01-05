SUMMARY = "CORS support for aiohttp"
HOMEPAGE = "https://github.com/aio-libs/aiohttp-cors"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fa818a259cbed7ce8bc2a22d35a464fc"

inherit pypi setuptools3

SRC_URI[md5sum] = "caff8d42d939802ba299c46876617b7e"
SRC_URI[sha256sum] = "6f8c132184ee55babaa329a32fe5bb3a8ab8f7fb947e4010f33cce9a80e548af"

RDEPENDS_${PN} = "${PYTHON_PN}-aiohttp ${PYTHON_PN}-typing"
