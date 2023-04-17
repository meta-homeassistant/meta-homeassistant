SUMMARY = "Python library to control Shellyt"
HOMEPAGE = "https://github.com/home-assistant-libs/aioshelly"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=dab31a1d28183826937f4b152143a33f"

SRC_URI[md5sum] = "b46780ad4b077496f74f2907c9f200c5"
SRC_URI[sha256sum] = "b189b80e7748bfe51c2fe840bed39411a9bda3c732237c7ed3665ab0260af648"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-aiohttp \
    ${PYTHON_PN}-bluetooth-data-tools (>=0.3.0) \
    ${PYTHON_PN}-orjson (>=3.8.1) \
"
