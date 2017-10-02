SUMMARY = "API towards Ubiquity Networks UniFi controller"
HOMEPAGE = "https://github.com/finish06/unifi-api"
LICENSE = "MIT"
#TODO: https://github.com/finish06/pyunifi/pull/13
LIC_FILES_CHKSUM = "file://setup.cfg;md5=864765d724552cf6e3d5c96c2eacb5bd"

inherit pypi

SRC_URI[md5sum] = "cea9c55077e8146fd735f0159002f628"
SRC_URI[sha256sum] = "b8a565ba26514334d5f999bcc3d349b9cd7d09d33c2d5087393b0955f6770bb6"

RDEPENDS_${PN} = "${PYTHON_PN}-requests"
