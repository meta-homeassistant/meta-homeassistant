SUMMARY = "iSmartGate and GogoGate2 API"
HOMEPAGE = "https://github.com/bdraco/ismartgate"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c31b208a093c8b031565845921e8d0bb"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "d7f555e4ff99c54cd5178005daf83ea35f80325273eaad5baacba8781ec2aea9"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "ismartgate"
