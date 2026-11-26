SUMMARY = "High availability Bluetooth"
HOMEPAGE = "https://github.com/bluetooth-devices/habluetooth"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=da57f3e0372e39698a274746eb9d65d6"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI = "git://github.com/Bluetooth-Devices/habluetooth.git;protocol=https;branch=main;tag=v${PV}"
SRCREV = "efc10fb2f55df617780db255667e1af96f6b8277"

inherit python_poetry_core cython ptest-python-pytest

RDEPENDS:${PN} = "\
    python3-async-interrupt (>=1.1.1) \
    python3-bleak (>=3.0.2) \
    python3-bleak-retry-connector (>=4.7.1) \
    python3-bluetooth-adapters (>=2.4.0) \
    python3-bluetooth-auto-recovery (>=1.6.4) \
    python3-bluetooth-data-tools (>=1.29.24) \
    python3-btsocket (>=0.3.0) \
    python3-core (>=3.11) \
    python3-dbus-fast (>=5.0.22) \
"

RDEPENDS:${PN}-ptest += "\
    python3-pytest-asyncio \
"
