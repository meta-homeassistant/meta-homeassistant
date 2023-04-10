DESCRIPTION = "Low-level, data-driven core of boto 3."
HOMEPAGE = "https://github.com/boto/botocore"
AUTHOR = "Amazon Web Services"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=2ee41112a44fe7014dce33e26468ba93"

SRC_URI[md5sum] = "8924069ba44ec6f2363168f842e102c2"
SRC_URI[sha256sum] = "d49caf1dae7dd903c2af443dbafd76dcf3902d87236a83f8b64e77aa556d1c6b"

inherit pypi setuptools3

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-jmespath \
    ${PYTHON_PN}-dateutil \
    ${PYTHON_PN}-docutils \
    ${PYTHON_PN}-shell \
    ${PYTHON_PN}-netserver \
    ${PYTHON_PN}-email \
    ${PYTHON_PN}-json \
    ${PYTHON_PN}-numbers \
    ${PYTHON_PN}-html \
    ${PYTHON_PN}-urllib3 \
" 
