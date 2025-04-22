SUMMARY = "isal support for aiohttp"
HOMEPAGE = "https://github.com/bdraco/aiohttp-isal"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9fd9da0eba9bb27343ae47cb3fb6cde8"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI = "\
    git://github.com/bdraco/aiohttp-isal.git;protocol=https;branch=main \
    file://run-ptest \
"
SRC_URI[sha256sum] = "5fa3ab3ebaff80ba3d39cafecf5916e9c8a1117178d2085ad1d0123d13d8bf71"
SRCREV = "cb9f09872578a8cfb022e1c8e622fab904940231"

inherit python_poetry_core ptest

S = "${WORKDIR}/git"

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.9.0) \
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
