SUMMARY = "Python wrapper for getting air quality data from GIOŚ servers."
HOMEPAGE = "https://github.com/bieniu/gios"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1e506a4eaa03b7d260c571595271a50f"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI = "git://github.com/bieniu/gios;protocol=https;tag=${PV};branch=master \
           file://0001-tests-update-snapshots-for-syrupy-6.patch \
           "
SRCREV = "f4697ce6aceb1b47c44124f6021dc90b192289ed"

inherit python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} = "\
	python3-aiohttp (>=3.14.1) \
	python3-dacite (>=1.7.0) \
	python3-yarl \
"

RDEPENDS:${PN}-ptest:append = " \
	python3-aiointercept \
	python3-aioresponses \
	python3-coverage \
	python3-pytest-asyncio \
	python3-pytest-timeout \
	python3-syrupy \
"
