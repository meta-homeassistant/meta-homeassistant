LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=7145f7cdd263359b62d342a02f005515"

inherit pypi setuptools3

SRC_URI[md5sum] = "3a6d8ac4ea82f24071b228519b6eadd4"
SRC_URI[sha256sum] = "cc1bac3818baabc1dce46c3fb1147d7ec905ae6c2dbabc5f4e8af4c034394e77"

RDEPENDS_${PN} = "\
	${PYTHON_PN}-boto3 (>=1.10.49) \
	${PYTHON_PN}-requests (>=2.22.0) \
	${PYTHON_PN}-six (>=1.10.0) \
"
