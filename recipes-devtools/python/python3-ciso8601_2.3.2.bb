SUMMARY = "Fast ISO8601 date time parser for Python written in C"
HOMEPAGE = "https://github.com/closeio/ciso8601"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=650b6b7ede4fbd14ab012aceb71d69d7"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

inherit pypi setuptools3 ptest-python-pytest

SRC_URI[sha256sum] = "ec1616969aa46c51310b196022e5d3926f8d3fa52b80ec17f6b4133623bd5434"

RDEPENDS:${PN} = "\
    python3-pytz \
"
