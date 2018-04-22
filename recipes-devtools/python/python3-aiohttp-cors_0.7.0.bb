SUMMARY = "CORS support for aiohttp"
HOMEPAGE = "https://github.com/aio-libs/aiohttp-cors"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=74e00c8896f59680382a263042282781"

inherit pypi setuptools3

SRC_URI[md5sum] = "de3940a901b269be82c8bd9f28d53ff0"
SRC_URI[sha256sum] = "4d39c6d7100fd9764ed1caf8cebf0eb01bf5e3f24e2e073fda6234bc48b19f5d"

RDEPENDS_${PN} = "\
    ${PYTHON_PN}-aiohttp \
    ${PYTHON_PN}-typing \
    "
