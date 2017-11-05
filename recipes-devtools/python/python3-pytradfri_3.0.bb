SUMMARY = "A python library for communicating with the Tradfri Gateway"
HOMEPAGE = "https://github.com/ggravlingen/pytradfri"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fd83cbb7e60f5c6409bd4598fdb339dd"

inherit pypi setuptools3

SRC_URI[md5sum] = "92105ae41ea043ee3ba62877a6a19f41"
SRC_URI[sha256sum] = "0b0afb6199d7788dc0a45dff7c9f54309edc1367bb6ad32d99c623d8eeadc692"

RDEPENDS_${PN} = "${PYTHON_PN}-aiocoap ${PYTHON_PN}-dtlssocket"
