DESCRIPTION = "Linux Distribution - a Linux OS platform information API"
HOMEPAGE = "https://github.com/nir0s/distro"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d2794c0df5b907fdace235a619d80314"

inherit pypi

SRC_URI[md5sum] = "f2406d8efdb872c64a79e28967eff71a"
SRC_URI[sha256sum] = "362dde65d846d23baee4b5c058c8586f219b5a54be1cf5fc6ff55c4578392f57"

BBCLASSEXTEND = "native nativesdk"
