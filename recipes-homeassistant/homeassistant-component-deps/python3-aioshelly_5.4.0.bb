SUMMARY = "Python library to control Shelly"
HOMEPAGE = "https://github.com/home-assistant-libs/aioshelly"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=dab31a1d28183826937f4b152143a33f"

SRC_URI[sha256sum] = "5bb1451a0e7be46a3ad96a40638b51046628c99213e9d8df6e7acd2962b859ac"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-aiohttp \
    ${PYTHON_PN}-bluetooth-data-tools (>=0.3.0) \
    ${PYTHON_PN}-orjson (>=3.8.1) \
"
