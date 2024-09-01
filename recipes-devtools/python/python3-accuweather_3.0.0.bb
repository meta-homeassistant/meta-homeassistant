SUMMARY = "Python wrapper for getting weather data from AccuWeather API."
HOMEPAGE = "https://github.com/bieniu/accuweather"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e72b109bec9876d435561472fac35592"

PYPI_SRC_URI = "git://github.com/bieniu/accuweather.git;protocol=https;branch=master"

SRC_URI[sha256sum] = "63a3be60ae486b743ee6919b1877338b8db05e508b941c146a3d0baf9afc480b"

inherit pypi setuptools3 ptest

SRC_URI:append = " \
    file://run-ptest \
"

SRCREV = "eeca703c7c168246c103ee421ed0f0611f41da36"

S = "${WORKDIR}/git"

RDEPENDS:${PN} += "\
    python3-aiohttp (>=3.7.0) \
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
