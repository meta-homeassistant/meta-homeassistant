SUMMARY = "An generic async GeoJSON client library."
HOMEPAGE = "https://github.com/exxamalte/python-aio-geojson-generic-client"
LICENSE = "Apache"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "2b6f999e99a3181d2dcf52e8a3a63a38203a8e282b5ab5875ab8a7d93b62d4a0"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} += " \
    python3-aio-geojson-client (>=0.21) \
    python3-aiohttp (>=3.7.4) \
    python3-geojson (>=3.1.0) \
    python3-pytz (>=2019.01) \
"

PYPI_PACKAGE = "aio_geojson_generic_client"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
