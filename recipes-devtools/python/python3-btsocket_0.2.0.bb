SUMMARY = "Python library to interact with the Bluez Bluetooth Management API communicating with the kernel using a so-called Bluetooth Management sockets"
HOMEPAGE = "https://github.com/ukBaz/python-btsocket"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=363a8d5ecf81b0e022be8395c2a6986b"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[md5sum] = "1abc2c93abc16fea4a9453d68bc76152"
SRC_URI[sha256sum] = "6862250b7e0973d2beea9e49d3b5ced324d80e5003a0350856879e537ba777a8"

inherit pypi python_setuptools_build_meta
