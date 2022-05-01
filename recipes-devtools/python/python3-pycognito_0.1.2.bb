LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-3.0;md5=c79ff39f19dfec6d293b95dea7b07891"

inherit pypi setuptools3

SRC_URI[md5sum] = "3a6d8ac4ea82f24071b228519b6eadd4"
SRC_URI[sha256sum] = "cc1bac3818baabc1dce46c3fb1147d7ec905ae6c2dbabc5f4e8af4c034394e77"

RDEPENDS:${PN} = "\
	${PYTHON_PN}-boto3 (>=1.10.49) \
	${PYTHON_PN}-requests (>=2.22.0) \
	${PYTHON_PN}-six (>=1.10.0) \
"
