SUMMARY = "IAM API client library"
HOMEPAGE = "https://github.com/googleapis/google-cloud-python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "879ac4ef33136c5491a6300e27575a9ec760f6cdf9a2518798c1b8977a5dc389"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} += "\
    python3-grpcio (>=1.44.0) \
    python3-googleapis-common-protos (>=1.56.0) \
    python3-protobuf (>=3.20.2) \
"

PYPI_PACKAGE = "grpc_google_iam_v1"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
