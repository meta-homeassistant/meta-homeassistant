SUMMARY = "Tools for converting bluetooth data and packets"
HOMEPAGE = "https://github.com/Bluetooth-Devices/bluetooth-data-tools"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=732518afbb3ba92dbf606e49f9045cc9"

SRC_URI[sha256sum] = "9911451842a32ae380ba21ae85e78b0ecb2c1d6d52b901bcd9eaee8052c1b25c"

PYPI_PACKAGE = "bluetooth_data_tools"

DEPENDS += "\
    ${PYTHON_PN}-cython-native \
"

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-core (>=3.10) \
"

inherit pypi python_setuptools_build_meta python_poetry_core
