SUMMARY = "A fast version of fnv1a"
HOMEPAGE = "https://github.com/bdraco/fnv-hash-fast"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fb4df16459d09819e161c1b17625a532"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

inherit pypi python_poetry_core cython

PYPI_PACKAGE = "fnv_hash_fast"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"

SRC_URI[sha256sum] = "d4c528bfb0daa751afb17419a244b913b094b9f0634f9bd19aeffcdc60192589"

RDEPENDS:${PN} = "\
    python3-core (>=3.10) \
    python3-fnvhash (>=0.1.0) \
"