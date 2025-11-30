SUMMARY = "URL normalization for Python"
HOMEPAGE = "https://github.com/niksite/url-normalize"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=0355248f9f4025eb234b21ac43b9ad7a"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "74a540a3b6eba1d95bdc610c24f2c0141639f3ba903501e61a52a8730247ff37"

inherit pypi python_poetry_core

RDEPENDS:${PN} += "\
    python3-core (>=3.6) \
    python3-six \
"

PYPI_PACKAGE = "url_normalize"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
