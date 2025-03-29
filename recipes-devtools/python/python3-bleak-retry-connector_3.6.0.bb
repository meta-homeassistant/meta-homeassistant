SUMMARY = "A connector for Bleak Clients that handles transient connection failures"
HOMEPAGE = "https://github.com/bluetooth-devices/bleak-retry-connector"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d8b5b84f8af09011094cd7c29a9f972c"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI:append = " \
    file://run-ptest \
"
SRC_URI[sha256sum] = "71f30928180b74f0381e0752f681d18d8de888faa9c81c78cd17123718909ea0"
SRCREV = "bf87683893ab1ad8f518e5db677832c6d91523d0"

inherit pypi python_poetry_core ptest

PYPI_SRC_URI = "git://github.com/Bluetooth-Devices/bleak-retry-connector.git;protocol=https;branch=main"

S = "${UNPACKDIR}/git"

RDEPENDS:${PN} = "\
    python3-core (>=3.10) \
"

RDEPENDS:${PN}-dev += "\
    python3-bleak (>=0.21.0) \
    python3-bluetooth-adapters (>=0.15.2) \
    python3-dbus-fast (>=1.14.0) \
"

RDEPENDS:${PN}-ptest = "\
    python3-pytest \
    python3-pytest-asyncio \
    python3-unittest-automake-output \
"

do_install_ptest() {
    install -d ${D}${PTEST_PATH}/tests
    cp -rf ${S}/tests/* ${D}${PTEST_PATH}/tests/
}
