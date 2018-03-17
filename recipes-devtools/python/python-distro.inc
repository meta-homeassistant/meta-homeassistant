DESCRIPTION = "Linux Distribution - a Linux OS platform information API"
HOMEPAGE = "https://github.com/nir0s/distro"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d2794c0df5b907fdace235a619d80314"

inherit pypi

SRC_URI[md5sum] = "1454c287f2931418eed41f498cc3018d"
SRC_URI[sha256sum] = "d94370e43b676ac44fbe1ab68ca903a6147eaba3a9e8eff85b2c05556a455b76"

BBCLASSEXTEND = "native nativesdk"
