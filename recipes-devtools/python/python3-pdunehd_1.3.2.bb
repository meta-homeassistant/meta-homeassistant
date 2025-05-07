SUMMARY = "A Python wrapper for Dune HD media player API"
HOMEPAGE = "https://github.com/valentinalexeev/pdunehd"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "c37a4e089e1e5d6b8d48959841665ae78f8fe3a957c8c078a98136f32faa9c7d"

inherit pypi setuptools3

PYPI_PACKAGE = "pdunehd"
