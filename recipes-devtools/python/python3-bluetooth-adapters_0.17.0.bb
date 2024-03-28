SUMMARY = "Tools to enumerate and find Bluetooth Adapters"
HOMEPAGE = "https://github.com/bluetooth-devices/bluetooth-adapters"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=732518afbb3ba92dbf606e49f9045cc9"

SRC_URI[sha256sum] = "6a82ec713a4a5eccb870d7e9ff98e4002bbae885e1ab0f98f5056fc68db22325"

PYPI_PACKAGE = "bluetooth_adapters"

inherit pypi python_poetry_core

RDEPENDS:${PN} = "\
    python3-core (>3.9) \
    python3-mac-vendor-lookup (>=0.1.12) \
"

RDEPENDS:${PN}-dev = "\
    python3-aiohttp (>=3.8.1) \
    python3-async-timeout (>=4.0.2) \
    python3-bleak (>=0.21.1)) \
    python3-dbus-fast (>=1.21.0) \
    python3-usb-devices (>=0.4.5) \
"
