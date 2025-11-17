SUMMARY = "A GeoRSS generic client library."
HOMEPAGE = "https://github.com/exxamalte/python-georss-generic-client"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "b1685d13ab86727b094ce5fd737f48f925b4b16d309bff51b0f1df3d64b61f52"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-georss-client (>=0.17)"

PYPI_PACKAGE = "georss_generic_client"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
