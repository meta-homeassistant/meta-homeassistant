DESCRIPTION = "Intent parsing for Home Assistant"
HOMEPAGE = "https://github.com/home-assistant/hassil/tree/v1.0.6"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=86d3f3a95c324c9479bd8986968f4327"

inherit pypi python_setuptools_build_meta

SRC_URI[md5sum] = "47099439d11c513658db773914b9017e"
SRC_URI[sha256sum] = "ac24952852247cf836698170b9854b33130ef12d75755f1fe1e724a456cd0779"

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-pyyaml (>=6.0) \
"
