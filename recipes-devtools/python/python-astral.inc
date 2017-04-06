SUMMARY = "Calculations for the position of the sun and moon"
HOMEPAGE = "https://github.com/sffjunkie/astral"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3504d672db73bec8465bdb67542a50b5"

PYPI_PACKAGE_EXT = "zip"
inherit pypi

SRC_URI[md5sum] = "140499d213a234cb216e6b7fe36ee3c7"
SRC_URI[sha256sum] = "e7f2c825ac101c0953812e0f4c617ca48bd9dd5f4ebf450f7ce9086ed8f5a1fe"

# setup.py of astral requires it
DEPENDS += "${PYTHON_PN}-pytz-native"
