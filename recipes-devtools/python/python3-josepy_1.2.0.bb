DESCRIPTION = "JOSE protocol implementation in Python using cryptography."
HOMEPAGE = "https://github.com/certbot/josepy"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=d2c2a5517cd7fd190a1aa6dfa23abb7a"

inherit pypi setuptools3

SRC_URI[md5sum] = "d9a65fb86fba3e79af3724f375e9e7e1"
SRC_URI[sha256sum] = "9cec9a839fe9520f0420e4f38e7219525daccce4813296627436fe444cd002d3"

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-cryptography (>=0.8) \
    ${PYTHON_PN}-pyopenssl (>=0.13) \
"
