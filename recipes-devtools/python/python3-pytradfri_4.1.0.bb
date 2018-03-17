SUMMARY = "A python library for communicating with the Tradfri Gateway"
HOMEPAGE = "https://github.com/ggravlingen/pytradfri"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=37ea2250f00b424609d55b35f829c514"

inherit pypi setuptools3

SRC_URI[md5sum] = "fb3bf46123290e700679f3a86b6e4fde"
SRC_URI[sha256sum] = "29b81104c33be3fb499e3f5102bc5839342d08874eac2e0bbadb428ae771083f"

RDEPENDS_${PN} = "\
    ${PYTHON_PN}-aiocoap \
    ${PYTHON_PN}-dtlssocket \
    "
