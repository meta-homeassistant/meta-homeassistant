SUMMARY = "A fast version of fnv1a"
HOMEPAGE = "https://github.com/bdraco/fnv-hash-fast"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fb4df16459d09819e161c1b17625a532"

inherit pypi setuptools3

PYPI_PACKAGE = "fnv_hash_fast"

SRC_URI[sha256sum] = "fb513e4b43d5b48cf358422688e950dec22b681cffb6c7a80c062199667f0fa6"

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-fnvhash (>=0.1.0) \
"