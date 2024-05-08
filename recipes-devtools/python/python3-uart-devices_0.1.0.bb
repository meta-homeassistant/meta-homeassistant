SUMMARY = "UART Devices for Linux"
HOMEPAGE = "https://github.com/bdraco/uart-devices"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c8ea148e26a1546c1b0a99524d4da3f7"

SRC_URI = "\
    git://github.com/bdraco/uart-devices.git;protocol=https;branch=main \
"
SRCREV = "154f4b3efb7763097a050107e9585126594ebac2"

S = "${WORKDIR}/git"

inherit python_poetry_core ptest

RDEPENDS:${PN}-ptest = "\
    python3-pytest \
    python3-pytest-asyncio \
    python3-unittest-automake-output \
"

do_install_ptest() {
    install -d ${D}${PTEST_PATH}/tests
    cp -rf ${S}/tests/* ${D}${PTEST_PATH}/tests/
}
