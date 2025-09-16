SUMMARY = "Python library for communicating with deCONZ REST-API"
HOMEPAGE = "https://github.com/Kane610/deconz"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e4c00cdf90740d5e65a081a60c093ae4"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI += "file://0001-relax-build-req.patch"
SRC_URI[sha256sum] = "bb6cdcb1c92a5b30b809b7a2b538986ea81e70e3828918c4bcf0bb50e2ecb0e6"

inherit pypi python_setuptools_build_meta ptest-python-pytest

PYPI_PACKAGE = "pydeconz"
RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.11.14) \
    python3-orjson (>=3.10.15) \
"
