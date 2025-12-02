SUMMARY = "Status proto mapping for gRPC"
HOMEPAGE = "https://grpc.io"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=731e401b36f8077ae0c134b59be5c906"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "25fcbfec74c15d1a1cb5da3fab8ee9672852dc16a5a9eeb5baf7d7a9952943cd"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-googleapis-common-protos (>=1.5.5) \
    python3-grpcio \
    python3-protobuf (>=6.31.1) \
"

PYPI_PACKAGE = "grpcio_status"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
