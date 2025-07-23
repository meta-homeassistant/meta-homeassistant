SUMMARY = "Calculate the geographical distance between 2 points with extreme accuracy."
HOMEPAGE = "https://github.com/maurycyp/vincenty"
LICENSE = "Unlicense"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=7b86c88a3c59abb095373712276aedb1"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "eaa2f2de835f369cbd71c1a01ccd4e0d412da0f4aeef7c9692242b9ce182785a"

inherit pypi setuptools3

PYPI_PACKAGE = "vincenty"
