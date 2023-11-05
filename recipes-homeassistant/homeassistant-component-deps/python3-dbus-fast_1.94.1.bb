SUMMARY = "A faster version of dbus-next originally from the great DBus next library."
HOMEPAGE = "https://github.com/bluetooth-devices/dbus-fast"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=729e372b5ea0168438e4fd4a00a04947"

SRC_URI[sha256sum] = "9514e4abf586c656fb70cf9dab323a019131a032765997972045059717b7537c"

PYPI_PACKAGE = "dbus_fast"

inherit pypi setuptools3

RDEPENDS:${PN} += " \
    python3-core (>=3.7) \
"
