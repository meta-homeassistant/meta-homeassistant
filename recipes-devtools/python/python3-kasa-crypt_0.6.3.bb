SUMMARY = "Fast kasa crypt"
HOMEPAGE = "https://github.com/python-kasa/kasa-crypt"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=da57f3e0372e39698a274746eb9d65d6"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "2de6de01b6c16435233e8da2541a2ebfa8d7725f1a307dc9d6057f08dedc2bbb"

inherit pypi python_poetry_core cython

PYPI_PACKAGE = "kasa_crypt"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
