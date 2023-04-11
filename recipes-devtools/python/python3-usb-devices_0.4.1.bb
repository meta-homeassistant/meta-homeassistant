SUMMARY = "Tools for mapping, describing, and resetting USB devices."
HOMEPAGE = "https://github.com/bluetooth-devices/usb-devices"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d8b5b84f8af09011094cd7c29a9f972c"

SRC_URI[md5sum] = "226f165a296d8e6fc8c5fe9235d74633"
SRC_URI[sha256sum] = "2ad810ba1fd29817d014fe244179fbd06866b92a3285e2bb3a8442f99a8e47b6"

inherit pypi python_setuptools_build_meta python_poetry_core

PYPI_PACKAGE = "usb_devices"