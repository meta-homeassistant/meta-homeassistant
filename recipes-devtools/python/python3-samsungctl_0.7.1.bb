SUMMARY = "Remote control Samsung televisions via a TCP/IP connection"
HOMEPAGE = " https://github.com/Ape/samsungctl.git"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://LICENSE;md5=d15899171de611ea06093a47d5fb4419"

inherit pypi setuptools3

SRC_URI[md5sum] = "ee02d16491f65be09ae21787885dfeb0"
SRC_URI[sha256sum] = "2fc175fb730b39ebaed5d95db178a6daeec1b802146b0116ed13e7629a1bff46"

RDEPENDS_${PN} = "\
    ${PYTHON_PN}-wakeonlan \
"
