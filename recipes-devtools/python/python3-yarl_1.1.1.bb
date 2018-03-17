SUMMARY = "Yet another URL library"
HOMEPAGE = "https://github.com/aio-libs/yarl/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b334fc90d45983db318f54fd5bf6c90b"

inherit pypi setuptools3

SRC_URI[md5sum] = "eb683ad7e87dff3fd5e2823873ce8ad6"
SRC_URI[sha256sum] = "a69dd7e262cdb265ac7d5e929d55f2f3d07baaadd158c8f19caebf8dde08dfe8"

RDEPENDS_${PN} = "${PYTHON_PN}-multidict"
