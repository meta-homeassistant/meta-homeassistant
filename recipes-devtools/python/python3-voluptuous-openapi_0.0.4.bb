SUMMARY = "Convert voluptuous schemas to OpenAPI Schema object"
HOMEPAGE = "http://github.com/Shulyaka/voluptuous-openapi"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=dab31a1d28183826937f4b152143a33f"

SRC_URI[sha256sum] = "b26d829215d994cc95f360bf055587bb90ff83364320695847013910991bb71e"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-voluptuous"

PYPI_PACKAGE = "voluptuous_openapi"
