SUMMARY = "An Asynchronous Library for the KNX protocol."
HOMEPAGE = "http://xknx.io/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=838c366f69b72c5df05c96dff79b35f2"

inherit pypi setuptools3

SRC_URI[md5sum] = "7c53063aceda1a919cc592c38c856ab0"
SRC_URI[sha256sum] = "c24cf87dbfb6ed8085eca05c240ae9f2fff4cc416654b4197c93ad80c9cad7c9"

RDEPENDS_${PN} = "${PYTHON_PN}-pyyaml ${PYTHON_PN}-netifaces ${PYTHON_PN}-multidict ${PYTHON_PN}-yarl"
