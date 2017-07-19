SUMMARY = "API for local communication with LIFX devices over a LAN with asyncio"
HOMEPAGE = "https://github.com/frawau/aiolifx"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=2347c1e7634502e3dd20d50b94f353d3"

inherit pypi setuptools3

SRC_URI[md5sum] = "a27c89d1971c2913e7689d2f40a4e470"
SRC_URI[sha256sum] = "390bfd9bb1635c1962fbcad1d7980f0a3c14f803308f267b93813cbefb48feb1"

RDEPENDS_${PN} = "${PYTHON_PN}-bitstring"
