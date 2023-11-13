SUMMARY = "A faster version of dbus-next originally from the great DBus next library."
HOMEPAGE = "https://github.com/bluetooth-devices/dbus-fast"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=729e372b5ea0168438e4fd4a00a04947"

SRC_URI[sha256sum] = "3dd64c5cd362ceead6cc02603b6b4cbda58b2cbb6ec816a2f21b1901dfc3cb61"

PYPI_PACKAGE = "dbus_fast"

inherit pypi setuptools3

RDEPENDS:${PN} += " \
    python3-core (>=3.7) \
"
