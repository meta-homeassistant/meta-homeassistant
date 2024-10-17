SUMMARY = "Allows for querying of the RSSI values for nearby devices using pybluez. Ported to Python 3, based on https://github.com/ewenchou/bluetooth-proximity"
HOMEPAGE = "https://github.com/FrederikBolding/bluetooth-proximity"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c4082b6c254c9fb71136710391d9728b"

SRC_URI[sha256sum] = "f85d98763cff5719d812e5df8209cd50315a2d72d287518a017fd1b543729176"

inherit pypi setuptools3

PYPI_PACKAGE = "bt_proximity"
