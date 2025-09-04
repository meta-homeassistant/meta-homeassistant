SUMMARY = "jsonpickle encodes/decodes any Python object to/from JSON"
HOMEPAGE = "https://jsonpickle.readthedocs.io/"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c9706350b6b0ee6b429bf3c10e2172fd"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "f86e18f13e2b96c1c1eede0b7b90095bbb61d99fedc14813c44dc2f361dbbae1"

inherit pypi python_setuptools_build_meta ptest-python-pytest

DEPENDS += "python3-setuptools-scm-native"

PYPI_PACKAGE = "jsonpickle"
