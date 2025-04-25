SUMMARY = "The geodesic routines from GeographicLib"
HOMEPAGE = "https://geographiclib.sourceforge.io/Python/2.0"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5fb429df6cb064435042deac91ef7c75"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "f7f41c85dc3e1c2d3d935ec86660dc3b2c848c83e17f9a9e51ba9d5146a15859"

inherit pypi setuptools3

PYPI_PACKAGE = "geographiclib"
