HOMEPAGE = "https://www.nabucasa.com/"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-3.0;md5=c79ff39f19dfec6d293b95dea7b07891"

inherit pypi setuptools3

SRC_URI[md5sum] = "7c5dea602de4ea888c8fbe63adfc25cb"
SRC_URI[sha256sum] = "c9093ef803fc98737b95aee9a0bf74eedbecd74b9579567759faaddd165bdd92"

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-warrant (>=0.6.1) \
    ${PYTHON_PN}-snitun (>=0.18) \
    ${PYTHON_PN}-acme (>=0.32.0) \
    ${PYTHON_PN}-cryptography (>=2.5) \
    ${PYTHON_PN}-attrs (>=18.2.0) \
    ${PYTHON_PN}-pytz \
"
