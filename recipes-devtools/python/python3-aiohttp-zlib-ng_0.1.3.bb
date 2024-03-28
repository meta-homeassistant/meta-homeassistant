SUMMARY = "Enable zlib_ng on aiohttp"
HOMEPAGE = "https://github.com/bdraco/aiohttp-zlib-ng"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=da57f3e0372e39698a274746eb9d65d6"

SRC_URI[sha256sum] = "2aafeb911de5075b1374736c7830b5d203988937d25b015e89c22390f4a6856a"

inherit pypi python_poetry_core

PYPI_PACKAGE = "aiohttp_zlib_ng"

RDEPENDS:${PN} = "\
	python3-core (>= 3.8) \
	python3-aiohttp (>= 3.8.5) \
	python3-zlib-ng (>= 0.3.0) \
"
