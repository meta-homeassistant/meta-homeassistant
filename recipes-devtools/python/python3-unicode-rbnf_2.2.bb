SUMMARY = "Rule-based number formatting using Unicode CLDR data"
HOMEPAGE = "https://github.com/rhasspy/unicode-rbnf"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=2aa2bed6f8750823223a2c11d7bc90c5"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

inherit pypi python_setuptools_build_meta

SRCREV = "e26874c196b842a47f3770667155cc81662bfbc1"

PYPI_PACKAGE = "unicode_rbnf"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
