SUMMARY = "A Python client library for A. O. Smith water heaters"
HOMEPAGE = "https://github.com/bdr99/py-aosmith"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=8afcf31bd10bbe304f13798fbb1feb3b"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "4faa3ace10a588312d30d40e0b44dbf9be05bdc9c8d2c8f9960c65735a29c727"

inherit pypi python_poetry_core

PYPI_PACKAGE = "py_aosmith"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"

RDEPENDS:${PN} = "\
    python3-aiohttp (>= 3.8.6) \
    python3-tenacity (>=8.2.3) \
"
