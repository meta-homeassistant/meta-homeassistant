SUMMARY = "Manage Airthings BLE devices"
HOMEPAGE = "https://github.com/Airthings/airthings-ble"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=09aa137ecbf8273158ad8ceb70d15b70"

inherit python_poetry_core ptest

SRC_URI = "\
    git://github.com/Airthings/airthings-ble;protocol=https;branch=main; \
    file://run-ptest \
"
SRCREV = "69e503045bd7061e40edf5e3c0b0fc5b3e2d1362"

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
