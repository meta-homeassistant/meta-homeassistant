DESCRIPTION = "Intent parsing for Home Assistant"
HOMEPAGE = "https://github.com/home-assistant/hassil"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=86d3f3a95c324c9479bd8986968f4327"

inherit pypi python_setuptools_build_meta

SRC_URI[sha256sum] = "1cb7ac062a8270e0c484d768a0202b97f0d8a1ad4216078f8e8f81ec2e5b3bd1"

RDEPENDS:${PN} = "\
    python3-pyyaml (>=6.0) \
    python3-unicode-rbnf (=1.1.0) \
"
