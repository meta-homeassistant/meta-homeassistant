SUMMARY = "Library for Python 3 to communicate with the Google Chromecast."
HOMEPAGE = "https://github.com/balloob/pychromecast"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://LICENSE;md5=b1dbd4e85f47b389bdadee9c694669f5"

inherit pypi setuptools3

PYPI_PACKAGE = "PyChromecast"

SRC_URI[md5sum] = "7917ad35945b387b05a71ff090fe2078"
SRC_URI[sha256sum] = "ccf010cc26d95984f361af61c2f8fcaeb4769638ce6a4bced7647eb49cd6e1b2"

RDEPENDS_${PN} = "\
    ${PYTHON_PN}-requests \
    ${PYTHON_PN}-protobuf \
    ${PYTHON_PN}-zeroconf \
    "
