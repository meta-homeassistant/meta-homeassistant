SUMMARY = "A Python wrapper for Dune HD media player API"
HOMEPAGE = "https://github.com/valentinalexeev/pdunehd"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "dcf0218c715f8e9a3e28384ebf28452b1df20a803c4540a65e787432bad6bdb7"

inherit pypi setuptools3

PYPI_PACKAGE = "pdunehd"
