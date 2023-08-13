SUMMARY = "Secure Tarfile library"
HOMEPAGE = "https://github.com/pvizeli/securetar"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI[md5sum] = "deaaea9b4dfab58de42e84eb3cbd76e4"
SRC_URI[sha256sum] = "dba5275229a5e3c2bf71101e6ac083606408ba4705b5fd54b41b4b15a879016c"

inherit pypi setuptools3

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-cryptography \
"
