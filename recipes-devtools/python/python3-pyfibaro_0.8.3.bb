SUMMARY = "Simple API to access fibaro home center from any Python 3 script. Designed for Home Assistant (but not only)"
HOMEPAGE = "https://github.com/rappenze/pyfibaro"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3926fb84508447a7bc95790bfaf0a38d"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "ceb97e922434086bc12709f32b9633cba612da71ac051dd2d00dcab43e9a41bd"

inherit pypi python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} = "\
    python3-requests (>=2.32) \
"

PYPI_PACKAGE = "pyfibaro"
