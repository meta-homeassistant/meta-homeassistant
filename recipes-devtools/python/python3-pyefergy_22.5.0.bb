SUMMARY = "An API library for Efergy energy meters."
HOMEPAGE = "https://github.com/tkdrob/pyefergy"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=0338558b94725bcf59c0a13d4d0de34e"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "1ca1146bb2f34227e6faaae402bda5bf0ee414e49f7549be624d40b999f78c51"

DEPENDS = "python3-poetry-dynamic-versioning-native"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} += "\
	python3-aiohttp (>=3.6.1) \
	python3-codecov \
	python3-iso4217 (>=1.2.20150619) \
	python3-types-pytz \
"

PYPI_PACKAGE = "pyefergy"
