SUMMARY = "High availability Bluetooth"
HOMEPAGE = "https://github.com/bluetooth-devices/habluetooth"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=da57f3e0372e39698a274746eb9d65d6"

SRC_URI[sha256sum] = "42edf66b6bc76de8213b4ad2a4163c7a64a8dd2a59b6a7792f98c2da64e00e69"

inherit pypi python_poetry_core

DEPENDS += "\
    python3-cython-native \
"

RDEPENDS:${PN} = "\
    python3-core (>=3.10) \
    python3-bleak (>=0.21.1) \
    python3-bleak-retry-connector (>=3.3.0) \
    python3-bluetooth-data-tools (>=1.16.0) \
    python3-bluetooth-adapters (>=0.16.1) \
    python3-bluetooth-auto-recovery (>=1.2.3) \
"

PYPI_PACKAGE = "habluetooth"
