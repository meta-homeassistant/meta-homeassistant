DESCRIPTION = "Intent parsing for Home Assistant"
HOMEPAGE = "https://github.com/home-assistant/hassil"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

inherit pypi python_setuptools_build_meta ptest-python-pytest

SRC_URI[sha256sum] = "bed39573626d76bfc0681a709a6b64e4de82a680371bd29238473f6711392597"

RDEPENDS:${PN} = "\
    python3-pyyaml (>=6.0) \
    python3-unicode-rbnf (>=2.2) \
"
