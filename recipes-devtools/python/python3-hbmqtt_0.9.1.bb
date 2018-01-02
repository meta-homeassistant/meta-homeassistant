SUMMARY = "MQTT client/brocker using Python 3.4 asyncio library"
HOMEPAGE = "https://github.com/beerfactory/hbmqtt"
LICENSE = "MIT"
#TODO: https://github.com/beerfactory/hbmqtt/pull/69
#LIC_FILES_CHKSUM = "file://license.txt;md5=d4ae7def6b740abc020a2700493fef4e"
LIC_FILES_CHKSUM = "file://setup.py;md5=6c113380a5838c7a3d48dea9c207ade4"

inherit pypi setuptools3

SRC_URI[md5sum] = "820b3c3d2642f1db0cdd486e5191d7cd"
SRC_URI[sha256sum] = "3d730429f1d6f9fc10ffceea1b516bb38e9c90b97fd30c31672f39823cc39812"

RDEPENDS_${PN} = "${PYTHON_PN}-transitions ${PYTHON_PN}-websockets ${PYTHON_PN}-passlib ${PYTHON_PN}-docopt ${PYTHON_PN}-pyyaml"
