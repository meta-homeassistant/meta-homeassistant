SUMMARY = "Module to communicate with a Balboa spa wifi adapter."
HOMEPAGE = "https://github.com/garbled1/pybalboa"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "7be415cd05b58cd678cb7b5c1edb6cf3ff0eb7b97c7078aa1923e0ef79da8541"

inherit pypi python_poetry_core

DEPENDS += "python3-poetry-dynamic-versioning-native"

PYPI_PACKAGE = "pybalboa"
