SUMMARY = "Manage Airthings BLE devices"
HOMEPAGE = "https://github.com/Airthings/airthings-ble"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=09aa137ecbf8273158ad8ceb70d15b70"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

inherit python_poetry_core ptest-python-pytest

SRC_URI = "git://github.com/Airthings/airthings-ble;protocol=https;branch=release/1.3;tag=${PV}"
SRCREV = "88464cfb86b46925746e3e3288d77c553c673468"

RDEPENDS:${PN}-ptest = "\
    python3-pytest-asyncio \
    python3-pytest-cov \
    python3-pylint \
    python3-pytest-rerunfailures \
"
