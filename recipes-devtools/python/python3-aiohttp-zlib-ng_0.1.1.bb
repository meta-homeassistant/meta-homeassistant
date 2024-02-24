SUMMARY = "Enable zlib_ng on aiohttp"
HOMEPAGE = "https://github.com/bdraco/aiohttp-zlib-ng"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=da57f3e0372e39698a274746eb9d65d6"

SRC_URI[sha256sum] = "8f3a9a9b4e8bfa9c3cfa7fb619b1268d6e986a66e452de067a81017717bb6962"

inherit pypi python_poetry_core

PYPI_PACKAGE = "aiohttp_zlib_ng"

RDEPENDS:${PN} = "\
	python3-core (>= 3.8) \
	python3-aiohttp (>= 3.8.5) \
	python3-zlib-ng (>= 0.3.0) \
"
