SUMMARY = "Functions for calculation of meteorological variables."
HOMEPAGE = "https://github.com/malexer/meteocalc"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=8227180126797a0148f94f483f3e1489"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "5df5a2417289b8422380dbd73d874692b31b8a054feb5e630c20ba094c597f39"

inherit pypi setuptools3

PYPI_PACKAGE = "meteocalc"
