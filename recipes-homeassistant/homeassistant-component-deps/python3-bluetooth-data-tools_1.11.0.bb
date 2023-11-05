SUMMARY = "Tools for converting bluetooth data and packets"
HOMEPAGE = "https://github.com/Bluetooth-Devices/bluetooth-data-tools"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=732518afbb3ba92dbf606e49f9045cc9"

SRC_URI[sha256sum] = "17ad30f0b9ec92c60dc6efc21fc04dd4d97089bf1d0751238572f678e6c7974f"

PYPI_PACKAGE = "bluetooth_data_tools"

DEPENDS += "\
    ${PYTHON_PN}-cython-native \
"

inherit pypi python_setuptools_build_meta python_poetry_core
