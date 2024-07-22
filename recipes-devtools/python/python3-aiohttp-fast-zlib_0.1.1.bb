SUMMARY = "Use the fastest installed zlib compatible library with aiohttp"
HOMEPAGE = "https://github.com/bdraco/aiohttp-fast-zlib"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9fd9da0eba9bb27343ae47cb3fb6cde8"

SRC_URI[sha256sum] = "085dd826523137487fb41fd262dcc9fdc5f53ea988fa449f9ef703d939f01e9f"

inherit pypi python_poetry_core

PYPI_PACKAGE = "aiohttp_fast_zlib"

RDEPENDS:${PN} = "python3-aiohttp (>=3.9.0)"
