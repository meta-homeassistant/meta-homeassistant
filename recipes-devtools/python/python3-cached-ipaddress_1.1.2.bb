SUMMARY = "Cache construction of ipaddress objects"
HOMEPAGE = "https://github.com/bdraco/cached-ipaddress"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fb4df16459d09819e161c1b17625a532"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "232f62f768a2531e3d64e661eb2e484b52954ceb8d2b04ad0d2317f52ce25108"

inherit pypi python_poetry_core cython

RDEPENDS:${PN} = "\
    python3-core (>=3.7) \
    python3-propcache (>=0.0.0) \
"
