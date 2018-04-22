SUMMARY = "The Home Assistant frontend"
HOMEPAGE = "https://github.com/home-assistant/home-assistant-polymer"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=f4eda51018051de136d3b3742e9a7a40"

inherit pypi setuptools3

SRC_URI[md5sum] = "590fc2cb0772f7af41fdca17f310dccb"
SRC_URI[sha256sum] = "ac36d4f5e30e93b02dadd2ecdc07218fde3d97ffc2f69a6f1acf5e601cd4e5ad"

RDEPENDS_${PN} = "\
    ${PYTHON_PN}-user-agents \
    "
