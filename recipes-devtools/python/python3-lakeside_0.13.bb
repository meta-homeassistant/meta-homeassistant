SUMMARY = "Python API for controlling Eufy LED bulbs"
HOMEPAGE = "http://github.com/nkgilley/python-lakeside"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "e8311886e202a6ad1c988051a6f14e348131bf74040c43bdc3c817517ec07aeb"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-protobuf python3-pycryptodome python3-requests"

PYPI_PACKAGE = "lakeside"
