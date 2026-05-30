SUMMARY = "A package to access meteorological data from Environment Canada"
HOMEPAGE = "https://github.com/michaeldavie/env_canada"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=325472f2f583ff2bbcf556c097a378cf"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "b87f2ce03682acb7e16f31ca444988d7e328691f5cb8ccba8674fddb2cdaa18f"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} += "\
	python3-aiohttp (>=3.9.0) \
	python3-geopy (>=2.3.0) \
	python3-lxml (>=5.3.0) \
	python3-pandas (>=2.2.3) \
	python3-pillow (>=10.0.1) \
	python3-dateutil (>=2.9) \
	python3-voluptuous (>=0.15.2) \
"

PYPI_PACKAGE = "env_canada"
