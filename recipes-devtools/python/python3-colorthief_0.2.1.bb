SUMMARY = "A module for grabbing the color palette from an image."
HOMEPAGE = "https://github.com/fengsp/color-thief-py"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a6cb8301ba6bf08f7e489fbd9061cb78"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "079cb0c95bdd669c4643e2f7494de13b0b6029d5cdbe2d74d5d3c3386bd57221"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-pillow"

PYPI_PACKAGE = "colorthief"
