HOMEPAGE = "https://www.nabucasa.com/"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=8ce93f51d70fd2b9add4f5b93af43d4a"

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
