SUMMARY = "A package to access meteorological data from Environment Canada"
HOMEPAGE = "https://github.com/michaeldavie/env_canada"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=325472f2f583ff2bbcf556c097a378cf"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "31400e4acf2672510400b38a1e6bff33f7b1e2291d30b61a8aad4c0e963c6ac3"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} += "\
	python3-aiohttp (>=3.9.0) \
	python3-geopy (>=2.3.0) \
	python3-imageio (>=2.28.0) \
	python3-lxml (>=5.3.0) \
	python3-numpy (>=1.22.2) \
	python3-pandas (>=2.2.3) \
	python3-pillow (>=10.0.1) \
	python3-dateutil (>=2.9) \
	python3-voluptuous (>=0.15.2) \
"

PYPI_PACKAGE = "env_canada"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
