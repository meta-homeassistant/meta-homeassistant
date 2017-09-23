SUMMARY = "An Asynchronous Library for the KNX protocol."
HOMEPAGE = "http://xknx.io/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=838c366f69b72c5df05c96dff79b35f2"

inherit pypi setuptools3

SRC_URI[md5sum] = "311aca19ccb4e87d22e49ba36afea692"
SRC_URI[sha256sum] = "0a5c44a39f31b0be402eb664beeb2d84e5ca3a489b0a4e98e4b54ac434d1b97c"

RDEPENDS_${PN} = "${PYTHON_PN}-pyyaml ${PYTHON_PN}-netifaces ${PYTHON_PN}-multidict ${PYTHON_PN}-yarl"
