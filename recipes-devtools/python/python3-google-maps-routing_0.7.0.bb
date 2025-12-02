SUMMARY = "Google Maps Routing API client library"
HOMEPAGE = "https://github.com/googleapis/google-cloud-python/tree/main/packages/google-maps-routing"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "ab70c7508104ab0a6cedc011aa8446ec05f1c580b960e8f8c285adf992b1cfcf"

inherit pypi setuptools3 ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-google-api-core (>=1.34.1) \
    python3-google-auth (>=2.14.1) \
    python3-google-geo-type (>=0.1.0) \
    python3-grpcio (>=1.33.2) \
    python3-proto-plus (>=1.25.0) \
    python3-protobuf (>=3.20.2) \
"

PYPI_PACKAGE = "google_maps_routing"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
