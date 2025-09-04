SUMMARY = "Fixes mojibake and other problems with Unicode, after the fact"
HOMEPAGE = "https://ftfy.readthedocs.io/en/latest/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=3ad45685700b2029ae5b070e6dd62c09"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS = "python3-hatchling-native"
SRC_URI[sha256sum] = "9b3c3d90f84fb267fe64d375a07b7f8912d817cf86009ae134aa03e1819506ec"

inherit pypi python_hatchling ptest-python-pytest

PYPI_PACKAGE = "ftfy"
RDEPENDS:${PN} = "python3-wcwidth"
