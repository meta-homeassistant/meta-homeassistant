SUMMARY = "Parse Python docstrings in reST, Google and Numpydoc format"
HOMEPAGE = "https://github.com/rr-/docstring_parser"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=4014649477385d83f428a6adae447a49"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS = "python3-hatchling-native"
SRC_URI[sha256sum] = "583de4a309722b3315439bb31d64ba3eebada841f2e2cee23b99df001434c912"

inherit pypi python_hatchling

PYPI_PACKAGE = "docstring_parser"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
