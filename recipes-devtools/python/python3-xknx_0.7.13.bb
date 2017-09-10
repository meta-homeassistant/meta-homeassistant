SUMMARY = "An Asynchronous Library for the KNX protocol."
HOMEPAGE = "http://xknx.io/"
LICENSE = "MIT"
# TODO: https://github.com/XKNX/xknx/pull/59
LIC_FILES_CHKSUM = "file://setup.py;md5=ce65d562e2131a98db609f7ccb0db9cf"

inherit pypi setuptools3

SRC_URI[md5sum] = "1406ad1dfbe1b0bafae2e23e6d233fec"
SRC_URI[sha256sum] = "4b48b2ac9bae2ff2d1c3870ebac25f3fb1f0d9b0884b1d95724c7f04e014ba4a"

RDEPENDS_${PN} = "${PYTHON_PN}-pyyaml ${PYTHON_PN}-netifaces ${PYTHON_PN}-multidict ${PYTHON_PN}-yarl"
