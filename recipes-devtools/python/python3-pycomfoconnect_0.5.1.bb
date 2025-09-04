SUMMARY = "Python interface for the Zehnder ComfoConnect LAN C bridge."
HOMEPAGE = "https://github.com/michaelarnauts/comfoconnect"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=56202da26a01b0c4148b8926fa713d13"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "7720d148f5eeb6cc5153c0c5499dd31f57fa674389ad74694a5cd98e5a054650"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-protobuf (>=3.20.3)"

PYPI_PACKAGE = "pycomfoconnect"
