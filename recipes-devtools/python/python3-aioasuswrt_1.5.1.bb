SUMMARY = "Api wrapper for Asuswrt https://www.asus.com/ASUSWRT/"
HOMEPAGE = "https://github.com/kennedyshead/aioasuswrt"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=0df66d8bc48009bf167de0140687e518"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "5990ea75f1d760d5d3a8380a54deaedc1caa82a6df309a48714617ffc5c3d5eb"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} += "\
    python3-asyncssh \
"

PYPI_PACKAGE = "aioasuswrt"
