LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=7;endline=7;md5=adc1f231c76ee2f1f36025d56926ba2c"

inherit pypi setuptools3

SRC_URI[md5sum] = "e0fab14cc0d0a7a34bc23fc2a5c90a0b"
SRC_URI[sha256sum] = "5b84d6bf285b4dde43468d9687e0fef7206bda4d50e4ac1e70a56c49de7c5e44"

RDEPENDS_${PN} = "\
	${PYTHON_PN}-websocket-client (>=0.56.0) \
	${PYTHON_PN}-requests (>=2.21.0) \
"
