SUMMARY = "Fast ISO8601 date time parser for Python written in C"
HOMEPAGE = "https://github.com/closeio/ciso8601"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=650b6b7ede4fbd14ab012aceb71d69d7"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

inherit pypi setuptools3 ptest-python-pytest

SRC_URI[sha256sum] = "db5d78d9fb0de8686fbad1c1c2d168ed52efb6e8bf8774ae26226e5034a46dae"

RDEPENDS:${PN} = "\
    python3-pytz \
"
