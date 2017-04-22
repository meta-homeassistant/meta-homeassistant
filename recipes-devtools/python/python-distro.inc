DESCRIPTION = "Linux Distribution - a Linux OS platform information API"
HOMEPAGE = "https://github.com/nir0s/distro"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d2794c0df5b907fdace235a619d80314"

inherit pypi

SRC_URI[md5sum] = "1624fe57831ba50b2ecc850ff0dc86a8"
SRC_URI[sha256sum] = "9b000b0d637bb0cbd130a7a4835681e6993e309a85564dfea9d884825fe46954"

BBCLASSEXTEND = "native nativesdk"
