SUMMARY = "A fast version of fnv1a"
HOMEPAGE = "https://github.com/bdraco/fnv-hash-fast"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fb4df16459d09819e161c1b17625a532"

inherit pypi setuptools3

PYPI_PACKAGE = "fnv_hash_fast"

SRC_URI[sha256sum] = "34ddc8ceb87b2f707f515e8e6f4466fceb780e1f1c3d28754d8d6611ae064a5a"

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-fnvhash (>=0.1.0) \
"