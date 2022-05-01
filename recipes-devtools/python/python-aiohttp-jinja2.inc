SUMMARY = "jinja2 template renderer for aiohttp.web (http server for asyncio)"
HOMEPAGE = "https://github.com/aio-libs/aiohttp_jinja2/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c82758543767c96574b6e29fc478fb73"

inherit pypi

SRC_URI[md5sum] = "d8e0f9e824ab62f3bd17abb604f5884e"
SRC_URI[sha256sum] = "4569ba360dbef2f6e2edfcb1eb34452e85498b7e17740baa5a4adc296ac3973c"

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-jinja2 (>=2.7) \
    ${PYTHON_PN}-aiohttp (>=0.20) \
"

