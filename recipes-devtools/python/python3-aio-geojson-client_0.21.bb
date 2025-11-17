SUMMARY = "An async GeoJSON client library."
HOMEPAGE = "https://github.com/exxamalte/python-aio-geojson-client"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "c92b6b0f6226ba793eeda6f56ea1a21eaaf8a5bfb81227c1418e4f1b0be7b3eb"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} += " \
    python3-aiohttp (>=3.7.4) \
    python3-geojson (>=3.1.0) \
    python3-haversine (>=2.8.1) \
"

PYPI_PACKAGE = "aio_geojson_client"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
