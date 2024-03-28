SUMMARY = "Cache construction of ipaddress objects"
HOMEPAGE = "https://github.com/bdraco/cached-ipaddress"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fb4df16459d09819e161c1b17625a532"

SRC_URI[sha256sum] = "5340b609c701a122394a937abef67f130d025f63b25f2523b929944c069c8063"

inherit pypi python_poetry_core

DEPENDS += "\
    python3-cython-native \
"

RDEPENDS:${PN} = "\
    python3-core (>=3.7) \
"

PYPI_PACKAGE = "cached_ipaddress"
