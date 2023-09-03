SUMMARY = "Tools for converting bluetooth data and packets"
HOMEPAGE = "https://github.com/Bluetooth-Devices/bluetooth-data-tools"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=732518afbb3ba92dbf606e49f9045cc9"

SRC_URI[sha256sum] = "ee46a4044aada776542f00100403ff7b6785897ffcbd964fd5b7e9712aa78cda"

PYPI_PACKAGE = "bluetooth_data_tools"

DEPENDS += "\
    ${PYTHON_PN}-cython-native \
"

inherit pypi python_setuptools_build_meta python_poetry_core
