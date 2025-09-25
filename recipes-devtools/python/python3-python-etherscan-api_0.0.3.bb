SUMMARY = "Python API for interacting with etherscan.io."
HOMEPAGE = "https://github.com/nkgilley/python-etherscan-api"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=8227180126797a0148f94f483f3e1489"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "97ad3fed1ff7dfa7996593ecfaed2335aeafa0942ec4bd80e9bb9a213d320ca4"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-requests (>=2.0)"

PYPI_PACKAGE = "python-etherscan-api"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
