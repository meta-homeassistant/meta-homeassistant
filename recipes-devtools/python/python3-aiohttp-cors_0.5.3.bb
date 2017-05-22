SUMMARY = "CORS support for aiohttp"
HOMEPAGE = "https://github.com/aio-libs/aiohttp-cors"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fa818a259cbed7ce8bc2a22d35a464fc"

inherit pypi setuptools3

SRC_URI[md5sum] = "0594dd4f5148405a13b5b703325244a9"
SRC_URI[sha256sum] = "368a84e4bcab12f5d8cf7e50d8beb031d6c3902ecc0eb9678c4ef293610d6585"

RDEPENDS_${PN} = "${PYTHON_PN}-aiohttp ${PYTHON_PN}-typing"
