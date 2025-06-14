SUMMARY = "A faster URL dispatcher for aiohttp"
HOMEPAGE = "https://github.com/bdraco/aiohttp-fast-url-dispatcher"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=da57f3e0372e39698a274746eb9d65d6"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"

SRC_URI[sha256sum] = "5a730a3872503ee5c94c65c6dee2a17b4773e022630f2557cae84f2e74ea26ed"

inherit pypi python_poetry_core

PYPI_PACKAGE = "aiohttp_fast_url_dispatcher"

RDEPENDS:${PN} = "\
	python3-core (>=3.8) \
	python3-aiohttp (>= 3.8.5) \
"
