SUMMARY = "An Asynchronous Library for the KNX protocol."
HOMEPAGE = "http://xknx.io/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=838c366f69b72c5df05c96dff79b35f2"

inherit pypi setuptools3

SRC_URI[md5sum] = "49010ee0efa73d50c0ec6e7ca650a82e"
SRC_URI[sha256sum] = "0a176eec5ed39857d046875bd0fa607b47ad4996a33967d3f3267bb326ce00df"

RDEPENDS_${PN} = "\
    ${PYTHON_PN}-pyyaml \
    ${PYTHON_PN}-netifaces \
    ${PYTHON_PN}-multidict \
    ${PYTHON_PN}-yarl \
    "
