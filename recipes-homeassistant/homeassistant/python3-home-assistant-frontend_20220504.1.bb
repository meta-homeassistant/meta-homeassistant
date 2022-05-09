SUMMARY = "The Home Assistant frontend"
HOMEPAGE = "https://github.com/home-assistant/home-assistant-polymer"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=f4eda51018051de136d3b3742e9a7a40"

# Pypi only offers the wheel version and no tar-gz for this package. Point to
# the github release tarball insteadd
PYPI_SRC_URI = "https://github.com/home-assistant/frontend/releases/download/20220504.1/home-assistant-frontend-20220504.1.tar.gz"

inherit pypi python_setuptools_build_meta

SRC_URI[md5sum] = "f99cbf0f1d904820b9820b6655f4d71e"
SRC_URI[sha256sum] = "f0d31c7e95df47eeab340d3299bbffe1752bb74f69668e38c78e2d6ce0ed7be0"

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-user-agents \
"
