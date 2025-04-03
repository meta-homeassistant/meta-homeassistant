SUMMARY = "Tools for converting bluetooth data and packets"
HOMEPAGE = "https://github.com/Bluetooth-Devices/bluetooth-data-tools"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=732518afbb3ba92dbf606e49f9045cc9"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI:append = "\
    file://0001-Fix-license-field.patch \
    file://0001-allow-older-setuptools-version.patch \
"
SRC_URI[sha256sum] = "71d78caa1f8d280ebc3467a07b5948084ad3a4a6f5f2a7892b76bc08fec4bf9a"

PYPI_PACKAGE = "bluetooth_data_tools"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"

RDEPENDS:${PN} = "\
    python3-core (>=3.10) \
"

inherit pypi python_poetry_core cython
