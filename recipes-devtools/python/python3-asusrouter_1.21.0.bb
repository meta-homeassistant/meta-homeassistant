SUMMARY = "API wrapper for communication with ASUSWRT-powered routers using HTTP protocol"
HOMEPAGE = "https://github.com/Vaskivskyi/asusrouter"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "bf4c6ecdf572240ab6384786cf243ebaeca7bbda8a9709d7aaa0a00503fa5e7c"

inherit pypi python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} += "\
	python3-aiohttp \
	python3-urllib3 \
	python3-xmltodict \
"

RDEPENDS:${PN}-tests += "\
	python3-pytest-asyncio \
	python3-pytest-cov \
"

PYPI_PACKAGE = "asusrouter"
