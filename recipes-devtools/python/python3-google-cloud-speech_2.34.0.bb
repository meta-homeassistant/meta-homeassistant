SUMMARY = "Google Cloud Speech API client library"
HOMEPAGE = "https://github.com/googleapis/google-cloud-python/tree/main/packages/google-cloud-speech"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "2a7bffd84f134b9b70c9f11cbb5088c534f92be149d71d9073d0b9dd3a431acf"

inherit pypi setuptools3 ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-google-api-core (>=1.34.1) \
    python3-google-auth (>=2.14.1 ) \
    python3-grpcio (>=1.32.2) \
    python3-proto-plus (>=1.25.0) \
    python3-protobuf (>=3.20.2) \
"

PYPI_PACKAGE = "google_cloud_speech"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
