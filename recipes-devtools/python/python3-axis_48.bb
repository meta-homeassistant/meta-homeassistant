SUMMARY = "Python library enabling easy communication with Axis devices and its metadatastream"
HOMEPAGE = "https://github.com/Kane610/axis"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=78a6a0bb7d76993abedec7510368fb0e"

SRC_URI[sha256sum] = "512ddfdf0e010b7cf45a25b9a3a9be458d3f2ad3dc73e4c8f407ea4f850612d2"

inherit pypi setuptools3

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-async-timeout (>=4.0.2) \
    ${PYTHON_PN}-attrs (>=23.1.0) \
    ${PYTHON_PN}-httpx (>=0.24.0) \
    ${PYTHON_PN}-orjson (>=3.8.10) \
    ${PYTHON_PN}-packaging (>=23.1) \
    ${PYTHON_PN}-xmltodict (=0.13.0) \
"
