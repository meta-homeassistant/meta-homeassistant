SUMMARY = "RestrictedPython is a defined subset of the Python language which allows to provide a program input into a trusted environment"
HOMEPAGE = "http://pypi.python.org/pypi/RestrictedPython"
LICENSE = "ZPL-2.1"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=78ccb3640dc841e1baecb3e27a6966b2"

DEPENDS += "${PYTHON_PN}-pytest-runner-native"

inherit pypi

PYPI_PACKAGE = "RestrictedPython"

SRC_URI[md5sum] = "3587ed56f55015526c502e71cbc3c39a"
SRC_URI[sha256sum] = "8aa8923f68e26c2a1dc42d6ad34284d92b34c8e96faed55efdd8c01195031393"
