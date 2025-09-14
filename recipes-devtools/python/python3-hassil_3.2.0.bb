DESCRIPTION = "Intent parsing for Home Assistant"
HOMEPAGE = "https://github.com/home-assistant/hassil"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

inherit pypi python_setuptools_build_meta ptest-python-pytest

SRC_URI[sha256sum] = "e17438759446c3c39f4648ad82f32cd9b716a3fbeff059f50bc67cfc94649655"

RDEPENDS:${PN} = "\
    python3-pyyaml (>=6.0) \
    python3-unicode-rbnf (>=2.2) \
"
