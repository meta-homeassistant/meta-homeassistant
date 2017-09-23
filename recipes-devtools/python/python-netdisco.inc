SUMMARY = "Discover devices on your local network"
HOMEPAGE = "https://github.com/home-assistant/netdisco"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://LICENSE.md;md5=f4eda51018051de136d3b3742e9a7a40"

inherit pypi

SRC_URI[md5sum] = "77d325629c83467105f87fd0663bf10e"
SRC_URI[sha256sum] = "17d4052922e5fa09eded37df705d04fc584f094187e7464e5db7c2cb68ca9967"

RDEPENDS_${PN} = "${PYTHON_PN}-netifaces ${PYTHON_PN}-requests ${PYTHON_PN}-threading ${PYTHON_PN}-zeroconf"
