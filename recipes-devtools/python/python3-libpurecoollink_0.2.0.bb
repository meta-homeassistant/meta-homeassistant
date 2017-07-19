SUMMARY = "Dyson Pure Cool Link Python library"
HOMEPAGE = "https://github.com/CharlesBlonde/libpurecoollink"
LICENSE = "Apache-2.0"
# TODO: https://github.com/CharlesBlonde/libpurecoollink/pull/6
#LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=60dd5a575c9bd4339411bdef4a702d46"
LIC_FILES_CHKSUM = "file://setup.cfg;md5=982f729a2f55046a01fee84d3148cf47"

inherit pypi setuptools3

SRC_URI[md5sum] = "265d0caeb34fe5f459381a9ca3134142"
SRC_URI[sha256sum] = "9c94174e0a81c5770b3bd7e48c8c9e61ae5527112ac331da60bbb5b56f527ebb"

RDEPENDS_${PN} = "${PYTHON_PN}-six ${PYTHON_PN}-requests ${PYTHON_PN}-pycryptodome ${PYTHON_PN}-paho-mqtt ${PYTHON_PN}-netifaces ${PYTHON_PN}-enum"
