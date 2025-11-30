SUMMARY = "Beautiful, Pythonic protocol buffers"
HOMEPAGE = "https://github.com/googleapis/proto-plus-python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "21a515a4c4c0088a773899e23c7bbade3d18f9c66c73edd4c7ee3816bc96a012"

inherit pypi python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-protobuf (>=3.19.0) \
"

PYPI_PACKAGE = "proto_plus"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
