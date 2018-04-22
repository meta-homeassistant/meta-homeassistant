SUMMARY = "Discover devices on your local network"
HOMEPAGE = "https://github.com/home-assistant/netdisco"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://LICENSE.md;md5=f4eda51018051de136d3b3742e9a7a40"

inherit pypi

SRC_URI[md5sum] = "1733dfd305533ea3c4ff7189b8cddc48"
SRC_URI[sha256sum] = "0c99880a5dd858628a43f853b09a3bf6ed9ef286bd0e9eed6e7ec5bfaaf58e59"

RDEPENDS_${PN} = "\
    ${PYTHON_PN}-netifaces \
    ${PYTHON_PN}-requests \
    ${PYTHON_PN}-threading \
    ${PYTHON_PN}-zeroconf \
    "
