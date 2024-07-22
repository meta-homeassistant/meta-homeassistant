SUMMARY = "Tools for converting bluetooth data and packets"
HOMEPAGE = "https://github.com/Bluetooth-Devices/bluetooth-data-tools"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=732518afbb3ba92dbf606e49f9045cc9"

SRC_URI[sha256sum] = "b443eede81a30e3222c85c116279d83ea90468e8def49e1105d43b430ecffc23"

PYPI_PACKAGE = "bluetooth_data_tools"

DEPENDS += "\
    python3-cython-native \
"

RDEPENDS:${PN} = "\
    python3-core (>=3.10) \
    python3-cryptography (>=41.0.3) \
"

inherit pypi python_poetry_core
