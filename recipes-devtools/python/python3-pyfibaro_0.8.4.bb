SUMMARY = "Simple API to access fibaro home center from any Python 3 script. Designed for Home Assistant (but not only)"
HOMEPAGE = "https://github.com/rappenze/pyfibaro"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3926fb84508447a7bc95790bfaf0a38d"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "6aa8ebbbbf6d36421425f03ef99528b725e6a7079e4cbd4d9c0131a1aca06bee"

inherit pypi python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} = "\
    python3-requests (>=2.32) \
"
