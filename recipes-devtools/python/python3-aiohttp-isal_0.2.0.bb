SUMMARY = "isal support for aiohttp"
HOMEPAGE = "https://github.com/bdraco/aiohttp-isal"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9fd9da0eba9bb27343ae47cb3fb6cde8"

SRC_URI = "\
    git://github.com/bdraco/aiohttp-isal.git;protocol=https;branch=main \
    file://run-ptest \
"
SRC_URI[sha256sum] = "5fa3ab3ebaff80ba3d39cafecf5916e9c8a1117178d2085ad1d0123d13d8bf71"
SRCREV = "96edc7e71b74cef2130e73d347db787d4049699d"

inherit python_poetry_core ptest

S = "${WORKDIR}/git"

RDEPENDS:${PN} = "\
    python3-aiohttp \
    python3-isal \
"

RDEPENDS:${PN}-ptest = "\
    python3-pytest \
    python3-unittest-automake-output \
"

do_install_ptest() {
    install -d ${D}${PTEST_PATH}/tests
    cp -rf ${S}/tests/* ${D}${PTEST_PATH}/tests/
}
