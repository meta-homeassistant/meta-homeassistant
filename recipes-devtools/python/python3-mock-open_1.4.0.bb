SUMMARY = "A better mock for file I/O"
HOMEPAGE = "http://github.com/nivbend/mock-open"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=203135c2eb1a7de51dcfaff9cbdb2f1d"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "c3ecb6b8c32a5899a4f5bf4495083b598b520c698bba00e1ce2ace6e9c239100"

inherit pypi setuptools3

PYPI_PACKAGE = "mock-open"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
