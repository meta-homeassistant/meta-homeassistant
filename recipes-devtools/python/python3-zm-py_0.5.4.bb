SUMMARY = "A loose python wrapper around the ZoneMinder REST API."
HOMEPAGE = "https://github.com/rohankapoorcom/zm-py"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=2b42edef8fa55315f34f2370b4715ca9"

SRC_URI[sha256sum] = "de8c89731034dc7f50814c2f8b94640324462cf43ef820ae914c98fa0df3988b"

inherit pypi python_poetry_core ptest

SRC_URI:append = " \
    file://run-ptest \
"

PYPI_PACKAGE = "zm_py"
RDEPENDS:${PN} = "python3-requests"

RDEPENDS:${PN}-ptest = "\
    python3-pytest \
    python3-unittest-automake-output \
"

do_install_ptest() {
    install -d ${D}${PTEST_PATH}/tests
    cp -rf ${S}/tests/* ${D}${PTEST_PATH}/tests/
}
