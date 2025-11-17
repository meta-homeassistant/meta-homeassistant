SUMMARY = "An async GeoJSON client library for GeoNet NZ Quakes feed."
HOMEPAGE = "https://github.com/exxamalte/python-aio-geojson-geonetnz-quakes"
LICENSE = "Apache"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "690b220a0c2203397460fd84d521208f1656aa6159f5f7857a565d98ae78f735"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} += " \
    python3-aio-geojson-client (>=0.21) \
    python3-aiohttp (>=3.7.4) \
    python3-pytz (>=2019.01) \
"

PYPI_PACKAGE = "aio_geojson_geonetnz_quakes"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
