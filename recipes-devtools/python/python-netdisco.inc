SUMMARY = "Discover devices on your local network"
HOMEPAGE = "https://github.com/home-assistant/netdisco"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://LICENSE.md;md5=f4eda51018051de136d3b3742e9a7a40"

inherit pypi

SRC_URI[md5sum] = "49c35f2a9102daf9f83c7e7315361373"
SRC_URI[sha256sum] = "2b3aca14a1807712a053f11fd80dc251dd821ee4899aefece515287981817762"

RDEPENDS_${PN} = "\
    ${PYTHON_PN}-requests (>=2.0) \
    ${PYTHON_PN}-zeroconf (>=0.21.0) \
"
