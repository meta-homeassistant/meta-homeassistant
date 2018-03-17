SUMMARY = "The Home Assistant frontend"
HOMEPAGE = "https://github.com/home-assistant/home-assistant-polymer"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=f4eda51018051de136d3b3742e9a7a40"

inherit pypi setuptools3

SRC_URI[md5sum] = "e5e216af1eb586356a2ff2c370e5d721"
SRC_URI[sha256sum] = "5a7cca7ed461d650859df7d036ff4c579366bbcde5eb6407b1aff6a0dbbae2c2"

RDEPENDS_${PN} = "\
    ${PYTHON_PN}-user-agents \
    "
