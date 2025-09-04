SUMMARY = "Python library and CLI for the Clementine Music Player remote protocol."
HOMEPAGE = "http://github.com/jjmontesl/python-clementine-remote"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=8772ee3e03d3700ca6a0bb241286c509"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "9a7623b0aeca34838f15dcc36af0115c5a48e4b45ce20749d4ebb3d29fe09267"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-protobuf"

PYPI_PACKAGE = "python-clementine-remote"
