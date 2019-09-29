SUMMARY = "The Home Assistant frontend"
HOMEPAGE = "https://github.com/home-assistant/home-assistant-polymer"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=f4eda51018051de136d3b3742e9a7a40"

inherit pypi setuptools3

SRC_URI[md5sum] = "33b9076255cb7616e197f20064c8a0d3"
SRC_URI[sha256sum] = "a27ba1cb38e550c73cdb2c722cec7650823f04a62f081f518d81c333193988e6"

RDEPENDS_${PN} = "\
    ${PYTHON_PN}-user-agents \
"
