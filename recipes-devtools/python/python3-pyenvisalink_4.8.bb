SUMMARY = "A python3 library for running asynchronus communications with envisalink alarm control panel modules."
HOMEPAGE = "https://github.com/ufodone/pyenvisalink"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=7bda0925566c1a0dc0b380d4ede12e07"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "22060e947d2662a8512d33b731c040b2d0a1a98587424c2e3953cbf2029d713a"

inherit pypi setuptools3

PYPI_PACKAGE = "pyenvisalink"
