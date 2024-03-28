SUMMARY = "Tools for converting bluetooth data and packets"
HOMEPAGE = "https://github.com/Bluetooth-Devices/bluetooth-data-tools"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=732518afbb3ba92dbf606e49f9045cc9"

SRC_URI[sha256sum] = "713b6377f89e83bcbce8e12b940ba10c7496b21dc608e9433489ccc5ea57dd4e"

PYPI_PACKAGE = "bluetooth_data_tools"

DEPENDS += "\
    python3-cython-native \
"

RDEPENDS:${PN} = "\
    python3-core (>=3.10) \
"

inherit pypi python_setuptools_build_meta python_poetry_core
