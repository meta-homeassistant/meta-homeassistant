SUMMARY = "Pytest `client` fixture for the Aiohttp"
HOMEPAGE = "https://github.com/sivakov512/pytest-aiohttp-client"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9875e3f5320de104d30536a92248a823"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "ae2dad8e3db052b3fd0296ce8d542d7f04a911f23f2d82f2777021815e88a708"

inherit pypi python_poetry_core

PYPI_PACKAGE = "pytest_aiohttp_client"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
RDEPENDS:${PN} = "python3-aiohttp python3-pytest"
