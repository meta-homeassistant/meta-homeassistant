SUMMARY = "Recover bluetooth adapters that are in an stuck state"
HOMEPAGE = "https://github.com/bluetooth-devices/bluetooth-auto-recovery"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d8b5b84f8af09011094cd7c29a9f972c"

SRC_URI[sha256sum] = "36ebf08e7cf44e35c15175323aed91e1bf2418792a4c3f76165d16d0f437614b"

PYPI_PACKAGE = "bluetooth_auto_recovery"

inherit pypi python_poetry_core

RDEPENDS:${PN} = "\
    python3-core (>3.9) \
    python3-pyric (>=0.1.6.3) \
    python3-btsocket (>=0.2.0) \
    python3-async-timeout (>=4.0.1) \
    python3-bluetooth-adapters (>=0.16.0) \
    python3-usb-devices (>=0.4.1) \
"
