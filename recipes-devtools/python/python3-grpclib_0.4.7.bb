SUMMARY = "Pure-Python gRPC implementation for asyncio"
HOMEPAGE = "https://github.com/vmagamedov/grpclib"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=f0dcea633ed7536bcb36a72e2143d36a"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "2988ef57c02b22b7a2e8e961792c41ccf97efc2ace91ae7a5b0de03c363823c3"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "grpclib"
