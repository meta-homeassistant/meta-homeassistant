DESCRIPTION = "Intent parsing for Home Assistant"
HOMEPAGE = "https://github.com/home-assistant/intents"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

inherit pypi python_setuptools_build_meta ptest-python-pytest

SRC_URI[sha256sum] = "5a99ec8c3b7e26089284bfa642884db40784495ce3e0d8e2dd6f74ddcba44356"

RDEPENDS:${PN}-ptest += "\
    python3-hassil \
    python3-pyyaml \
"
