SUMMARY = "Yet another implementation for the positional numeral system using 36 as the radix."
HOMEPAGE = "https://github.com/tonyseek/python-base36"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e500bb8e21e03bafacc5c981e88ac7ec"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "6f221783c5499bd5fd4a1102054df9638d6232ff5ca850c21fd1efe5070c1a96"

inherit pypi setuptools3

PYPI_PACKAGE = "base36"
