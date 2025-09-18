SUMMARY = "Ubiquiti airOS module(s) for Python 3."
HOMEPAGE = "https://github.com/compatech/python-airos"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b6ad717ddaae2251044bbbb7bd265b2a"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "4fb9ae32b85eac9b964fecb5ea6a5c87ecf8427f3a32e05d05e7286be1e4a9de"

inherit pypi python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} += "\
	python3-aiohttp (>=3.8.0) \
	python3-mashumaro (>=3.14.0) \
"

PYPI_PACKAGE = "airos"
