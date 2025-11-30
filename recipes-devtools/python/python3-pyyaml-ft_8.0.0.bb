SUMMARY = "YAML parser and emitter for Python with support for free-threading"
HOMEPAGE = "https://github.com/Quansight-Labs/pyyaml-ft/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6d8242660a8371add5fe547adf083079"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "0c947dce03954c7b5d38869ed4878b2e6ff1d44b08a0d84dc83fdad205ae39ab"

inherit pypi python_setuptools_build_meta ptest-python-pytest cython

PYPI_PACKAGE = "pyyaml_ft"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
