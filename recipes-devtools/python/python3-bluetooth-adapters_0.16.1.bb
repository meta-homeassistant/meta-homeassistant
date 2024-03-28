SUMMARY = "Tools to enumerate and find Bluetooth Adapters"
HOMEPAGE = "https://github.com/bluetooth-devices/bluetooth-adapters"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=732518afbb3ba92dbf606e49f9045cc9"

SRC_URI[sha256sum] = "01d9fe85e634e1a5c449cc39855aec36bc673a902a2f7c875db736d4ebfd84e1"

PYPI_PACKAGE = "bluetooth_adapters"

inherit pypi python_setuptools_build_meta python_poetry_core

RDEPENDS:${PN} = "\
    python3-core (>3.9) \
    python3-aiohttp (>=3.8.1) \
    python3-async-timeout (>=4.0.2) \
    python3-bleak (>=0.15.1)) \
    python3-dbus-fast (>=1.21.0) \
    python3-mac-vendor-lookup (>=0.1.12) \
    python3-usb-devices (>=0.4.1) \
"
