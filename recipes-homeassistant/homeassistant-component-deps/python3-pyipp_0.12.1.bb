SUMMARY = "Asynchronous Python client for Internet Printing Protocol (IPP)"
HOMEPAGE = "https://github.com/ctalkington/python-ipp"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4a8a03ceb18c4f191643ef270d79452c"

SRC_URI[md5sum] = "abaa5b970532078db748bce33905d937"
SRC_URI[sha256sum] = "5ce398120431f54ea90ece721a7849b93a82dc67dc19cf1f0e374e7ebda5726d"

inherit pypi python_setuptools_build_meta python_poetry_core

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-aiohttp (>=3.0.5) \
    ${PYTHON_PN}-awesomeversion (>=21.10.1) \
    ${PYTHON_PN}-backoff (>=1.9.0) \
    ${PYTHON_PN}-deepmerge (>=0.1.0) \
    ${PYTHON_PN}-yarl (>=1.6.0) \
"
