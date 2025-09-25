SUMMARY = "Provides a python interface to interact with a Emby media server."
HOMEPAGE = "https://github.com/mezz64/pyemby"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=4b0970808e9ec547316870e9ed531a2d"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "003353c87b8428c627ac04af1bfa1fedb837038447da93bd67a8b297c497c7fd"

inherit pypi setuptools3

PYPI_PACKAGE = "pyEmby"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
