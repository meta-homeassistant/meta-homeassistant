DESCRIPTION = "Python SQL toolkit and Object Relational Mapper that gives \
application developers the full power and flexibility of SQL"
HOMEPAGE = "http://www.sqlalchemy.org/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c19467890539ff718c00a019c9c7a7b2"

PYPI_PACKAGE = "SQLAlchemy"
inherit pypi

SRC_URI[md5sum] = "c869817feddc7b0d3ae9ed23cf86997d"
SRC_URI[sha256sum] = "c4cca4aed606297afbe90d4306b49ad3a4cd36feb3f87e4bfd655c57fd9ef445"

RDEPENDS:${PN} += " \
    ${PYTHON_PN}-json \
    ${PYTHON_PN}-pickle \
    ${PYTHON_PN}-logging \
    ${PYTHON_PN}-netclient \
    ${PYTHON_PN}-numbers \
    ${PYTHON_PN}-threading \
"
