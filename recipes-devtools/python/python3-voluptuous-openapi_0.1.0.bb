SUMMARY = "Convert voluptuous schemas to OpenAPI Schema object"
HOMEPAGE = "http://github.com/Shulyaka/voluptuous-openapi"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=dab31a1d28183826937f4b152143a33f"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "84bc44107c472ba8782f7a4cb342d19d155d5fe7f92367f092cd96cc850ff1b7"

inherit pypi python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} += "python3-voluptuous"

PYPI_PACKAGE = "voluptuous_openapi"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
