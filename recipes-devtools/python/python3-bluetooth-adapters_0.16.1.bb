SUMMARY = "Tools to enumerate and find Bluetooth Adapters"
HOMEPAGE = "https://github.com/bluetooth-devices/bluetooth-adapters"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=732518afbb3ba92dbf606e49f9045cc9"

SRC_URI[sha256sum] = "01d9fe85e634e1a5c449cc39855aec36bc673a902a2f7c875db736d4ebfd84e1"

PYPI_PACKAGE = "bluetooth_adapters"

inherit pypi python_setuptools_build_meta python_poetry_core

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-core (>3.9) \
    ${PYTHON_PN}-aiohttp (>=3.8.1) \
    ${PYTHON_PN}-async-timeout (>=4.0.2) \
    ${PYTHON_PN}-bleak (>=0.15.1)) \
    ${PYTHON_PN}-dbus-fast (>=1.21.0) \
    ${PYTHON_PN}-mac-vendor-lookup (>=0.1.12) \
    ${PYTHON_PN}-usb-devices (>=0.4.1) \
"
