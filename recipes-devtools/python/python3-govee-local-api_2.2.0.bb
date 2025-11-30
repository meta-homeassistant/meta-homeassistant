SUMMARY = "Library to communicate with Govee local API"
HOMEPAGE = "https://github.com/Galorhallen/govee-local-api"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "842f39e7b50ac6f44ca979202953bcd8cc350d2744daeba996b267ca5a3a7cdd"

inherit pypi python_poetry_core

PYPI_PACKAGE = "govee_local_api"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
