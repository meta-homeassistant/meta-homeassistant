SUMMARY = "A connector for Bleak Clients that handles transient connection failures"
HOMEPAGE = "https://github.com/bluetooth-devices/bleak-retry-connector"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d8b5b84f8af09011094cd7c29a9f972c"

SRC_URI[md5sum] = "8c4043b160fba2be8dd70edcf1156c0f"
SRC_URI[sha256sum] = "980c373e24d51a8390a4e25afd4f124b9d0ba52cc72c6cc6297a8817dcbcfdf6"

PYPI_PACKAGE = "bleak_retry_connector"

inherit pypi python_setuptools_build_meta python_poetry_core

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-async-timeout (>=4.0.1) \
    ${PYTHON_PN}-bleak (>=0.19.0) \
    ${PYTHON_PN}-bluetooth-adapters (>=0.15.2) \
    ${PYTHON_PN}-dbus-fast (>=1.14.0) \
"
