SUMMARY = "High availability Bluetooth"
HOMEPAGE = "https://github.com/bluetooth-devices/habluetooth"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=da57f3e0372e39698a274746eb9d65d6"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI = "\
    git://github.com/Bluetooth-Devices/habluetooth.git;protocol=https;branch=main \
    file://0001-Skip-tests-which-will-always-fail-in-a-correctly-set.patch \
"
SRCREV = "aa25c30a609e85728e04f0171cc09730ade11631"

inherit python_poetry_core cython ptest-python-pytest

RDEPENDS:${PN} = "\
    python3-async-interrupt (>=1.1.1) \
    python3-bleak (>=1.0.1) \
    python3-bleak-retry-connector (>=4.2.0) \
    python3-bluetooth-adapters (>=2.1.0) \
    python3-bluetooth-auto-recovery (>=1.5.1) \
    python3-bluetooth-data-tools (>=1.28.0) \
    python3-btsocket (>=0.3.0) \
    python3-dbus-fast (>=2.30.2) \
"

RDEPENDS:${PN}-ptest += "\
    python3-freezegun \
    python3-pytest-asyncio \
    python3-pytest-codspeed \
    python3-pytest-cov \
"

do_install_ptest:append() {
    install ${S}/pyproject.toml ${D}${PTEST_PATH}/
}
