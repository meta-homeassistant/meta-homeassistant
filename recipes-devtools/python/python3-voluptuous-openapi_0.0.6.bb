SUMMARY = "Convert voluptuous schemas to OpenAPI Schema object"
HOMEPAGE = "http://github.com/Shulyaka/voluptuous-openapi"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=dab31a1d28183826937f4b152143a33f"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "4078c2acef23e04ceeab1ba58252590fcdc3ba6e3ed34521e8595374ab4de884"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-voluptuous"

PYPI_PACKAGE = "voluptuous_openapi"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
