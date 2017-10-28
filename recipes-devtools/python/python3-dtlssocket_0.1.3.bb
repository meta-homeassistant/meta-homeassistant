SUMMARY = "DTLSSocket is a cython wrapper for tinydtls with a Socket like interface"
HOMEPAGE = "https://git.fslab.de/jkonra2m/tinydtls-cython"
LICENSE = "EPL-1.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=0f496e8f7ed80c27693661195ebd8526"

inherit pypi setuptools3

PYPI_PACKAGE = "DTLSSocket"

DEPENDS += "${PYTHON_PN}-cython-native"

SRC_URI[md5sum] = "3f38a270ca4ade57f18e3030b209a7de"
SRC_URI[sha256sum] = "67ecaf76a5a816a3dbf9be167cfedaa9f8c9c2b8df30421410f088b4ce12d9f0"
