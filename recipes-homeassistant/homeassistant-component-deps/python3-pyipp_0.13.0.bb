SUMMARY = "Asynchronous Python client for Internet Printing Protocol (IPP)"
HOMEPAGE = "https://github.com/ctalkington/python-ipp"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4a8a03ceb18c4f191643ef270d79452c"

SRC_URI[sha256sum] = "f24200633cbfc4152d6c6721f7b625d41fb58ef65311992cb74a07acea6a457e"

inherit pypi python_setuptools_build_meta python_poetry_core

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-aiohttp (>=3.0.0) \
    ${PYTHON_PN}-awesomeversion (>=21.10.1) \
    ${PYTHON_PN}-backoff (>=2.2.0) \
    ${PYTHON_PN}-deepmerge (>=1.1.0) \
    ${PYTHON_PN}-yarl (>=1.6.0) \
"