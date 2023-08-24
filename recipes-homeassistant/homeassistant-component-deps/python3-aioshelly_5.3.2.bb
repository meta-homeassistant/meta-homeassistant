SUMMARY = "Python library to control Shelly"
HOMEPAGE = "https://github.com/home-assistant-libs/aioshelly"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=dab31a1d28183826937f4b152143a33f"

SRC_URI[sha256sum] = "b24f1a340c3fd53dcd84625858a486eaebdd1d7002b3e23eee163a0be9fc36e6"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-aiohttp \
    ${PYTHON_PN}-bluetooth-data-tools (>=0.3.0) \
    ${PYTHON_PN}-orjson (>=3.8.1) \
"
