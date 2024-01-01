SUMMARY = "Tools for converting bluetooth data and packets"
HOMEPAGE = "https://github.com/Bluetooth-Devices/bluetooth-data-tools"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=732518afbb3ba92dbf606e49f9045cc9"

SRC_URI[sha256sum] = "f76f8d2b100b44c90fc86479797bcc194c3594affdd75d7f51eb50a18ca6eb7e"

PYPI_PACKAGE = "bluetooth_data_tools"

DEPENDS += "\
    ${PYTHON_PN}-cython-native \
"

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-core (>=3.10) \
"

inherit pypi python_setuptools_build_meta python_poetry_core
