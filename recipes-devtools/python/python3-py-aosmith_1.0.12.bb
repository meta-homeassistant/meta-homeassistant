SUMMARY = "A Python client library for A. O. Smith water heaters"
HOMEPAGE = "https://github.com/bdr99/py-aosmith"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=65744ee4d9adac9b8a8268d42e566db2"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "50d6322a2c28fef6378b0fccf5ba7b3a75a75a5657fa3c3f569d3b120bb49ae3"

inherit pypi python_poetry_core

PYPI_PACKAGE = "py_aosmith"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"

RDEPENDS:${PN} = "\
    python3-aiohttp (>= 3.8.6) \
    python3-tenacity (>=8.2.3) \
"
