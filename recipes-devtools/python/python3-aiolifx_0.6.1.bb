SUMMARY = "API for local communication with LIFX devices over a LAN with asyncio"
HOMEPAGE = "https://github.com/frawau/aiolifx"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=2347c1e7634502e3dd20d50b94f353d3"

inherit pypi setuptools3

SRC_URI[md5sum] = "394276cb14269cd213068ae3d7b23bb1"
SRC_URI[sha256sum] = "5ece61d89f4bbc839e23c4082d91e25e5f90f2ab4d16843b617af5dacb1638d3"

RDEPENDS_${PN} = "${PYTHON_PN}-bitstring"
