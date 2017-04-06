SUMMARY = "MQTT client/brocker using Python 3.4 asyncio library"
HOMEPAGE = "https://github.com/beerfactory/hbmqtt"
LICENSE = "MIT"
#TODO: https://github.com/beerfactory/hbmqtt/pull/69
#LIC_FILES_CHKSUM = "file://license.txt;md5=d4ae7def6b740abc020a2700493fef4e"
LIC_FILES_CHKSUM = "file://setup.py;md5=59fc297648b917a8930fb2f9813823f5"

inherit pypi setuptools3

SRC_URI[md5sum] = "8536de4bffcfc49492c19b4f9701592d"
SRC_URI[sha256sum] = "ef341b64c653b62fe5a93747363a97b90e1b97dd9a8968f80349fb40971fe8d4"

RDEPENDS_${PN} = "${PYTHON_PN}-transitions ${PYTHON_PN}-websockets ${PYTHON_PN}-passlib ${PYTHON_PN}-docopt ${PYTHON_PN}-pyyaml"
