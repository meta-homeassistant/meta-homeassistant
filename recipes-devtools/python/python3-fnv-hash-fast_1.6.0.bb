SUMMARY = "A fast version of fnv1a"
HOMEPAGE = "https://github.com/bdraco/fnv-hash-fast"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fb4df16459d09819e161c1b17625a532"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

inherit pypi python_poetry_core cython

PYPI_PACKAGE = "fnv_hash_fast"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"

SRC_URI[sha256sum] = "a09feefad2c827192dc4306826df3ffb7c6288f25ab7976d4588fdae9cbb7661"

RDEPENDS:${PN} = "\
    python3-core (>=3.10) \
    python3-fnvhash (>=0.1.0) \
"