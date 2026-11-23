SUMMARY = "Google Cloud Texttospeech API client library"
HOMEPAGE = "https://github.com/googleapis/google-cloud-python/tree/main/packages/google-cloud-texttospeech"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "db726382f393ceb6b36002c35abd62b53c4d8e17fc2f31df8b07fd0fabbe4f8b"

inherit pypi setuptools3 ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-google-api-core (>=2.17.1) \
    python3-google-auth (>=2.14.1 ) \
    python3-grpcio (>=1.75.1) \
    python3-proto-plus (>=1.25.0) \
    python3-protobuf (>=4.25.8) \
"
