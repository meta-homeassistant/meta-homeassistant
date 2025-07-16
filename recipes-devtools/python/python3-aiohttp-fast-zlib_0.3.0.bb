SUMMARY = "Use the fastest installed zlib compatible library with aiohttp"
HOMEPAGE = "https://github.com/bdraco/aiohttp-fast-zlib"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9fd9da0eba9bb27343ae47cb3fb6cde8"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "963a09de571b67fa0ef9cb44c5a32ede5cb1a51bc79fc21181b1cddd56b58b28"

inherit pypi python_poetry_core

PYPI_PACKAGE = "aiohttp_fast_zlib"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"

RDEPENDS:${PN} = "python3-aiohttp (>=3.9.0)"
