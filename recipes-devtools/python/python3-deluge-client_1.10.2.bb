SUMMARY = "Simple Deluge Client"
HOMEPAGE = "https://github.com/JohnDoee/deluge-client"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e18c14a9056b39f998edf5400cf33ba4"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "3881aee3c4e0ca9dd8a56b710047b837e1d087a83e421636a074771f92a9f1b5"

inherit pypi setuptools3

PYPI_PACKAGE = "deluge-client"
