DESCRIPTION = "Linux Distribution - a Linux OS platform information API"
HOMEPAGE = "https://github.com/nir0s/distro"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d2794c0df5b907fdace235a619d80314"

inherit pypi

SRC_URI[md5sum] = "259e26a3a5a1c92faead7216cce433a9"
SRC_URI[sha256sum] = "77ec1f3695eed4dcda4e0e89d04dfcd91a20d3080d34f9294c5da47235382745"

BBCLASSEXTEND = "native nativesdk"
