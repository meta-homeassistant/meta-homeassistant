SUMMARY = "A python client library for Google Drive API"
HOMEPAGE = "https://github.com/tronikos/python-google-drive-api"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "799ed1febdbcc7333f3e7c7d04084b96bf32ac4df0a3b156ae4c797517914251"

inherit pypi python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.8) \
    python3-mashumaro (>=3.12) \
"

PYPI_PACKAGE = "python_google_drive_api"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
