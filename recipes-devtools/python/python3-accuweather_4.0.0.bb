SUMMARY = "Python wrapper for getting weather data from AccuWeather API."
HOMEPAGE = "https://github.com/bieniu/accuweather"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e72b109bec9876d435561472fac35592"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI = "git://github.com/bieniu/accuweather.git;protocol=https;branch=master"
SRC_URI[sha256sum] = "63a3be60ae486b743ee6919b1877338b8db05e508b941c146a3d0baf9afc480b"

inherit setuptools3 ptest

SRC_URI:append = " \
    file://run-ptest \
"

SRCREV = "6059528a21f5571a53bcc3652bb2c4ba414efedd"

S = "${UNPACKDIR}/git"

RDEPENDS:${PN} += "\
    python3-aiohttp (>=3.9.4) \
    python3-orjson \
"

PYPI_PACKAGE = "accuweather"

RDEPENDS:${PN}-ptest = "\
    python3-aioresponses \
    python3-pytest \
    python3-pytest-asyncio \
    python3-pytest-timeout \
    python3-syrupy \
    python3-unittest-automake-output \
"

do_install_ptest() {
    install -d ${D}${PTEST_PATH}/tests
    cp -rf ${S}/tests/* ${D}${PTEST_PATH}/tests/
}
