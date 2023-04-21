SUMMARY = "Python library enabling easy communication with Axis devices and its metadatastream"
HOMEPAGE = "https://github.com/Kane610/axis"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=78a6a0bb7d76993abedec7510368fb0e"

SRC_URI[md5sum] = "cfd84a277c66d160d376ced9c944bf6f"
SRC_URI[sha256sum] = "a199db122bfac013157de51c7efb50619eff7216122c8a6268d31e26dde25663"

inherit pypi setuptools3

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-async-timeout (=4.0.2) \
    ${PYTHON_PN}-attrs (=22.2.0) \
    ${PYTHON_PN}-httpx (>=0.23.0) \
    ${PYTHON_PN}-orjson (>=3.8.6) \
    ${PYTHON_PN}-packaging (=23.0) \
    ${PYTHON_PN}-xmltodict (=0.13.0) \
"
