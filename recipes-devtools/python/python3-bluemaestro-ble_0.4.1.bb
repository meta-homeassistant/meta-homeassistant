SUMMARY = "bluemaestro BLE devices"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d8b5b84f8af09011094cd7c29a9f972c"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "884af2af525ef158eba80d1ab03ee2657ff4b068b93eec5c7f42f3da3dd7bacc"

inherit pypi python_poetry_core

PYPI_PACKAGE = "bluemaestro_ble"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"

RDEPENDS:${PN} += " \
    python3-bluetooth-sensor-state-data (>=1.8.0) \
    python3-sensor-state-data (>=2.6.0) \
    python3-bluetooth-data-tools (>=1.28.0) \
    python3-habluetooth (>=3.42.0) \
"
