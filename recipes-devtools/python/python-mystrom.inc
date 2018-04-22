SUMMARY = "Python API for controlling myStrom switches"
HOMEPAGE = "https://github.com/fabaff/python-mystrom"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=49e8fdaa77e7ae68f6d97c5b18de09a9"

PYPI_PACKAGE = "python-mystrom"

inherit pypi

SRC_URI[md5sum] = "316c2cfea3bd5c58ca2f8f90bba147bc"
SRC_URI[sha256sum] = "b0092dc013d6bef9fb1711268d2928254305453007590dba1eba454e854b21a1"

RDEPENDS_${PN} = "${PYTHON_PN}-requests"

BBCLASSEXTEND = "native"
