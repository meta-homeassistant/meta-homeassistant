SUMMARY = "A fast version of fnv1a"
HOMEPAGE = "https://github.com/bdraco/fnv-hash-fast"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fb4df16459d09819e161c1b17625a532"

inherit pypi setuptools3

PYPI_PACKAGE = "fnv_hash_fast"

SRC_URI[sha256sum] = "f8627166b781d2062b4a91cea14036170e778de548e5de0559f4e79cf5176f3d"

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-fnvhash (>=0.1.0) \
"