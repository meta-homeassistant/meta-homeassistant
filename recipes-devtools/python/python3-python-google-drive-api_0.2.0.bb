SUMMARY = "A python client library for Google Drive API"
HOMEPAGE = "https://github.com/tronikos/python-google-drive-api"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "e4d9bde1d9dab9fe1e45db09ba59e4e56d7fc0d0652d0713c70cf540efb42547"

inherit pypi python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.8) \
    python3-mashumaro (>=3.12) \
"
