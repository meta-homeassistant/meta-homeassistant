SUMMARY = "Google Geo Type API client library"
HOMEPAGE = "https://github.com/googleapis/google-cloud-python/tree/main/packages/google-geo-type"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "f5151931d0d1249bc035a4050674c5a0e56396e5150fe25c12fa0112163f6765"

inherit pypi setuptools3 ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-google-api-core (>=1.34.1) \
    python3-google-auth (>=2.14.1) \
    python3-grpcio (>=1.33.2) \
    python3-proto-plus (>=1.25.0) \
    python3-protobuf (>=3.20.0) \
"

PYPI_PACKAGE = "google_geo_type"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
