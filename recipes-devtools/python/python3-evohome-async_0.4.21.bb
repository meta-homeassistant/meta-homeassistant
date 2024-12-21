SUMMARY = "An asyncio Python client to access the Evohome web service"
HOMEPAGE = "https://github.com/zxdavb/evohome-async"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=136e4f49dbf29942c572a3a8f6e88a77"

inherit pypi python_hatchling ptest

SRC_URI = "${PYPI_SRC_URI} \
           file://run-ptest \
           file://0001-Correct-hatchling-build-path.patch \
           "
SRC_URI[sha256sum] = "d94ae9854b17cdfa35c55969f03d8375049a40918ed2b87b6763262eb0aa354f"

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
