SUMMARY = "Recover bluetooth adapters that are in an stuck state"
HOMEPAGE = "https://github.com/bluetooth-devices/bluetooth-auto-recovery"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d8b5b84f8af09011094cd7c29a9f972c"

SRC_URI[sha256sum] = "0481657fb1d24c250ebde04783b4e22d0ff4590b92ad7e6b7fde214264599469"

PYPI_PACKAGE = "bluetooth_auto_recovery"

inherit pypi python_setuptools_build_meta python_poetry_core

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-async-timeout (>=4.0.1) \
    ${PYTHON_PN}-btsocket (>=0.2.0) \
    ${PYTHON_PN}-pyric (>=0.1.6.3) \
    ${PYTHON_PN}-usb-devices (>=0.4.1) \
    ${PYTHON_PN}-bluetooth-adapters (>=0.16.0) \
"
