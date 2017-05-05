SUMMARY = "API for local communication with LIFX devices over a LAN with asyncio"
HOMEPAGE = "https://github.com/frawau/aiolifx"
LICENSE = "MIT"
# TODO: https://github.com/frawau/aiolifx/issues/8
#LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=60dd5a575c9bd4339411bdef4a702d46"
LIC_FILES_CHKSUM = "file://setup.py;md5=6f97a391779cbecdb0bc0d6cd2b76da3"

inherit pypi setuptools3

SRC_URI[md5sum] = "a2102b989e1b4d293250c4efb193d512"
SRC_URI[sha256sum] = "85012342a2ebb124ba8551809fb1267ecc19f2b17eb4489ad9d291f8cd3af775"

RDEPENDS_${PN} = "${PYTHON_PN}-bitstring"
