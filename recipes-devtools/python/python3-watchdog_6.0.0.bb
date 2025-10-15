SUMMARY = "Filesystem events monitoring"
HOMEPAGE = "https://github.com/gorakhargosh/watchdog"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "9ddf7c82fda3ae8e24decda1338ede66e1c99883db93711d8fb941eaa2d8c282"

inherit pypi setuptools3 ptest-python-pytest

PYPI_PACKAGE = "watchdog"
