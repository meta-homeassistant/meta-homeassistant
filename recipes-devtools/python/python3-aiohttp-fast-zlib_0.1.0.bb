SUMMARY = "Use the fastest installed zlib compatible library with aiohttp"
HOMEPAGE = "https://github.com/bdraco/aiohttp-fast-zlib"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9fd9da0eba9bb27343ae47cb3fb6cde8"

SRC_URI[sha256sum] = "46656935c38b7022fbe524de589c2372f3b8f7ebd2029dc47467c0c4d9a65fdc"

inherit pypi python_poetry_core

PYPI_PACKAGE = "aiohttp_fast_zlib"
RDEPENDS:${PN} = "python3-aiohttp (>=3.9.0)"
