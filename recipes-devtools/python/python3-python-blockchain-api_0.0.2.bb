SUMMARY = "Python API for interacting with blockchain.info."
HOMEPAGE = "https://github.com/nkgilley/python-blockchain-api"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=8227180126797a0148f94f483f3e1489"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "242fc55a44aaf9173f5d7dfd45080b06796772e451ba614d02b3833490f3007c"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-requests (>=2.0)"

PYPI_PACKAGE = "python-blockchain-api"
