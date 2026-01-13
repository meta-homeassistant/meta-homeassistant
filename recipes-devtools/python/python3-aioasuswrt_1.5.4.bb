SUMMARY = "Api wrapper for Asuswrt https://www.asus.com/ASUSWRT/"
HOMEPAGE = "https://github.com/kennedyshead/aioasuswrt"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=0df66d8bc48009bf167de0140687e518"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "541814b51a395eaea78a81aae70d072db720360ed41e2226b0b7724272f8ad38"

inherit pypi python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-asyncssh \
"

PYPI_PACKAGE = "aioasuswrt"
