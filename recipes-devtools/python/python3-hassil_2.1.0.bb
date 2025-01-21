DESCRIPTION = "Intent parsing for Home Assistant"
HOMEPAGE = "https://github.com/home-assistant/hassil"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=86d3f3a95c324c9479bd8986968f4327"

inherit pypi python_setuptools_build_meta

SRC_URI[sha256sum] = "0c1460c4e0c88f8442bc9ddbe5aabeee272372bead340ae9bf28d66e9a7daf61"

RDEPENDS:${PN} = "\
    python3-pyyaml (>=6.0) \
    python3-unicode-rbnf (>=2.2) \
"
