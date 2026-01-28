SUMMARY = "Manage Airthings BLE devices"
HOMEPAGE = "https://github.com/Airthings/airthings-ble"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=09aa137ecbf8273158ad8ceb70d15b70"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

inherit python_poetry_core ptest-python-pytest

SRC_URI = "\
    git://github.com/Airthings/airthings-ble;protocol=https;branch=main; \
"
SRCREV = "47fd2e97854eb9c67c168954c79b3b59c2fb6531"

RDEPENDS:${PN}-ptest = "\
    python3-pytest-asyncio \
    python3-pytest-cov \
    python3-pylint \
    python3-pytest-rerunfailures \
"
