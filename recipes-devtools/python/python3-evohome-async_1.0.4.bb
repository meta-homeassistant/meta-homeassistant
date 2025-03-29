SUMMARY = "An asyncio Python client to access the Evohome web service"
HOMEPAGE = "https://github.com/zxdavb/evohome-async"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=136e4f49dbf29942c572a3a8f6e88a77"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

inherit pypi python_hatchling ptest

SRC_URI:append = " \
    file://run-ptest \
    "
SRC_URI[sha256sum] = "678ce8ef1101973dc81d43420f050f23fe457f9990efe919855b44625c4f572e"

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.9.5) \
    python3-voluptuous (>=0.13.1) \
"

RDEPENDS:${PN}-ptest = "\
    python3-pytest \
    python3-unittest-automake-output \
"

do_install_ptest() {
    install -d ${D}${PTEST_PATH}/tests
    cp -rf ${S}/tests/* ${D}${PTEST_PATH}/tests/
}

PYPI_PACKAGE = "evohome_async"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
