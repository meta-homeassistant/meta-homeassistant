SUMMARY = "An async GeoJSON client library for GeoNet NZ Volcanic Alert Level feed."
HOMEPAGE = "https://github.com/exxamalte/python-aio-geojson-geonetnz-volcano"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "d609abcad18113e3050c1684129d3d93a40102289ac083dc6f3462906db8ac04"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} += " \
    python3-aio-geojson-client (>=0.21) \
    python3-aiohttp (>=3.7.4) \
    python3-pytz (>=2019.01) \
"

PYPI_PACKAGE = "aio_geojson_geonetnz_volcano"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
