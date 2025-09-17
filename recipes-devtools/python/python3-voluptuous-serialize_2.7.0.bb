SUMMARY = "Convert Voluptuous schemas to dictionaries so they can be serialized."
HOMEPAGE = "http://github.com/balloob/voluptuous-serialize"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=dab31a1d28183826937f4b152143a33f"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

inherit python_setuptools_build_meta pypi ptest-python-pytest

SRC_URI[sha256sum] = "d0da959f2fd93c8f1eb779c5d116231940493b51020c2c1026bab76eb56cd09e"

PYPI_PACKAGE = "voluptuous_serialize"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
