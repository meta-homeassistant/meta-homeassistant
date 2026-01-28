SUMMARY = "API wrapper for communication with ASUSWRT-powered routers using HTTP protocol"
HOMEPAGE = "https://github.com/Vaskivskyi/asusrouter"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "bf4c6ecdf572240ab6384786cf243ebaeca7bbda8a9709d7aaa0a00503fa5e7c"
SRC_URI = "git://github.com/Vaskivskyi/asusrouter;protocol=https;tag=${PV};branch=main-legacy"

inherit python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} += "\
	python3-aiohttp \
	python3-urllib3 \
	python3-xmltodict \
"

RDEPENDS:${PN}-ptest += "\
	python3-pytest-asyncio \
	python3-pytest-cov \
	python3-tests \
"
