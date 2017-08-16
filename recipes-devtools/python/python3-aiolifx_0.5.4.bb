SUMMARY = "API for local communication with LIFX devices over a LAN with asyncio"
HOMEPAGE = "https://github.com/frawau/aiolifx"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=2347c1e7634502e3dd20d50b94f353d3"

inherit pypi setuptools3

SRC_URI[md5sum] = "5444b92521a85d0c05cca791004ffc3e"
SRC_URI[sha256sum] = "981247b5bf19ed9850e5e8ad7abf7a68a48166622d37068697ac7e4d74d4f9a6"

RDEPENDS_${PN} = "${PYTHON_PN}-bitstring"
