SUMMARY = "Implementation of Noise Protocol Framework"
HOMEPAGE = "https://github.com/plizonczyk/noiseprotocol"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=8227180126797a0148f94f483f3e1489"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "b092a871b60f6a8f07f17950dc9f7098c8fe7d715b049bd4c24ee3752b90d645"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-cryptography (>=2.8)"

PYPI_PACKAGE = "noiseprotocol"
