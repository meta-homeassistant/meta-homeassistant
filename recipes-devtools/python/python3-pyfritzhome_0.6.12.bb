SUMMARY = "Python Library to access AVM Fritz!Box homeautomation"
HOMEPAGE = "https://github.com/hthiery/python-fritzhome"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=01351c51c0264f1a06fee66797afb35a"

SRC_URI = "\
    file://run-ptest \
"
SRC_URI[sha256sum] = "89235e70cfd9198cea4c2e4d9d8fc033fe9a1c84098e68498446fcd0f0247ccb"

inherit pypi setuptools3 ptest

RDEPENDS:${PN} = "\
    python3-cryptography \
    python3-requests \
"

RDEPENDS:${PN}-ptest = "\
    python3-pytest \
    python3-unittest-automake-output \
"

do_install_ptest() {
    install -d ${D}${PTEST_PATH}/tests
    cp -rf ${S}/tests/* ${D}${PTEST_PATH}/tests/
}
