SUMMARY = "Python API for controlling Avi-on Bluetooth dimmers"
HOMEPAGE = "http://github.com/mjg59/python-avion"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=13;endline=13;md5=be6b75976b773f290428d04f15f63ebd"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI += "file://0001-Fix-typo.patch"
SRC_URI[sha256sum] = "bffd0dc059b10d9f6410ec79aace4bf6c2b33a0fe4b68efdb3272d834021fb7d"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    bluepy \
    python3-csrmesh (>=0.9.0) \
    python3-requests (>=2.18.4) \
"

# This package incorrectly tries to package RDEPENDS as well.
# Explicitly remove them
do_install:append() {
    rm -rf ${D}${libdir}/${PYTHON_DIR}/site-packages/bluepy
    rm -rf ${D}${libdir}/${PYTHON_DIR}/site-packages/csrmesh
}

PYPI_PACKAGE = "avion"
