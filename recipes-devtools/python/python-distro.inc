DESCRIPTION = "Linux Distribution - a Linux OS platform information API"
HOMEPAGE = "https://github.com/nir0s/distro"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d2794c0df5b907fdace235a619d80314"

inherit pypi

SRC_URI[md5sum] = "5b16166628250c124fe722c6f45fd397"
SRC_URI[sha256sum] = "2d99cdfd48a72f5e5f8545a03ee320521af43bfc53d471f4adfaea3ec36fb2ce"

BBCLASSEXTEND = "native nativesdk"
