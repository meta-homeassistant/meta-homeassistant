SUMMARY = "A python library for syncing Google Calendar to local storage"
HOMEPAGE = "https://github.com/allenporter/gcal_sync"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "e9b5fdf723bdc3e01ccd2895760e2dbc89eb70ac71032be45df2da94c9acf169"

inherit pypi python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} += "\
	python3-aiohttp (>=3.8.1) \
	python3-ical (>=11.0.0) \
	python3-pydantic (>=2.10.4) \
"

PYPI_PACKAGE = "gcal_sync"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
