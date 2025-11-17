SUMMARY = "This module support controlling gardena bluetooth enabled watering computers."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=11afde19ff9d72b16eafac777ea8ca32"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "199f5781e02abcd33195c87952db9ef732e105ca92e7182e450fd53705bd60fb"

inherit pypi python_poetry_core

RDEPENDS:${PN} = "\
    python3-bleak (>=0.20.2) \
    python3-bleak-retry-connector (>=3.0.2) \
    python3-tzlocal (>=5.0.1) \
"

PYPI_PACKAGE = "gardena_bluetooth"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
