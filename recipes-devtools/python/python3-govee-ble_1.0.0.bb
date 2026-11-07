SUMMARY = "Manage Govee BLE devices"
HOMEPAGE = "https://github.com/bluetooth-devices/govee-ble"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=732518afbb3ba92dbf606e49f9045cc9"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "c73ab8c0ec9db71a2aa7009f895824b307b68d36db316d8c2866ecbbb0de3da6"

inherit pypi python_poetry_core

RDEPENDS:${PN} = "\
    python3-bluetooth-data-tools (>=0.1.2) \
    python3-bluetooth-sensor-state-data (>=1.5.0) \
    python3-cryptography (>=42.0.0) \
    python3-home-assistant-bluetooth (>=1.3.0) \
    python3-sensor-state-data (>=2.18.0) \
"
