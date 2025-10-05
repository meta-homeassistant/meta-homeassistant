SUMMARY = "Python 3 API wrapper for FireServiceRota/BrandweerRooster"
HOMEPAGE = "https://github.com/cyberjunky/python-fireservicerota"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1d53d81d40ca96bbd7e7a69c4fd58843"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "59d787f66181cd759cc30cee7b11f8833f420f54cc12539f6a05c7b189611e4d"

DEPENDS = "python3-pdm-backend-native"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} = "\
	python3-pytz \
	python3-oauthlib \
	python3-requests \
	python3-websocket-client \
"

PYPI_PACKAGE = "pyfireservicerota"
