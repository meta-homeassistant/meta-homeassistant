SUMMARY = "Pure-Python gRPC implementation for asyncio"
HOMEPAGE = "https://github.com/vmagamedov/grpclib"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=f0dcea633ed7536bcb36a72e2143d36a"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "d8823763780ef94fed8b2c562f7485cf0bbee15fc7d065a640673667f7719c9a"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "grpclib"
