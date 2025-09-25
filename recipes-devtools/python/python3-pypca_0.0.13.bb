SUMMARY = "A python cli for PCA 301 smart plugs."
HOMEPAGE = "http://www.github.com/majuss/pypca"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=7;endline=7;md5=8227180126797a0148f94f483f3e1489"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "b42d7d0be4d8b63c311b132e8d934960a5c3a41364c71ba7af4174216a161778"

DEPENDS = "python3-pyserial-native"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-colorlog python3-pyserial"

PYPI_PACKAGE = "pypca"
