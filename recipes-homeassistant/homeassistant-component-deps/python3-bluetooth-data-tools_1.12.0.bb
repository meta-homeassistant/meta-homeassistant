SUMMARY = "Tools for converting bluetooth data and packets"
HOMEPAGE = "https://github.com/Bluetooth-Devices/bluetooth-data-tools"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=732518afbb3ba92dbf606e49f9045cc9"

SRC_URI[sha256sum] = "b1ecbbadbf44c37b212f38df6d071e82299813ab991d2384720fcf19fbf94976"

PYPI_PACKAGE = "bluetooth_data_tools"

DEPENDS += "\
    ${PYTHON_PN}-cython-native \
"

inherit pypi python_setuptools_build_meta python_poetry_core
