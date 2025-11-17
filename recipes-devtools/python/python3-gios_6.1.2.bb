SUMMARY = "Python wrapper for getting air quality data from GIOŚ servers."
HOMEPAGE = "https://github.com/bieniu/gios"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=294a75dc2aa13b607c79c0a9ac06e800"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "f35ca2769fc9b9adb54fb3d2d93c216ca6333a6d67ee60ebb8dd8c70b72ccc72"

inherit pypi python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} = "\
	python3-aiohttp (>=3.9.4) \
	python3-dacite (>=1.7.0) \
	python3-yarl \
"

RDEPENDS:${PN}-ptest = "\
	python3-aioresponses \
	python3-coverage \
	python3-pytest-asyncio \
	python3-pytest-timeout \
	python3-syrupy \
"

PYPI_PACKAGE = "gios"
