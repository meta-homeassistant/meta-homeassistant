SUMMARY = "Rule-based number formatting using Unicode CLDR data"
HOMEPAGE = "https://github.com/rhasspy/unicode-rbnf"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=2aa2bed6f8750823223a2c11d7bc90c5"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

inherit pypi python_setuptools_build_meta ptest-python-pytest

SRC_URI[sha256sum] = "d0b3e77d1ce27666d3e67834518c53642ff191e674ee423faa89c37f554a7efb"
