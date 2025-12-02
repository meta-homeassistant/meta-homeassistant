SUMMARY = "Python API for interacting with Glances"
HOMEPAGE = "https://github.com/home-assistant-ecosystem/python-glances-api"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c28df4fea0c118f667842f3214710df8"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "2018bd9ba8377f5894e48376b67f99b3d7a766870df9f8ce96c10b3feef1cf24"

inherit pypi python_poetry_core

RDEPENDS:${PN} = "\
    python3-httpx (>=0.23) \
"

PYPI_PACKAGE = "glances_api"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
