SUMMARY = "A run function for asyncio-based apps that does all the boilerplate."
HOMEPAGE = "https://github.com/cjrh/aiorun"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e3fc50a88d0a364313df4b21ef20c29e"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI:append = " file://run-ptest"
SRC_URI[sha256sum] = "87ea66b6146756ced58175d2f5ae64519ef96c4657f46b0e0c036e541a22c764"

inherit pypi python_flit_core ptest

PYPI_PACKAGE = "aiorun"

RDEPENDS:${PN}-ptest = "\
    python3-pytest \
    python3-pytest-cov \
    python3-unittest-automake-output \
"

do_install_ptest() {
    install -d ${D}${PTEST_PATH}/tests
    cp -rf ${S}/tests/* ${D}${PTEST_PATH}/tests/
}
