LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a5eb74eb0b84de9e63b66147166bc4b5"

inherit pypi setuptools3

PYPI_PACKAGE = "gTTS-token"

SRC_URI[sha256sum] = "e1c022453fe599655444f5c47c423448d3e38c582d3e6e6328641d582ae0a1bf"

RDEPENDS:${PN} = "\
	${PYTHON_PN}-requests (>=2.22.0) \
"
