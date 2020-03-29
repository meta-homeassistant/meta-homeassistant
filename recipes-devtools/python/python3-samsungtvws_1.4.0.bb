LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-3.0;md5=c79ff39f19dfec6d293b95dea7b07891"

inherit pypi setuptools3

SRC_URI[md5sum] = "e0fab14cc0d0a7a34bc23fc2a5c90a0b"
SRC_URI[sha256sum] = "5b84d6bf285b4dde43468d9687e0fef7206bda4d50e4ac1e70a56c49de7c5e44"

RDEPENDS_${PN} = "\
	${PYTHON_PN}-websocket-client (>=0.56.0) \
	${PYTHON_PN}-requests (>=2.21.0) \
"
