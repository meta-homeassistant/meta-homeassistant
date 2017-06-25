SUMMARY = "Python API for controlling myStrom switches"
HOMEPAGE = "https://github.com/fabaff/python-mystrom"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ed8f2e90fdcc8cce3efb5a58f9e6b07a"

PYPI_PACKAGE = "python-mystrom"

inherit pypi

SRC_URI[md5sum] = "6f410ce01874bce31c9a3a319c4f0350"
SRC_URI[sha256sum] = "db2aa526a7eed2c3a7e9d14b98e0f0bdc2f4c020efb489e36bac2ec2009c9281"

RDEPENDS_${PN} = "${PYTHON_PN}-requests"

BBCLASSEXTEND = "native"
