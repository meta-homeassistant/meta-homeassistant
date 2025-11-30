SUMMARY = "Python package to control BlinkStick USB devices."
HOMEPAGE = "http://pypi.python.org/pypi/BlinkStick/"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=f428bf7ceb17c1e2dcc6b4be09ef3599"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "a9324e04a3733c89476182bddeb109b4487de0dc7d01f587e07e191d501cb365"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-pyusb (>=1.0.0)"

PYPI_PACKAGE = "BlinkStick"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
