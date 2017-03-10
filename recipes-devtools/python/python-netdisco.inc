SUMMARY = "Discover devices on your local network"
HOMEPAGE = "https://github.com/home-assistant/netdisco"
LICENSE = "MIT"

# TODO: Use correct file once: https://github.com/home-assistant/netdisco/issues/83 is fixed
#LIC_FILES_CHKSUM = "file://LICENSE;md5=3f056150ac7fad21b51033a5e4ad0031"
LIC_FILES_CHKSUM = "file://setup.cfg;md5=c7944671b56b57941659d2e5928422bb"

inherit pypi

SRC_URI[md5sum] = "8b3b261ed6e2aa2d3d076c4e11b9ea1a"
SRC_URI[sha256sum] = "11e80a8ba67f36d76bedefe346c06211380d45ccad96f54a9789acb4db158d3f"

RDEPENDS_${PN} = "${PYTHON_PN}-netifaces ${PYTHON_PN}-requests ${PYTHON_PN}-threading ${PYTHON_PN}-zeroconf"
