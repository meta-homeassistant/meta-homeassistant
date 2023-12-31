SUMMARY = "A fast version of fnv1a"
HOMEPAGE = "https://github.com/bdraco/fnv-hash-fast"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fb4df16459d09819e161c1b17625a532"

inherit pypi python_poetry_core

PYPI_PACKAGE = "fnv_hash_fast"

DEPENDS += "\
    ${PYTHON_PN}-cython-native \
"

SRC_URI[sha256sum] = "a84d658952776a186418f4158fc8e55ff3c576ac32cc9ef7f8077efdf2d0b89f"

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-fnvhash (>=0.1.0) \
"