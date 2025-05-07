SUMMARY = "Manage Airthings BLE devices"
HOMEPAGE = "https://github.com/Airthings/airthings-ble"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=09aa137ecbf8273158ad8ceb70d15b70"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

inherit python_poetry_core ptest-python-pytest

SRC_URI = "\
    git://github.com/Airthings/airthings-ble;protocol=https;branch=main; \
"
SRCREV = "69e503045bd7061e40edf5e3c0b0fc5b3e2d1362"

S = "${WORKDIR}/git"
