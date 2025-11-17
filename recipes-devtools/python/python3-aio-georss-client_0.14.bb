SUMMARY = "An async GeoRSS client library."
HOMEPAGE = "https://github.com/exxamalte/python-aio-georss-client"
LICENSE = "Apache"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "c73956e78afb98ccc4cd99945dd7bf6c8c3ab1510b278d6df26574fa2240d675"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} += " \
    python3-aiohttp (>= 3.7.4) \
    python3-haversine (>= 2.8.1) \
    python3-xmltodict (>= 0.14.1) \
    python3-dateutil (>= 2.9.0) \
"

PYPI_PACKAGE = "aio_georss_client"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
