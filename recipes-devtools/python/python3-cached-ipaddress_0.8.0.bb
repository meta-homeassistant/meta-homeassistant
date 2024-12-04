SUMMARY = "Cache construction of ipaddress objects"
HOMEPAGE = "https://github.com/bdraco/cached-ipaddress"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fb4df16459d09819e161c1b17625a532"

SRC_URI[sha256sum] = "65037b86959f20fd6505b8ecdbd9cb79c79fb0abc8d3a65c59125aa8d68e9c9b"

inherit pypi python_poetry_core cython

RDEPENDS:${PN} = "\
    python3-core (>=3.7) \
    python3-propcache (>=0.0.0) \
"

PYPI_PACKAGE = "cached_ipaddress"
