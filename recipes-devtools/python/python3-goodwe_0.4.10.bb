SUMMARY = "Read data from GoodWe inverter via local network"
HOMEPAGE = "https://github.com/marcelblijleven/goodwe"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1e510f973b16ceb41507167a31a34684"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "8c0786f32b1f59bb0209773bf6b9d3333b33e5628039de95c1efc3b49c593e26"

DEPENDS += "python3-wheel-native"

inherit pypi python_setuptools_build_meta ptest-python-pytest
