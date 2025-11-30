SUMMARY = "Read data from GoodWe inverter via local network"
HOMEPAGE = "https://github.com/marcelblijleven/goodwe"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1e510f973b16ceb41507167a31a34684"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "e20d9a6ce4a603cd303a3d0246f031f08cd307da17125ec3faa75d674c55b3cc"

inherit pypi python_setuptools_build_meta ptest-python-pytest

PYPI_PACKAGE = "goodwe"
