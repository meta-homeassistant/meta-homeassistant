SUMMARY = "The Home Assistant frontend"
HOMEPAGE = "https://github.com/home-assistant/home-assistant-polymer"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=f4eda51018051de136d3b3742e9a7a40"

inherit pypi setuptools3

SRC_URI[md5sum] = "a792c7657ed86f7e84a70739a6221653"
SRC_URI[sha256sum] = "edb3dd2c8bfebeacad2754b185d647733a179d85a391a2153edf841ef1e4592e"

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-user-agents \
"
