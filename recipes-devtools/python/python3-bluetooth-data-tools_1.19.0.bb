SUMMARY = "Tools for converting bluetooth data and packets"
HOMEPAGE = "https://github.com/Bluetooth-Devices/bluetooth-data-tools"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=732518afbb3ba92dbf606e49f9045cc9"

SRC_URI[sha256sum] = "5b58349126efbb38d61222267cf85bf1766f832cc5744a59e70a1a2653e477d9"

PYPI_PACKAGE = "bluetooth_data_tools"

DEPENDS += "\
    python3-cython-native \
"

RDEPENDS:${PN} = "\
    python3-core (>=3.10) \
"

inherit pypi python_poetry_core
