SUMMARY = "Python API for Canary Security Camera"
HOMEPAGE = "https://github.com/snjoetw/py-canary"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=61764be905fd8aa5707070c78f0aa894"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "4a1411613ad42fdd307308726ad1ca237c97ce49ede2af1c95efaea85a51bf50"

inherit pypi python_setuptools_build_meta ptest-python-pytest

PYPI_PACKAGE = "py_canary"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
