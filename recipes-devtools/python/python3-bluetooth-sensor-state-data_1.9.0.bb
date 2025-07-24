SUMMARY = "Models for storing and converting Bluetooth Sensor State Data"
HOMEPAGE = "https://github.com/bluetooth-devices/bluetooth-sensor-state-data"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=732518afbb3ba92dbf606e49f9045cc9"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "d289b86e4a65a5bccce6310f686d6f3e4ac4a2c56a13c2fccb475a6894667139"

inherit pypi python_poetry_core

PYPI_PACKAGE = "bluetooth_sensor_state_data"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"

RDEPENDS:${PN} = "\
    python3-sensor-state-data (>=2.0) \
    python3-bluetooth-data-tools (>=1.28.0) \
    python3-habluetooth (>=3.42.0) \
"
