SUMMARY = "A faster version of dbus-next"
HOMEPAGE = "https://github.com/bluetooth-devices/dbus-fast"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=729e372b5ea0168438e4fd4a00a04947"

SRC_URI[md5sum] = "3124ea6373c54e4a1cb8a71cacc07519"
SRC_URI[sha256sum] = "a2c7072349b6cf0062f461c8c0b23db6f494e458976144bfd45adf2f7f076945"

PYPI_PACKAGE = "dbus_fast"

DEPENDS += "\
    ${PYTHON_PN}-cython-native \
"

inherit pypi python_setuptools_build_meta python_poetry_core

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-async-timeout (>=3.0.0) \
"
