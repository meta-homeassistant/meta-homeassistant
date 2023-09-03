DESCRIPTION = "Low-level, data-driven core of boto 3."
HOMEPAGE = "https://github.com/boto/botocore"
AUTHOR = "Amazon Web Services"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=2ee41112a44fe7014dce33e26468ba93"

SRC_URI[sha256sum] = "43006b4f52d7bb655319d3da0f615cdbee7762853acc1ebcb1d49f962e6b4806"

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
