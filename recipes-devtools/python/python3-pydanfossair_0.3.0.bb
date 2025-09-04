SUMMARY = "Python interface for Danfoss Air HRV systems"
HOMEPAGE = "https://github.com/JonasPed/pydanfoss-air"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "71100c5555a5cde1b312663499b9e57e0fdf9ab2f3ab877b16b18aabfe5e5d8a"

inherit pypi setuptools3

PYPI_PACKAGE = "pydanfossair"
