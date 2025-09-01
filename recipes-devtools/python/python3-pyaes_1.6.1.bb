SUMMARY = "Pure-Python Implementation of the AES block-cipher and common modes of operation"
HOMEPAGE = "https://github.com/ricmoo/pyaes"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=70097d7a871356a2e7f3018a023a09d8"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "02c1b1405c38d3c370b085fb952dd8bea3fadcee6411ad99f312cc129c536d8f"

inherit pypi setuptools3 ptest-python-pytest

PYPI_PACKAGE = "pyaes"
