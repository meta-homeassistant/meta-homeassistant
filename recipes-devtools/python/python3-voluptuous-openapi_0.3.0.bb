SUMMARY = "Convert voluptuous schemas to OpenAPI Schema object"
HOMEPAGE = "http://github.com/Shulyaka/voluptuous-openapi"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=dab31a1d28183826937f4b152143a33f"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "1ecd2386e63b59b791e0f64715e317c7018a2e5598333138bd1f28adfd348d5c"

inherit pypi python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} += "python3-voluptuous"

PYPI_PACKAGE = "voluptuous_openapi"

RDEPENDS:${PN}-ptest += "python3-openapi-schema-validator"