LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=f4eda51018051de136d3b3742e9a7a40"

inherit pypi setuptools3

SRC_URI[md5sum] = "a408de47eef6bce0e3d19a3e9ebe6c23"
SRC_URI[sha256sum] = "04a3911cba7ac457e4b499b34fae461a2ba5eab9d4e97ed5c8310844e18474a6"

RDEPENDS_${PN} = "\
	${PYTHON_PN}-defusedxml (>=0.5.0) \
"
