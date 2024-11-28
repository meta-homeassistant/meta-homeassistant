SUMMARY = "Wrapper of psutil that removes reliance on globals "
HOMEPAGE = "https://github.com/home-assistant-libs/psutil-home-assistant"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=dab31a1d28183826937f4b152143a33f"

PYPI_SRC_URI = "git://github.com/home-assistant-libs/psutil-home-assistant.git;protocol=https;branch=master"
SRCREV = "7a09bcf9773b528d8b9f33257839d7775704f1a4"

SRC_URI:append = " \
    file://run-ptest \
"
SRC_URI[sha256sum] = "ebe4f3a98d76d93a3140da2823e9ef59ca50a59761fdc453b30b4407c4c1bdb8"

inherit pypi python_setuptools_build_meta ptest

S = "${WORKDIR}/git"

RDEPENDS:${PN} = "\
    python3-psutil \
"

RDEPENDS:${PN}-ptest = "\
    python3-pytest \
    python3-unittest-automake-output \
"

do_install_ptest() {
    install -d ${D}${PTEST_PATH}/tests
    cp -rf ${S}/tests/* ${D}${PTEST_PATH}/tests/
}
