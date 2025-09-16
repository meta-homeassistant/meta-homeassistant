SUMMARY = "An unofficial Dynalite DyNET interface creating devices."
HOMEPAGE = "https://github.com/ziv1234/python-dynalite-devices"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=faa1c3d6d578e37f941055bc27cc6a3b"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "7ba77c6d18a591560761c90eddc873aa746fd99375a772bbe36298d064db2fbd"

inherit pypi setuptools3 ptest-python-pytest

PYPI_PACKAGE = "dynalite_devices"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
