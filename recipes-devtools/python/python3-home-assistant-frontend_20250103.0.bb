SUMMARY = "Frontend for Home Assistant"
HOMEPAGE = "https://github.com/home-assistant/home-assistant-polymer"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=f4eda51018051de136d3b3742e9a7a40"

# Pypi only offers the wheel version and no tar-gz for this package. Point to
# the github release tarball instead
PYPI_SRC_URI = "https://github.com/home-assistant/frontend/releases/download/${PV}/home_assistant_frontend-${PV}.tar.gz"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "home_assistant_frontend"

SRC_URI[sha256sum] = "cda97c2ca03038abb1064d5fedd54e4c929a1ff0c3f6cec2f8aac5da80f71275"

RDEPENDS:${PN} += "\
    python3-core (>=3.11) \
"
