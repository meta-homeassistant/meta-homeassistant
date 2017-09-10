SUMMARY = "A python library for communicating with the Tradfri Gateway"
HOMEPAGE = "https://github.com/ggravlingen/pytradfri"
LICENSE = "MIT"
# TODO: https://github.com/ggravlingen/pytradfri/pull/55
LIC_FILES_CHKSUM = "file://setup.py;md5=2a991dea64aea0c26c3caccf51a3dedf"

inherit pypi setuptools3

SRC_URI[md5sum] = "0cc9176671193a509a3b1139ee10bf1b"
SRC_URI[sha256sum] = "1eed2fda19acdf8a7a9a112eedff117035d1863d0afa354ce3a15ea913cc366b"

RDEPENDS_${PN} = "${PYTHON_PN}-aiocoap"
