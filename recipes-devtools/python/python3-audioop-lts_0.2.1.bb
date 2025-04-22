SUMMARY = "LTS Port of Python audioop"
HOMEPAGE = "https://github.com/AbstractUmbra/audioop"
LICENSE = "PSF-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fcf6b249c2641540219a727f35d8d2c2"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "e81268da0baa880431b68b1308ab7257eb33f356e57a5f9b1f915dfb13dd1387"

inherit pypi python_setuptools_build_meta ptest-python-pytest

PYPI_PACKAGE = "audioop_lts"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
