SUMMARY = "cChardet is high speed universal character encoding detector."
HOMEPAGE = "https://github.com/faust-streaming/cChardet"
LICENSE = "MPL-1.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=6ecda54f6f525388d71d6b3cd92f7474"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "f89386297cde0c8e0f5e21464bc2d6d0e4a4fc1b1d77cdb238ca24d740d872e0"

DEPENDS += "python3-pkgconfig-native"

inherit pypi python_setuptools_build_meta cython

PYPI_PACKAGE = "faust-cchardet"
