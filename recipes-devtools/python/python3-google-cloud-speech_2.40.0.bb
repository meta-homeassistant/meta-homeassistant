SUMMARY = "Google Cloud Speech API client library"
HOMEPAGE = "https://github.com/googleapis/google-cloud-python/tree/main/packages/google-cloud-speech"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "e89e688e4ce0b926754038bf992d0d0f065c5f1c3503bb20e6c46d08b63658fc"

inherit pypi setuptools3 ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-google-api-core (>=1.34.1) \
    python3-google-auth (>=2.14.1 ) \
    python3-grpcio (>=1.32.2) \
    python3-proto-plus (>=1.25.0) \
    python3-protobuf (>=3.20.2) \
"
