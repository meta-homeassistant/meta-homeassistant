SUMMARY = "A GeoRSS client library."
HOMEPAGE = "https://github.com/exxamalte/python-georss-client"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "71ddd88fabe7a4ea08835fa0a27dc6f36c5daa9713c62bdb36540fc3cd6a2a81"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} = "\
    python3-haversine (>=2.8.1) \
    python3-xmltodict (>=0.14.2) \
    python3-requests (>=2.31.0) \
    python3-dateutil (>=2.9.0) \
"

PYPI_PACKAGE = "georss_client"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
