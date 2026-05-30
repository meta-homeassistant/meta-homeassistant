SUMMARY = "Python wrapper for getting air quality data from GIOŚ servers."
HOMEPAGE = "https://github.com/bieniu/gios"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=294a75dc2aa13b607c79c0a9ac06e800"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI = "git://github.com/bieniu/gios;protocol=https;tag=${PV};branch=master"
SRCREV = "6b9bfd7a4721c334407e2b0d73db5ba70ac6f2f4"

inherit python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} = "\
	python3-aiohttp (>=3.9.4) \
	python3-dacite (>=1.7.0) \
	python3-yarl \
"

RDEPENDS:${PN}-ptest:append = "\
	python3-aioresponses \
	python3-coverage \
	python3-pytest-asyncio \
	python3-pytest-timeout \
	python3-syrupy \
"

PYPI_PACKAGE = "gios"
