SUMMARY = "Models for storing and converting Sensor Data state"
HOMEPAGE = "https://github.com/bluetooth-devices/sensor-state-data"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=732518afbb3ba92dbf606e49f9045cc9"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "25f17ed98748ae006ddab82d5013cf30301daaf23526d1992f99c4dc0beb49c3"

inherit pypi python_poetry_core

PYPI_PACKAGE = "sensor_state_data"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
