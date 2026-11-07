SUMMARY = "API wrapper for communication with ASUSWRT-powered routers using HTTP protocol"
HOMEPAGE = "https://github.com/Vaskivskyi/asusrouter"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI = "git://github.com/Vaskivskyi/asusrouter;protocol=https;tag=${PV};branch=main \
           file://0001-relax-build-requirement.patch \
           "
SRCREV = "8de97bfa8ffe3efa2f6d1ec30bb95187d13ab37a"

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
