SUMMARY = "Asynchronous Python client for Internet Printing Protocol (IPP)"
HOMEPAGE = "https://github.com/ctalkington/python-ipp"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4a8a03ceb18c4f191643ef270d79452c"

SRC_URI[sha256sum] = "a9f3768a45bb1c27b9b83112bd2f55a1a4e4b9e46c8a2fb85c4d986cd634d493"

inherit pypi python_setuptools_build_meta python_poetry_core

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-aiohttp (>=3.0.0) \
    ${PYTHON_PN}-awesomeversion (>=21.10.1) \
    ${PYTHON_PN}-backoff (>=2.2.0) \
    ${PYTHON_PN}-deepmerge (>=1.1.0) \
    ${PYTHON_PN}-yarl (>=1.6.0) \
"
