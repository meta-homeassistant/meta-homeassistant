DESCRIPTION = "Low-level, data-driven core of boto 3."
HOMEPAGE = "https://github.com/boto/botocore"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=2ee41112a44fe7014dce33e26468ba93"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "7fe00007304fe4627d7dd7b8605c6666a560651e91100f47391ae40a310dc092"

inherit pypi setuptools3 ptest-python-pytest

RDEPENDS:${PN} = "\
    python3-dateutil (>=2.1) \
    python3-jmespath (>=0.7.1) \
    python3-urllib3 (>=1.25.4) \
"

RDEPENDS:${PN}-ptest += "\
    python3-pytest-xdist \
"
