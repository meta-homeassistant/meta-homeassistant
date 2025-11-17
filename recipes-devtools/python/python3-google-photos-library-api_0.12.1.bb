SUMMARY = "A python client library for Google Photos Library API"
HOMEPAGE = "https://github.com/allenporter/python-google-photos-library-api"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "bcbf8b5478e698939df0990045e31c02148fd462056f3e8c22590fa032217ae8"

inherit pypi setuptools3 ptest-python-pytest

RDEPENDS:${PN} += "python3-aiohttp python3-google-api-python-client python3-google-auth python3-mashumaro"

PYPI_PACKAGE = "google_photos_library_api"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
