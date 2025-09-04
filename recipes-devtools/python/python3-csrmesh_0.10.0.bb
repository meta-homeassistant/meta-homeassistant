SUMMARY = "Reverse engineered implementation of the CSRMesh bridge protocol"
HOMEPAGE = "https://github.com/nkaminski/csrmesh"
LICENSE = "LGPL-3.0-only"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=0b7106ee10fe3b9cd9154e30a042aa0d"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "4fa11356b1231686762f013717c3af2dd2bd63d66fc01937de8e5d4f4a559f0e"

inherit pypi setuptools3

RDEPENDS:${PN} += "bluepy python3-pycryptodomex"

PYPI_PACKAGE = "csrmesh"
