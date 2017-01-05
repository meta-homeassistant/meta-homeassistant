SUMMARY = "Discover devices on your local network"
HOMEPAGE = "https://github.com/home-assistant/netdisco"
LICENSE = "MIT"

# TODO: Use correct file once: https://github.com/home-assistant/netdisco/issues/83 is fixed
#LIC_FILES_CHKSUM = "file://LICENSE;md5=3f056150ac7fad21b51033a5e4ad0031"
LIC_FILES_CHKSUM = "file://setup.cfg;md5=c7944671b56b57941659d2e5928422bb"

inherit pypi

SRC_URI[md5sum] = "1b5048f54d158604741d1161b938887f"
SRC_URI[sha256sum] = "7c4fd737cf8f393163a6408326f5c38006b329ef1e2f84acb5d507332a8498bf"

RDEPENDS_${PN} = "${PYTHON_PN}-netifaces ${PYTHON_PN}-requests ${PYTHON_PN}-threading ${PYTHON_PN}-zeroconf"
