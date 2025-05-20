SUMMARY = "An asyncio-native library for requesting data from a Ruuvi Gateway"
HOMEPAGE = "https://github.com/akx/aioruuvigateway"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=76eb4b6ffa7ac1bd7ebfa0cf0f8f7013"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "8c98368a04e14e563440489a28fa1c11f07b4d75fcb092aa1eb91f53a40bd0f8"

inherit pypi python_hatchling ptest-python-pytest

RDEPENDS:${PN} = "\
	python3-bluetooth-data-tools (>=0.3.1) \
	python3-httpx (>=0.23.0) \
"

RDEPENDS:${PN}-ptest += "\
    python3-pytest-asyncio \
	python3-pytest-httpx \
"

PYPI_PACKAGE = "aioruuvigateway"
