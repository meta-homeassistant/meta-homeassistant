SUMMARY = "Python library to interact with the Bluez Bluetooth Management API communicating with the kernel using a so-called Bluetooth Management sockets"
HOMEPAGE = "https://github.com/ukBaz/python-btsocket"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a756f433cda3b32df08555bc02207cc1"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[md5sum] = "c711069b2c1cb4fcc16312fed9b4d287"
SRC_URI[sha256sum] = "b539b01cafebd2406c00097f94525ea0f8ecd1dd92f7731f43eac0ef16c2ccc9"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "PyRIC"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
