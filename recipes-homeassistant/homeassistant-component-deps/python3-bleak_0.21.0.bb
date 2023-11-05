SUMMARY = "Bleak is a GATT client software, capable of connecting to BLE devices acting as GATT servers."
HOMEPAGE = "https://github.com/hbldh/bleak"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=bcbc2069a86cba1b5e47253679f66ed7"

SRC_URI:append = " \
    file://0001-fix-poetry-version-compatibility.patch \
"

SRC_URI[sha256sum] = "227a88b78831e6e2322a9be209dce6628177382885e3065fbe9c25445a9bae79"

PYPI_PACKAGE = "bleak"

inherit pypi python_poetry_core

RDEPENDS:${PN} += " \
    python3-core (>=3.7) \
    python3-async-timeout \
    python3-dbus-fast (>=1.83.0) \
"