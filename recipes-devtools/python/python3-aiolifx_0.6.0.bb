SUMMARY = "API for local communication with LIFX devices over a LAN with asyncio"
HOMEPAGE = "https://github.com/frawau/aiolifx"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=2347c1e7634502e3dd20d50b94f353d3"

inherit pypi setuptools3

SRC_URI[md5sum] = "044994bf3c3c6eeb03d010f78f3ff342"
SRC_URI[sha256sum] = "5b099232e8952e17c6dd7d14dc3f1c167c890fa9548dd9f7b5319dbbcfd5ce7b"

RDEPENDS_${PN} = "${PYTHON_PN}-bitstring"
