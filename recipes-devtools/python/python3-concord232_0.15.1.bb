SUMMARY = "GE Concord 4 RS232 Serial Interface Library and Server"
HOMEPAGE = "http://github.com/JasonCarter80/concord232"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "647514f60eec9b93eed9577a7a11f807457d6da635b185e792a2d7d9dc5d867d"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} += "\
    python3-requests \
    python3-stevedore \
    python3-prettytable \
    python3-pyserial \
    python3-flask \
"

PYPI_PACKAGE = "concord232"
