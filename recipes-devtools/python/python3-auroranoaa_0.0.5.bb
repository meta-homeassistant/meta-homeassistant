SUMMARY = "NOAA Aurora Wrapper for Home Assistant Integration."
HOMEPAGE = "https://github.com/djtimca/aurora-api"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "40eac5b8c7ab683d7a09100f5e22c55e012695741603e2c798644cdef9013ab2"

inherit pypi setuptools3

PYPI_PACKAGE = "auroranoaa"
