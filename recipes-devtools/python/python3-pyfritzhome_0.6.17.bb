SUMMARY = "Python Library to access AVM Fritz!Box homeautomation"
HOMEPAGE = "https://github.com/hthiery/python-fritzhome"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=01351c51c0264f1a06fee66797afb35a"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI = "\
    file://run-ptest \
"
SRC_URI[sha256sum] = "e1c845efdc0c92ff8e80d3c317a6c05df35ed05449ec80df23f1dac69b8c4f58"

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
