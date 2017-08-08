SUMMARY = "Remote control Samsung televisions via a TCP/IP connection"
HOMEPAGE = " https://github.com/Ape/samsungctl.git"
LICENSE = "MIT"
SRCNAME = "samsungctl"

#TODO: Use LICENSE once https://github.com/remcohaszing/pywakeonlan/issues/4 is fixed
LIC_FILES_CHKSUM = "file://LICENSE;md5=d15899171de611ea06093a47d5fb4419"

inherit pypi

SRC_URI[md5sum] = "fea2e755b3c307d7a8edecc1b2822d22"
SRC_URI[sha256sum] = "59d4666baab4446879710779604b6c01620a3c107f719f6bcaa5c46455456fd7"

RDEPENDS_${PN} = "\
               ${PYTHON_PN}-wakeonlan \
"
