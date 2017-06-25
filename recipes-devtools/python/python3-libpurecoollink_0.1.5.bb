SUMMARY = "Dyson Pure Cool Link Python library"
HOMEPAGE = "https://github.com/CharlesBlonde/libpurecoollink"
LICENSE = "Apache-2.0"
# TODO: https://github.com/CharlesBlonde/libpurecoollink/pull/6
#LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=60dd5a575c9bd4339411bdef4a702d46"
LIC_FILES_CHKSUM = "file://setup.cfg;md5=a1fa213182cb16d950a6c9963c23ab02"

inherit pypi setuptools3

SRC_URI[md5sum] = "0fdb43f39ccac68d9e1894faf49ddbd7"
SRC_URI[sha256sum] = "7b6dbecc4e1f40d98ec0f48dbfe8822be4c2bd88232bc9b4f6ce0379d60211dc"

RDEPENDS_${PN} = "${PYTHON_PN}-six ${PYTHON_PN}-requests ${PYTHON_PN}-pycryptodome ${PYTHON_PN}-paho-mqtt ${PYTHON_PN}-netifaces ${PYTHON_PN}-enum"
