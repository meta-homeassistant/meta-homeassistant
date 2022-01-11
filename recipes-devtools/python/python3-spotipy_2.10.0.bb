LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=b46291b1d43fe22e63a77b034d62aa58"

inherit pypi setuptools3

SRC_URI[md5sum] = "9e51cef7016db08a972ddd804f07f386"
SRC_URI[sha256sum] = "f5bd0d04f4fd37d3b38cd3b35d2e9ce05182a57bc52403d6bad14d07bb4f4e68"

RDEPENDS_${PN} = "\
	${PYTHON_PN}-chardet (>=3.0.2) \
	${PYTHON_PN}-requests (>=2.22.0) \
	${PYTHON_PN}-six (>=1.10.0) \
"
