SUMMARY = "Tools to enumerate and find Bluetooth Adapters"
HOMEPAGE = "https://github.com/bluetooth-devices/bluetooth-adapters"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=732518afbb3ba92dbf606e49f9045cc9"

SRC_URI[sha256sum] = "d2ff76ca3ee7aa27df18e0c233e36e16251bd92225d0c1d5712f07360f607176"

PYPI_PACKAGE = "bluetooth_adapters"

inherit pypi python_poetry_core

RDEPENDS:${PN} = "\
    python3-aiooui (>=0.1.1) \
    python3-core (>3.9) \
"

RDEPENDS:${PN}-dev = "\
    python3-async-timeout (>=4.0.2) \
    python3-bleak (>=0.21.1)) \
    python3-dbus-fast (>=1.21.0) \
    python3-usb-devices (>=0.4.5) \
"
