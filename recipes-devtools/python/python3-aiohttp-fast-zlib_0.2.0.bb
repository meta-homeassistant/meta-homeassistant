SUMMARY = "Use the fastest installed zlib compatible library with aiohttp"
HOMEPAGE = "https://github.com/bdraco/aiohttp-fast-zlib"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9fd9da0eba9bb27343ae47cb3fb6cde8"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "e2e6c27a7ffc825cdd50d6f80e302ebbc025b43c876c00f01dc2ae759905dce8"

inherit pypi python_poetry_core

PYPI_PACKAGE = "aiohttp_fast_zlib"

RDEPENDS:${PN} = "python3-aiohttp (>=3.9.0)"
