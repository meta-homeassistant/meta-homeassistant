SUMMARY = "A Python wrapper for the Dominos Pizza API"
HOMEPAGE = "https://github.com/aluttik/pizzapi"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b2583d7670c61da28bff2ba2707a9c48"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI += "file://0001-remove-deprecated-call.patch"
SRC_URI[sha256sum] = "c50787cef8c979d6afedd9021b1e215546111045b327ee421a6bfa4359834715"

inherit pypi setuptools3 ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-pyhamcrest \
    python3-requests \
    python3-xmltodict \
"

# This package incorrectly tries to package RDEPENDS as well.
# Explicitly remove them
do_install:append() {
    rm -rf ${D}${libdir}/${PYTHON_DIR}/site-packages/tests/__pycache__/__init__.cpython-313.pyc
    rm -rf ${D}${libdir}/${PYTHON_DIR}/site-packages/tests/__init__.pyd
    rm -rf ${D}${libdir}/${PYTHON_DIR}/site-packages/tests/__init__.py
}

PYPI_PACKAGE = "pizzapi"
