SUMMARY = "A Sans-I/O Python client library for Brultech Devices"
HOMEPAGE = "https://github.com/sdwilsh/siobrultech-protocols"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2612cb5366f6508860afc059e2ce0eaa"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "6364422e6a7dbb3230f768374fa6f858ad03f39c806cbea766eb6fc135077819"

inherit pypi python_setuptools_build_meta ptest-python-pytest

# Upstream wheel/sdist installs a top-level "tests" package, which collides
# with other Python recipes that also ship /site-packages/tests/__init__.py.
do_install:append() {
	rm -rf ${D}${libdir}/${PYTHON_DIR}/site-packages/tests
}


