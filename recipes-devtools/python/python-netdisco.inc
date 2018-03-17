SUMMARY = "Discover devices on your local network"
HOMEPAGE = "https://github.com/home-assistant/netdisco"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://LICENSE.md;md5=f4eda51018051de136d3b3742e9a7a40"

inherit pypi

SRC_URI[md5sum] = "c3aa561ee51b66fd7a401215320cb0af"
SRC_URI[sha256sum] = "749aecca5787f7f9e3f18de339099284b6ed821f29325009b807b3949f184900"

RDEPENDS_${PN} = "\
    ${PYTHON_PN}-netifaces \
    ${PYTHON_PN}-requests \
    ${PYTHON_PN}-threading \
    ${PYTHON_PN}-zeroconf \
    "
