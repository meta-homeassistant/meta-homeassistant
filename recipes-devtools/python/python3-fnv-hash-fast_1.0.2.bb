SUMMARY = "A fast version of fnv1a"
HOMEPAGE = "https://github.com/bdraco/fnv-hash-fast"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fb4df16459d09819e161c1b17625a532"

inherit pypi python_poetry_core

PYPI_PACKAGE = "fnv_hash_fast"

DEPENDS += "\
    python3-cython-native \
"

SRC_URI[sha256sum] = "d4c528bfb0daa751afb17419a244b913b094b9f0634f9bd19aeffcdc60192589"

RDEPENDS:${PN} = "\
    python3-core (>=3.10) \
    python3-fnvhash (>=0.1.0) \
"