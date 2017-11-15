SUMMARY = "Discover devices on your local network"
HOMEPAGE = "https://github.com/home-assistant/netdisco"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://LICENSE.md;md5=f4eda51018051de136d3b3742e9a7a40"

inherit pypi

SRC_URI[md5sum] = "538840b5e91eae0ae78bd68c958197b7"
SRC_URI[sha256sum] = "b18548e717b23fc1e6d4f42631232213e59d0fc926bc52d077d6f352aa4601b5"

RDEPENDS_${PN} = "${PYTHON_PN}-netifaces ${PYTHON_PN}-requests ${PYTHON_PN}-threading ${PYTHON_PN}-zeroconf"
