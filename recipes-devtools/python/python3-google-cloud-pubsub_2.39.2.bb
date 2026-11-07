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
    python3-google-api-core \
    python3-google-auth \
    python3-grpc-google-iam-v1 \
    python3-grpcio \
    python3-grpcio-status \
    python3-opentelemetry-api \
    python3-opentelemetry-sdk \
    python3-proto-plus \
    python3-protobuf \
"
