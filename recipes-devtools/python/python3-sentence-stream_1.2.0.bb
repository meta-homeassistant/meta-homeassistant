SUMMARY = "A small sentence splitter for text streams"
HOMEPAGE = "http://github.com/OHF-Voice/sentence-stream"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "92c7b6aa515d1d2a44693b719c77e3144dd6bbccd405261eee7a065d01191f71"

inherit pypi python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} = "python3-regex (>=2024.11.6)"

PYPI_PACKAGE = "sentence_stream"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
