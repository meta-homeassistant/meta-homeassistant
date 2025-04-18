SUMMARY = "A fast version of fnv1a"
HOMEPAGE = "https://github.com/bdraco/fnv-hash-fast"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fb4df16459d09819e161c1b17625a532"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

inherit pypi python_poetry_core cython

PYPI_PACKAGE = "fnv_hash_fast"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"

SRC_URI[sha256sum] = "12a2a437263f08815bd2d5759c12e881408718bb82cfffceb0341575f2c43f0a"

RDEPENDS:${PN} = "\
    python3-core (>=3.10) \
    python3-fnvhash (>=0.1.0) \
"