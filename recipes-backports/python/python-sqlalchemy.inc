DESCRIPTION = "Python SQL toolkit and Object Relational Mapper that gives \
application developers the full power and flexibility of SQL"
HOMEPAGE = "http://www.sqlalchemy.org/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b1c412c9d8d1ce018f7a9374407c22bb"

PYPI_PACKAGE = "SQLAlchemy"
inherit pypi

SRC_URI[md5sum] = "43afa81d0c78e367c7d0aa79d2f9a48e"
SRC_URI[sha256sum] = "249000654107a420a40200f1e0b555a79dfd4eff235b2ff60bc77714bd045f2d"

RDEPENDS_${PN} += " \
    ${PYTHON_PN}-json \
    ${PYTHON_PN}-pickle \
    ${PYTHON_PN}-logging \
    ${PYTHON_PN}-netclient \
    ${PYTHON_PN}-numbers \
    ${PYTHON_PN}-threading \
"
