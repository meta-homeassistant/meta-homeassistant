LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-3.0;md5=c79ff39f19dfec6d293b95dea7b07891"

inherit pypi setuptools3

SRC_URI[md5sum] = "5280bf6ffcc20547ca18acb9ecaf0771"
SRC_URI[sha256sum] = "4ad609039b206399c9c44ef2131c78580a0077499f94e9b1b3aa80b03dd67f83"

RDEPENDS:${PN} = "\
	${PYTHON_PN}-websocket-client (>=0.56.0) \
	${PYTHON_PN}-six (>=1.14.0) \
"
