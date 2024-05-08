DESCRIPTION = "Low-level, data-driven core of boto 3."
HOMEPAGE = "https://github.com/boto/botocore"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=2ee41112a44fe7014dce33e26468ba93"

SRC_URI:append = " \
    file://run-ptest \
"
SRC_URI[sha256sum] = "5086217442e67dd9de36ec7e87a0c663f76b7790d5fb6a12de565af95e87e319"

inherit pypi setuptools3 ptest

RDEPENDS:${PN} = "\
    python3-dateutil (>=2.1) \
    python3-jmespath (>=0.7.1) \
    python3-urllib3 (>=1.25.4) \
"

RDEPENDS:${PN}-ptest = "\
    python3-pytest \
    python3-pytest-xdist \
    python3-unittest-automake-output \
"

do_install_ptest() {
    install -d ${D}${PTEST_PATH}/tests
    cp -rf ${S}/tests/* ${D}${PTEST_PATH}/tests/
}
