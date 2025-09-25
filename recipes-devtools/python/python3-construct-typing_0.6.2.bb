SUMMARY = "Extension for the python package 'construct' that adds typing features"
HOMEPAGE = "https://github.com/timrid/construct-typing"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c34c548cd3be24920c06048d2de9b266"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "948e998cfc003681dc34f2d071c3a688cf35b805cbe107febbc488ef967ccba1"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-construct (>=2.10.68) \
    python3-typing-extensions (>=4.6.0) \
"

PYPI_PACKAGE = "construct-typing"
