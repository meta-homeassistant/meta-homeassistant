LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=7;endline=7;md5=8227180126797a0148f94f483f3e1489"

inherit pypi setuptools3

SRC_URI[md5sum] = "5280bf6ffcc20547ca18acb9ecaf0771"
SRC_URI[sha256sum] = "4ad609039b206399c9c44ef2131c78580a0077499f94e9b1b3aa80b03dd67f83"

RDEPENDS_${PN} = "\
	${PYTHON_PN}-websocket-client (>=0.56.0) \
	${PYTHON_PN}-six (>=1.14.0) \
"
