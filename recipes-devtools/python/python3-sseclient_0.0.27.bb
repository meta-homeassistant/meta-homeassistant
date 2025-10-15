SUMMARY = "Python client library for reading Server Sent Event streams."
HOMEPAGE = "https://github.com/btubbs/sseclient"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e04f70f331d3fc1e7623959f9a48244c"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "b2fe534dcb33b1d3faad13d60c5a7c718e28f85987f2a034ecf5ec279918c11c"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-requests (>=2.9) python3-six"

PYPI_PACKAGE = "sseclient"
