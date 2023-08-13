SUMMARY = "Recover bluetooth adapters that are in an stuck state"
HOMEPAGE = "https://github.com/bluetooth-devices/bluetooth-auto-recovery"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d8b5b84f8af09011094cd7c29a9f972c"

SRC_URI[md5sum] = "2868877c16481b9aaec4b867775e2b10"
SRC_URI[sha256sum] = "d1c4a548733af6bbe5f3178ea907379e10fe2a12fa19f4f0bfe6f66c8bebcb6a"

PYPI_PACKAGE = "bluetooth_auto_recovery"

inherit pypi python_setuptools_build_meta python_poetry_core

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-async-timeout (>=4.0.1) \
    ${PYTHON_PN}-btsocket (>=0.2.0) \
    ${PYTHON_PN}-pyric (>=0.1.6.3) \
    ${PYTHON_PN}-usb-devices (>=0.4.1) \
"
