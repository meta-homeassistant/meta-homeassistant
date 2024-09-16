SUMMARY = "Manage Airthings BLE devices"
HOMEPAGE = "https://github.com/Airthings/airthings-ble"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5d503272f52c35147ec960cb56a03bf4"

inherit python_poetry_core ptest

SRC_URI = "\
    git://github.com/Airthings/airthings-ble;protocol=https;branch=main; \
    file://run-ptest \
"
SRCREV = "42521c65418ae7243c0429ceee7dc254f265ae1d"

S = "${WORKDIR}/git"

RDEPENDS:${PN}-ptest = "\
    python3-pytest \
    python3-pytest-cov \
    python3-unittest-automake-output \
"

do_install_ptest() {
    install -d ${D}${PTEST_PATH}/tests
    cp -rf ${S}/tests/* ${D}${PTEST_PATH}/tests/
}
