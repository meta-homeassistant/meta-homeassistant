SUMMARY = "Calculations for the position of the sun and moon"
HOMEPAGE = "https://github.com/sffjunkie/astral"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a944942e1496af1886903d274dedb13"

PYPI_PACKAGE_EXT = "zip"
inherit pypi

SRC_URI[md5sum] = "17f565a413ed2f883c980fde5dc68a21"
SRC_URI[sha256sum] = "01a4bc0967329635b869d92ed3772e55e674599721eb59d0bcb561fe7b61b856"

# setup.py of astral requires it
DEPENDS += "${PYTHON_PN}-pytz-native"
