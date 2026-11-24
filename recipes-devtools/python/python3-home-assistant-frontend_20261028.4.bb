SUMMARY = "Frontend for Home Assistant"
HOMEPAGE = "https://github.com/home-assistant/home-assistant-polymer"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

# Pypi only offers the wheel version and no tar-gz for this package. Point to
# the github release tarball instead
PYPI_SRC_URI = "https://github.com/home-assistant/frontend/releases/download/${PV}/home_assistant_frontend-${PV}.tar.gz"

inherit pypi python_setuptools_build_meta

SRC_URI += "file://0001-relax-build-deps.patch"
SRC_URI[sha256sum] = "ec4763fb0064f5f58b0c4f7d6127b93ead5367df3e858053b9ed4e76e4e8a0ad"

RDEPENDS:${PN} += "\
    python3-core (>=3.11) \
"
