SUMMARY = "Python modules to use Fortigate APIs"
HOMEPAGE = "https://github.com/fortinet-solutions-cse/fortiosapi"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=109;endline=109;md5=184dcc5ebee7a3db6d9fcaec2157f0b3"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "37269d9dceeebeddfcf5b43932db9dc1f1f4f9b292e0931d2483e31949eb5099"

inherit pypi setuptools3 ptest-python-pytest

RDEPENDS:${PN} += "python3-oyaml python3-paramiko python3-requests"

# This package incorrectly tries to package RDEPENDS as well.
# Explicitly remove them
do_install:append() {
    rm -rf ${D}${libdir}/${PYTHON_DIR}/site-packages/tests/__pycache__/__init__.cpython-313.pyc
    rm -rf ${D}${libdir}/${PYTHON_DIR}/site-packages/tests/__init__.py
}

PYPI_PACKAGE = "fortiosapi"
