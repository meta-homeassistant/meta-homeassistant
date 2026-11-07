SUMMARY = "Tools for converting bluetooth data and packets"
HOMEPAGE = "https://github.com/Bluetooth-Devices/bluetooth-data-tools"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=732518afbb3ba92dbf606e49f9045cc9"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "0d9e7b1e26cd4ebe733490cffeed18340bb4ee8c1a2c0a0e8119b656f49700e7"


RDEPENDS:${PN} = "\
    python3-core (>=3.10) \
    python3-cryptography \
"

inherit pypi python_poetry_core cython
