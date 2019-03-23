SUMMARY = "The Home Assistant frontend"
HOMEPAGE = "https://github.com/home-assistant/home-assistant-polymer"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=f4eda51018051de136d3b3742e9a7a40"

inherit pypi setuptools3

SRC_URI[md5sum] = "b55110ceaa23054fadcd8e3eb2a68e95"
SRC_URI[sha256sum] = "1b07b7efb3e0004df752f9aa40c42e80d5da13371f48df8e21c7579093849aae"

RDEPENDS_${PN} = "\
    ${PYTHON_PN}-user-agents \
    "
