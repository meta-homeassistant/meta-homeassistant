HOMEPAGE = "https://www.nabucasa.com/"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-3.0;md5=c79ff39f19dfec6d293b95dea7b07891"

inherit pypi setuptools3

SRC_URI[md5sum] = "86da0daa5c4f28e987d2fa19a2d3fa49"
SRC_URI[sha256sum] = "cfbc2787ebdc828f09d3a370c78b45a32f89706dad55412336bc9e9f69fef3e1"

RDEPENDS_${PN} = "\
    ${PYTHON_PN}-warrant (>=0.6.1) \
    ${PYTHON_PN}-snitun (>=0.18) \
    ${PYTHON_PN}-acme (>=0.32.0) \
    ${PYTHON_PN}-cryptography (>=2.5) \
    ${PYTHON_PN}-attrs (>=18.2.0) \
    ${PYTHON_PN}-pytz \
"
