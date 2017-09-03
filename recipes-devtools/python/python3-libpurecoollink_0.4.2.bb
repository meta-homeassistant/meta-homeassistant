SUMMARY = "Dyson Pure Cool Link Python library"
HOMEPAGE = "https://github.com/CharlesBlonde/libpurecoollink"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=9afd1fcb3dd05c78de711d961100555d"

inherit pypi setuptools3

SRC_URI[md5sum] = "d0fb2374b1d694b71031beff9df2db6c"
SRC_URI[sha256sum] = "5c455bbfc9a56c6003ddc93b4ce70364e2534f10dc2aa89bf8fc2ddd27d8d0c5"

RDEPENDS_${PN} = "${PYTHON_PN}-six ${PYTHON_PN}-requests ${PYTHON_PN}-pycryptodome ${PYTHON_PN}-paho-mqtt ${PYTHON_PN}-netifaces ${PYTHON_PN}-enum"
