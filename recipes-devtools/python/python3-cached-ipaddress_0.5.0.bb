SUMMARY = "Cache construction of ipaddress objects"
HOMEPAGE = "https://github.com/bdraco/cached-ipaddress"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fb4df16459d09819e161c1b17625a532"

SRC_URI[sha256sum] = "dc7a6d0818627109b2dc46c84b54f66989d446f0f52e65e55bf93919aacefc60"

inherit pypi python_poetry_core

DEPENDS += "\
    python3-cython-native \
"

RDEPENDS:${PN} = "\
    python3-core (>=3.7) \
"

PYPI_PACKAGE = "cached_ipaddress"
