SUMMARY = "Python library to control Shelly"
HOMEPAGE = "https://github.com/home-assistant-libs/aioshelly"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=dab31a1d28183826937f4b152143a33f"

SRC_URI[sha256sum] = "d31b07023fc37e365c3a66fafa8d1929232c893482b791aee12f2e9b4b6b32ec"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-aiohttp \
    ${PYTHON_PN}-bluetooth-data-tools (>=0.3.0) \
    ${PYTHON_PN}-orjson (>=3.8.1) \
"
