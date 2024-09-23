SUMMARY = "API helper for Advantage Air's MyAir and e-zone API"
HOMEPAGE = "https://github.com/Bre77/advantage_air"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=60654eb6e6af743db792c09c1e51b035"

SRC_URI[sha256sum] = "e2b451f48c731f912261f5b35987b20b0a0b0762deb415721fb2f79e4be9fa00"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-aiohttp \
    python3-core (>=3.6) \
"

PYPI_PACKAGE = "advantage_air"
