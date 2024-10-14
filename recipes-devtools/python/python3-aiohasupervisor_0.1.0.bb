SUMMARY = "Asynchronous python client for Home Assistant Supervisor."
HOMEPAGE = "https://www.home-assistant.io/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "git://github.com/home-assistant-libs/python-supervisor-client;branch=main;protocol=https \
           file://run-ptest \
           file://0001-relax-build-tool-dependencies.patch \
           "

SRC_URI[sha256sum] = "26af5c49d30c5d58111e140ad4bb86c1547a1814c8af0ded87bcbd86e4524233"
SRCREV = "7819a2858b2bfc34924e7823f493abba995e271d"

inherit python_setuptools_build_meta ptest

S = "${WORKDIR}/git"

PYPI_PACKAGE = "aiohasupervisor"

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.3.0) \
    python3-mashumaro (>=3.11) \
    python3-orjson (>=3.6.1) \
    python3-yarl (>=1.6.0) \
"

RDEPENDS:${PN}-ptest = "\
    python3-pytest \
    python3-pytest-aiohttp \
    python3-pytest-cov \
    python3-pytest-timeout \
    python3-unittest-automake-output \
"

do_install_ptest() {
    install -d ${D}${PTEST_PATH}/tests
    cp -rf ${S}/tests/* ${D}${PTEST_PATH}/tests/
}
