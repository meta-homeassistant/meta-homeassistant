SUMMARY = "Universal feed parser, handles RSS 0.9x, RSS 1.0, RSS 2.0, CDF, Atom 0.3, and Atom 1.0 feeds"
HOMEPAGE = "https://github.com/kurtmckee/feedparser"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1b8df8e9646d66df8f19d9b646bd1270"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "64f76ce90ae3e8ef5d1ede0f8d3b50ce26bcce71dd8ae5e82b1cd2d4a5f94228"

inherit pypi setuptools3 ptest-python-pytest

RDEPENDS:${PN} += "python3-sgmllib3k"

PYPI_PACKAGE = "feedparser"
