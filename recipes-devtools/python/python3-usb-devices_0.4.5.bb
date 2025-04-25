SUMMARY = "Tools for mapping, describing, and resetting USB devices."
HOMEPAGE = "https://github.com/bluetooth-devices/usb-devices"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d8b5b84f8af09011094cd7c29a9f972c"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI = "\
    git://github.com/Bluetooth-Devices/usb-devices.git;protocol=https;branch=main \
    file://run-ptest \
"
SRC_URI[sha256sum] = "9b5c7606df2bc791c6c45b7f76244a0cbed83cb6fa4c68791a143c03345e195d"
SRCREV = "4d885fe1647108d71afa9e0aaff216b690226ea5"

inherit python_poetry_core ptest

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
