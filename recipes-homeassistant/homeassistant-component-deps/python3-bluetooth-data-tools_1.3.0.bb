SUMMARY = "Tools for converting bluetooth data and packets"
HOMEPAGE = "https://github.com/Bluetooth-Devices/bluetooth-data-tools"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=732518afbb3ba92dbf606e49f9045cc9"

SRC_URI[sha256sum] = "3cb1749cb32843c28314e6b43f78f4ab49bed60c5849531b12ed08bd5737ab0a"

PYPI_PACKAGE = "bluetooth_data_tools"

DEPENDS += "\
    ${PYTHON_PN}-cython-native \
"

inherit pypi python_setuptools_build_meta python_poetry_core
