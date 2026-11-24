SUMMARY = "Google Cloud Pub/Sub API client library"
HOMEPAGE = "https://github.com/googleapis/python-pubsub"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "934a3ab7496a6da09cd97d866bef3e47092e904688a66f60750895a7484bd585"

inherit pypi setuptools3 ptest-python-pytest

PACKAGECONFIG ?= "libcst"
PACKAGECONFIG[libcst] = ",,,python3-libcst"

RDEPENDS:${PN} += "\
    python3-google-api-core (>=2.25.0) \
    python3-google-auth (>=2.14.1) \
    python3-grpc-google-iam-v1 (>=0.14.2) \
    python3-grpcio (>=1.75.1) \
    python3-grpcio-status (>=1.75.1) \
    python3-opentelemetry-api (>=1.27.0) \
    python3-opentelemetry-sdk (>=1.27.0) \
    python3-proto-plus (>=1.26.1) \
    python3-protobuf (>=6.33.5) \
"
