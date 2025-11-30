SUMMARY = "An async GeoRSS client library for GDACS feeds."
HOMEPAGE = "https://github.com/exxamalte/python-aio-georss-gdacs"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "de54afbd02250690f6565f229340d93a3a869929fea5fb4b2e121d0076b555f8"

DEPENDS = "python3-aio-georss-client-native"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-dateutil (>=2.9.0) \
    python3-aio-georss-client \
"

PYPI_PACKAGE = "aio_georss_gdacs"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
