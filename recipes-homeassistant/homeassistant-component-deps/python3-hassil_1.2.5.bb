DESCRIPTION = "Intent parsing for Home Assistant"
HOMEPAGE = "https://github.com/home-assistant/hassil/tree/v1.0.6"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=86d3f3a95c324c9479bd8986968f4327"

inherit pypi python_setuptools_build_meta

SRC_URI[sha256sum] = "b9d3a46482e86dadbe791f284854e1b01f38e8239a2176b0c116219f6eb59820"

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-pyyaml (>=6.0) \
"
