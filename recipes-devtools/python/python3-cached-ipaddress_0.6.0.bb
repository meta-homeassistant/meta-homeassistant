SUMMARY = "Cache construction of ipaddress objects"
HOMEPAGE = "https://github.com/bdraco/cached-ipaddress"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fb4df16459d09819e161c1b17625a532"

SRC_URI[sha256sum] = "9c88884ac73729fc720aca7a7a1c6ba3a4f06b357a6b50c18abfbee94b84c1f3"

inherit pypi python_poetry_core

DEPENDS += "\
    python3-cython-native \
"

RDEPENDS:${PN} = "\
    python3-core (>=3.7) \
"

PYPI_PACKAGE = "cached_ipaddress"
