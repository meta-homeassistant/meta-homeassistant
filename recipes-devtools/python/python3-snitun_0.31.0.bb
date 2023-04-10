DESCRIPTION = "End-to-End encryption with SNI proxy on top of a TCP multiplexer."
HOMEPAGE = "https://github.com/NabuCasa/snitun"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://setup.py;md5=96b7c7e0fb5503d60706b7b4c9fefa1d"

inherit pypi setuptools3

SRC_URI[md5sum] = "c2887e48167789be1a165cdb3e3c0ef7"
SRC_URI[sha256sum] = "d3ba49bcc69307ea38e9c5645d77df15f644795e6e2f3c2833087a4e9d0576e9"

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-attrs (>=18.2.0) \
    ${PYTHON_PN}-async-timeout (>=3.0.1) \
    ${PYTHON_PN}-cryptography (>=2.5) \
"
