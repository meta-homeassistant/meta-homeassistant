SUMMARY = "API for local communication with LIFX devices over a LAN with asyncio"
HOMEPAGE = "https://github.com/frawau/aiolifx"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=2347c1e7634502e3dd20d50b94f353d3"

inherit pypi setuptools3

SRC_URI[md5sum] = "3b7e5b263edd8d8b714fcb887cad2a49"
SRC_URI[sha256sum] = "bfc00dee1620deddc92333f120db3678df725e4277ceba7d129841c812299d06"

RDEPENDS_${PN} = "${PYTHON_PN}-bitstring"
