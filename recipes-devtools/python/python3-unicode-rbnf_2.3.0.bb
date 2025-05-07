SUMMARY = "Rule-based number formatting using Unicode CLDR data"
HOMEPAGE = "https://github.com/rhasspy/unicode-rbnf"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=2aa2bed6f8750823223a2c11d7bc90c5"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

inherit pypi python_setuptools_build_meta ptest-python-pytest

SRC_URI[sha256sum] = "8a3ac2fe199929b7f342bbc74f5f86f01a4e7d324811be02ea6474851e73e5ad"

PYPI_PACKAGE = "unicode_rbnf"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
