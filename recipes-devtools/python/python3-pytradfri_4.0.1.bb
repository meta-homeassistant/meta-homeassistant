SUMMARY = "A python library for communicating with the Tradfri Gateway"
HOMEPAGE = "https://github.com/ggravlingen/pytradfri"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=37ea2250f00b424609d55b35f829c514"

inherit pypi setuptools3

SRC_URI[md5sum] = "afe5fbf29fb0c87bd5963dec3b2cd907"
SRC_URI[sha256sum] = "3f4e51f5738ee7e76cc083c0a0cbb9e97f6f0da65ebfd9864d315c68be9aea9b"

RDEPENDS_${PN} = "${PYTHON_PN}-aiocoap ${PYTHON_PN}-dtlssocket"
