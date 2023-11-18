DESCRIPTION = "Intent parsing for Home Assistant"
HOMEPAGE = "https://github.com/home-assistant/hassil"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=86d3f3a95c324c9479bd8986968f4327"

inherit pypi python_setuptools_build_meta

SRC_URI[sha256sum] = "18bbc34fc05406f133822a8a697a2417dd768377ce1fe2ac5e799e3972307bd5"

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-pyyaml (>=6.0) \
    ${PYTHON_PN}-unicode-rbnf (=1.0.0) \
"
