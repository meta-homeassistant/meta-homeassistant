SUMMARY = "Bleak is a GATT client software, capable of connecting to BLE devices acting as GATT servers."
HOMEPAGE = "https://github.com/hbldh/bleak"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=bcbc2069a86cba1b5e47253679f66ed7"

SRC_URI:append = " \
    file://0001-fix-poetry-version-compatibility.patch \
"

SRC_URI[sha256sum] = "ec4a1a2772fb315b992cbaa1153070c7e26968a52b0e2727035f443a1af5c18f"

PYPI_PACKAGE = "bleak"

inherit pypi python_poetry_core

RDEPENDS:${PN} += " \
    python3-core (>=3.8) \
    python3-async-timeout (>=3.0.0) \
    python3-dbus-fast (>=1.83.0) \
"