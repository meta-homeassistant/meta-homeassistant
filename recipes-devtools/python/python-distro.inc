DESCRIPTION = "Linux Distribution - a Linux OS platform information API"
HOMEPAGE = "https://github.com/nir0s/distro"
LICENSE = "Apache-2.0"
#TODO: https://github.com/nir0s/distro/issues/139
#LIC_FILES_CHKSUM = "file://LICENSE;md5=01441d50dc74476db58a41ac10cb9fa2"
LIC_FILES_CHKSUM = "file://README.rst;md5=22b95bbc874ff52f680aa3a08d5abf0a"

inherit pypi

SRC_URI[md5sum] = "d1726863ed44003b4e52884f888918c4"
SRC_URI[sha256sum] = "b940995858ec63a29a272ddf7916818bb5cccb9297928fb8230fd37a146b1f26"

BBCLASSEXTEND = "native nativesdk"
