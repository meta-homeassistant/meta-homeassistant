SUMMARY = "BThome BLE support"
HOMEPAGE = "https://github.com/bluetooth-devices/bthome-ble"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=608a8a816ff4fe4e2c8112e382d1d7c8"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "a3c53966b39ab36f2ee8fd2a7ecf15c3a6eb2a2a3c715823b6c44308430cc94c"

inherit pypi python_poetry_core

PYPI_PACKAGE = "bthome_ble"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"

RDEPENDS:${PN} += " \
    python3-bluetooth-sensor-state-data (>=1.6.1) \
    python3-sensor-state-data (>=2.16.1) \
    python3-bluetooth-data-tools (>=0.1.2) \
    python3-cryptography (>=40.0.0) \
    python3-habluetooth (>=3.0) \
"
