SUMMARY = "Interface with Edimax Smart Plugs"
HOMEPAGE = "https://github.com/andreipop2005/pyedimax"
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=8227180126797a0148f94f483f3e1489"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "339715423a8f64240c292f2fbfec70db1e8a951a81ea639ecf02e2e777c96fc4"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-requests (>=2.0)"

PYPI_PACKAGE = "pyedimax"
