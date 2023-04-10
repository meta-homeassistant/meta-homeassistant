SUMMARY = "Frontend for Home Assistant"
HOMEPAGE = "https://github.com/home-assistant/home-assistant-polymer"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=f4eda51018051de136d3b3742e9a7a40"

# Pypi only offers the wheel version and no tar-gz for this package. Point to
# the github release tarball insteadd
PYPI_SRC_URI = "https://github.com/home-assistant/frontend/releases/download/${PV}/home-assistant-frontend-${PV}.tar.gz"

inherit pypi python_setuptools_build_meta

SRC_URI += "file://0001-Change-tool-version-to-allow-newer-version.patch"
SRC_URI[md5sum] = "752de038e447e2996b1f5397ab05fd3a"
SRC_URI[sha256sum] = "a4d450548f6545e7a1eab479a222c13f8edbfdb0fa1004ff43a51750c715f3c6"

# RDEPENDS:${PN} = "\
#     ${PYTHON_PN}-user-agents \
# "
