SUMMARY = "Discover devices on your local network"
HOMEPAGE = "https://github.com/home-assistant/netdisco"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://LICENSE.md;md5=f4eda51018051de136d3b3742e9a7a40"

inherit pypi

SRC_URI[md5sum] = "cef556f3fd34b6efae34dd7470fde554"
SRC_URI[sha256sum] = "668cec8612540f561274363c66cb8f80d450e65c5d1dc5fd84e3447c9b6f6005"

RDEPENDS_${PN} = "${PYTHON_PN}-netifaces ${PYTHON_PN}-requests ${PYTHON_PN}-threading ${PYTHON_PN}-zeroconf"
