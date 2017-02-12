SUMMARY = "Discover devices on your local network"
HOMEPAGE = "https://github.com/home-assistant/netdisco"
LICENSE = "MIT"

# TODO: Use correct file once: https://github.com/home-assistant/netdisco/issues/83 is fixed
#LIC_FILES_CHKSUM = "file://LICENSE;md5=3f056150ac7fad21b51033a5e4ad0031"
LIC_FILES_CHKSUM = "file://setup.cfg;md5=c7944671b56b57941659d2e5928422bb"

inherit pypi

SRC_URI[md5sum] = "88ebaa676c9c4b530beb59ce39e7865c"
SRC_URI[sha256sum] = "5b5cbb51f279516a5eda55dcaa83fd6e459c5241fdf095f00067c2d7fcb9f9a6"

RDEPENDS_${PN} = "${PYTHON_PN}-netifaces ${PYTHON_PN}-requests ${PYTHON_PN}-threading ${PYTHON_PN}-zeroconf"
