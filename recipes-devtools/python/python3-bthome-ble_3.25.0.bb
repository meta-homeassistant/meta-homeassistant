SUMMARY = "BThome BLE support"
HOMEPAGE = "https://github.com/bluetooth-devices/bthome-ble"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=608a8a816ff4fe4e2c8112e382d1d7c8"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "f2addbe1c3df8832c43f98f17554c8a4936124f1e589b945b960acc5037103bd"

inherit pypi python_poetry_core


RDEPENDS:${PN} += " \
    python3-bluetooth-sensor-state-data (>=1.6.1) \
    python3-sensor-state-data (>=2.19.0) \
    python3-bluetooth-data-tools (>=0.1.2) \
    python3-cryptography (>=40.0.0) \
    python3-habluetooth (>=3.0) \
"
