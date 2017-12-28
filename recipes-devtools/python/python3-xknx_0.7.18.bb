SUMMARY = "An Asynchronous Library for the KNX protocol."
HOMEPAGE = "http://xknx.io/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=838c366f69b72c5df05c96dff79b35f2"

inherit pypi setuptools3

SRC_URI[md5sum] = "c7596f9a837d71335ab0eb9da767c409"
SRC_URI[sha256sum] = "ba02823fb6f77c9faf5153b093fcf50b2183ad6e67d791f9fd0fcb05927a9afc"

RDEPENDS_${PN} = "${PYTHON_PN}-pyyaml ${PYTHON_PN}-netifaces ${PYTHON_PN}-multidict ${PYTHON_PN}-yarl"
