SUMMARY = "Manage Govee BLE devices"
HOMEPAGE = "https://github.com/bluetooth-devices/govee-ble"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=732518afbb3ba92dbf606e49f9045cc9"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "0f038f6c735244b7cdee1fcac9c2bd0630a0c839fe98996088f333f47791c3c5"

inherit pypi python_poetry_core

RDEPENDS:${PN} = "\
    python3-home-assistant-bluetooth \
    python3-sensor-state-data \
    python3-bluetooth-data-tools \
    python3-bluetooth-sensor-state-data \
    python3-cryptography \
"
