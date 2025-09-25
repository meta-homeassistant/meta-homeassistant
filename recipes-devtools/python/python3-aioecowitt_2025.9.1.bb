SUMMARY = "Python wrapper for EcoWitt Protocol"
HOMEPAGE = "https://github.com/home-assistant-libs/aioecowitt"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8a701d4d0c5ad6a64c5706b3e7b649f4"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "c0b0b105e1f6b1401a9d4c36cb0617f2a4630e3caedb782f2faae9ca0a80a249"

inherit pypi python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} += "\
	python3-aiohttp (>=3) \
	python3-meteocalc (>=1.1.0) \
"

PYPI_PACKAGE = "aioecowitt"
