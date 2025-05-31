SUMMARY = "Frontend for Home Assistant"
HOMEPAGE = "https://github.com/home-assistant/home-assistant-polymer"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=f4eda51018051de136d3b3742e9a7a40"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

# Pypi only offers the wheel version and no tar-gz for this package. Point to
# the github release tarball instead
PYPI_SRC_URI = "https://github.com/home-assistant/frontend/releases/download/${PV}/home_assistant_frontend-${PV}.tar.gz"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "home_assistant_frontend"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"

SRC_URI += "file://0001-relax-build-deps.patch"
SRC_URI[sha256sum] = "4ff855556a0c231c235e5f4c6cf9f958dd1b665278ae04d583bc08cd4b3e2a4d"

RDEPENDS:${PN} += "\
    python3-core (>=3.11) \
"
