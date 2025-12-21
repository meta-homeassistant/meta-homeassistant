SUMMARY = "Cache construction of ipaddress objects"
HOMEPAGE = "https://github.com/bdraco/cached-ipaddress"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fb4df16459d09819e161c1b17625a532"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "75cc3b782fc5e52bea27ff51f736ccbeabcee187de02c53a092a1b44be7dae3e"

inherit pypi python_poetry_core cython

RDEPENDS:${PN} = "\
    python3-core (>=3.7) \
    python3-propcache (>=0.0.0) \
"

PYPI_PACKAGE = "cached_ipaddress"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
