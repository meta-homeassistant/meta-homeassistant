SUMMARY = "A library to communicate with the W800rf32 family of devices"
HOMEPAGE = "https://github.com/horga83/pyW800rf32"
LICENSE = "LGPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://COPYING.txt;md5=3c5a0bfbe89bf8ebd743e27df03031e8"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "8b45d7aa884a639a5622370e094c5441dc7f1524aa8139d3696703c672188cc9"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} += "\
    python3-pyserial (>=3.1) \
"

PYPI_PACKAGE = "pyW800rf32"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
