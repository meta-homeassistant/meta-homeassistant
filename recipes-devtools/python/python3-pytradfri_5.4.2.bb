SUMMARY = "A python library for communicating with the Tradfri Gateway"
HOMEPAGE = "https://github.com/ggravlingen/pytradfri"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=37ea2250f00b424609d55b35f829c514"

inherit pypi setuptools3

SRC_URI[md5sum] = "7a56ad41bfcb906802746236036bfdee"
SRC_URI[sha256sum] = "881a35cb767bb9ea3fff2f13c0e97335895169e6529a9218178e4b9600461724"

RDEPENDS_${PN} = "\
    ${PYTHON_PN}-aiocoap \
    ${PYTHON_PN}-dtlssocket \
    "
