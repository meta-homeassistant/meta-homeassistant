SUMMARY = "Library for Python 3 to communicate with the Google Chromecast."
HOMEPAGE = "https://github.com/balloob/pychromecast"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://LICENSE;md5=b1dbd4e85f47b389bdadee9c694669f5"

inherit pypi setuptools3

PYPI_PACKAGE = "PyChromecast"

SRC_URI[md5sum] = "59d2c6d258b653941d4dc978bed22847"
SRC_URI[sha256sum] = "a18fee9bf32f62fcb539783c3888e811015c1f6377bcdb383b13d6537691f336"

RDEPENDS_${PN} = "\
    ${PYTHON_PN}-requests \
    ${PYTHON_PN}-protobuf \
    ${PYTHON_PN}-zeroconf \
    "
