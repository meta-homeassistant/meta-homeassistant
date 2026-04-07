SUMMARY = "Models for storing and converting Sensor Data state"
HOMEPAGE = "https://github.com/bluetooth-devices/sensor-state-data"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=732518afbb3ba92dbf606e49f9045cc9"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "bad940f9a36bc18b03f59a8245af87c19436240e9ca321afa87655c61a995ac0"

inherit pypi python_poetry_core

PYPI_PACKAGE = "sensor_state_data"
