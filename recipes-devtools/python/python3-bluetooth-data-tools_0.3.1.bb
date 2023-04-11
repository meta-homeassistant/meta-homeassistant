SUMMARY = "Tools for converting bluetooth data and packets"
HOMEPAGE = "https://github.com/Bluetooth-Devices/bluetooth-data-tools"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=732518afbb3ba92dbf606e49f9045cc9"

SRC_URI[md5sum] = "58b357a802de47d8d758f611c1866456"
SRC_URI[sha256sum] = "247e896ec963bf2204c0e77bc5ec09dafaa4e065afffe38553b9d4d526b71617"

PYPI_PACKAGE = "bluetooth_data_tools"

inherit pypi python_setuptools_build_meta python_poetry_core
