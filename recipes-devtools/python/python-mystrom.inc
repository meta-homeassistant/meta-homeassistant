SUMMARY = "Python API for controlling myStrom switches"
HOMEPAGE = "https://github.com/fabaff/python-mystrom"
LICENSE = "MIT"
#TODO: https://github.com/fabaff/python-mystrom/issues/2
LIC_FILES_CHKSUM = "file://README.rst;md5=254d894e37d4cbfaa096f27fbffe3382"

PYPI_PACKAGE = "python-mystrom"

inherit pypi

SRC_URI[md5sum] = "b02039068f4c4b5c2ba29201aadbb941"
SRC_URI[sha256sum] = "01b732d222779a0f39e45720d4e757143952979c5a2d71ce00ed3bf72a8ec32d"

RDEPENDS_${PN} = "${PYTHON_PN}-requests"

BBCLASSEXTEND = "native"
