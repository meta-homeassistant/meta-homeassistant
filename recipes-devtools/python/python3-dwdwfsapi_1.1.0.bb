SUMMARY = "Python client to retrieve data provided by DWD via their geoserver WFS API"
HOMEPAGE = "https://github.com/stephan192/dwdwfsapi"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=59dad0a820704df21a33ed50d9c0ce6d"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS = "python3-hatchling-native"
SRC_URI[sha256sum] = "edd2150fee0c898b6c8c03398faecc95b8943764390e92ba6d453466e1cddab9"

inherit pypi python_hatchling

PYPI_PACKAGE = "dwdwfsapi"
RDEPENDS:${PN} = "\
    python3-requests (>=2.31.0) \
    python3-urllib3 (>=1.26.5) \
"
