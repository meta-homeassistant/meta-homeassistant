SUMMARY = "API for local communication with LIFX devices over a LAN with asyncio"
HOMEPAGE = "https://github.com/frawau/aiolifx"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=2347c1e7634502e3dd20d50b94f353d3"

inherit pypi setuptools3

SRC_URI[md5sum] = "9c70ad696144b9848dc9a224d7b12218"
SRC_URI[sha256sum] = "4c455737d50895f7134d3a63e100165bcee73e591dc1a7d8ee1bb76c974fe612"

RDEPENDS_${PN} = "${PYTHON_PN}-bitstring"
