SUMMARY = "Async client for aws services using botocore and aiohttp"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=55150c668a8c5a6b580ae9a69ae2d8cd"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "a59f2a78629b97d52f10936b79c73de64e481a8c44a62c1871f088df6c1afc4f"

inherit pypi python_setuptools_build_meta ptest-python-pytest

PYPI_PACKAGE = "aiobotocore"

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.9.2) \
    python3-aioitertools (>=0.5.1) \
    python3-botocore (>=1.38.40) \
    python3-dateutil (>=2.1) \
    python3-jmespath (>=0.7.1) \
    python3-multidict (>=6.0.0) \
    python3-wrapt (>=1.10.10) \
"
