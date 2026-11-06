SUMMARY = "A Python wrapper for the Dominos Pizza API"
HOMEPAGE = "https://github.com/aluttik/pizzapi"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b2583d7670c61da28bff2ba2707a9c48"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS += "python3-pytest-runner-native"

SRC_URI += "git://github.com/ggrammar/pizzapi.git;branch=master;protocol=https"
SRCREV = "2a67ceb0f6df285988f1a2d7b678bbd2526c26a4"

inherit setuptools3 ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-pyhamcrest \
    python3-requests \
    python3-xmltodict \
"

RDEPENDS:${PN}-ptest += "\
    python3-mock \
"

# This package incorrectly tries to package RDEPENDS as well.
# Explicitly remove them
do_install:append() {
    rm -rf ${D}${libdir}/${PYTHON_DIR}/site-packages/tests/__pycache__/__init__.cpython-*
    rm -rf ${D}${libdir}/${PYTHON_DIR}/site-packages/tests/__init__.pyd
    rm -rf ${D}${libdir}/${PYTHON_DIR}/site-packages/tests/__init__.py
}
