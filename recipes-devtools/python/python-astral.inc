SUMMARY = "Calculations for the position of the sun and moon"
HOMEPAGE = "https://github.com/sffjunkie/astral"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3504d672db73bec8465bdb67542a50b5"

PYPI_PACKAGE_EXT = "zip"
inherit pypi

SRC_URI[md5sum] = "b1b5738b4237bf9e8813f1f2ffd64452"
SRC_URI[sha256sum] = "e4bbd7748835cd76809ec06852c2a0afd44ecbb1873351a31f0dbb78f44f2de3"

# setup.py of astral requires it
DEPENDS += "${PYTHON_PN}-pytz-native"
