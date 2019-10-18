SUMMARY = "RestrictedPython is a defined subset of the Python language which allows to provide a program input into a trusted environment"
HOMEPAGE = "http://pypi.python.org/pypi/RestrictedPython"
LICENSE = "ZPL-2.1"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=78ccb3640dc841e1baecb3e27a6966b2"

DEPENDS += "${PYTHON_PN}-pytest-runner-native"

inherit pypi setuptools3

PYPI_PACKAGE = "RestrictedPython"

SRC_URI[md5sum] = "b4d0399a6666fb9a85ab4da6bb4309db"
SRC_URI[sha256sum] = "a080569bffdf53371ae3e754ab1732f43054b1bab904fc100f74ba68ac731abc"

