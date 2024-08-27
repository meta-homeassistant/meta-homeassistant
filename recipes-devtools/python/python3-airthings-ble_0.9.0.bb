SUMMARY = "Manage Airthings BLE devices"
HOMEPAGE = "https://github.com/Airthings/airthings-ble"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5d503272f52c35147ec960cb56a03bf4"

inherit pypi python_poetry_core ptest

PYPI_SRC_URI = "git://github.com/Airthings/airthings-ble;protocol=https;branch=main"

SRC_URI = "\
    file://run-ptest \
"
SRCREV = "ab31fcc09f65b6bc806ba7eadb9c1abd9e6a95ad"

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
