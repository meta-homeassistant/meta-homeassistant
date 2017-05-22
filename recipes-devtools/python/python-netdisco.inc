SUMMARY = "Discover devices on your local network"
HOMEPAGE = "https://github.com/home-assistant/netdisco"
LICENSE = "MIT"

# TODO: Use correct file once: https://github.com/home-assistant/netdisco/issues/83 is fixed
#LIC_FILES_CHKSUM = "file://LICENSE;md5=3f056150ac7fad21b51033a5e4ad0031"
LIC_FILES_CHKSUM = "file://setup.cfg;md5=409c94c5ba0e3f531654fba45822c981"

inherit pypi

SRC_URI[md5sum] = "c430c559ba6f703f42e038b2e921b7ec"
SRC_URI[sha256sum] = "e7141acb5224204e98c6f6abb637b093730f8bfe045970fe59ecd1f5f7bbd4a2"

RDEPENDS_${PN} = "${PYTHON_PN}-netifaces ${PYTHON_PN}-requests ${PYTHON_PN}-threading ${PYTHON_PN}-zeroconf"
