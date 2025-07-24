SUMMARY = "Up-to-date simple useragent faker with real world database"
HOMEPAGE = "https://github.com/fake-useragent/fake-useragent"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=611d0a27bda1a4ea03000035b1b4415c"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "4e6ab6571e40cc086d788523cf9e018f618d07f9050f822ff409a4dfe17c16b2"

inherit pypi python_setuptools_build_meta ptest-python-pytest

PYPI_PACKAGE = "fake_useragent"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
