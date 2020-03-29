LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-3.0;md5=c79ff39f19dfec6d293b95dea7b07891"

inherit pypi setuptools3

SRC_URI[md5sum] = "a408de47eef6bce0e3d19a3e9ebe6c23"
SRC_URI[sha256sum] = "04a3911cba7ac457e4b499b34fae461a2ba5eab9d4e97ed5c8310844e18474a6"

RDEPENDS_${PN} = "\
	${PYTHON_PN}-defusedxml (>=0.5.0) \
"
