SUMMARY = "QR Code and Micro QR Code generator for Python"
HOMEPAGE = "https://github.com/heuer/segno/"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5d59d1644383230a2e3a4dd6bdd05676"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "e60933afc4b52137d323a4434c8340e0ce1e58cec71439e46680d4db188f11b3"

inherit pypi python_flit_core ptest-python-pytest

PYPI_PACKAGE = "segno"
