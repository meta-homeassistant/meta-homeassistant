SUMMARY = "A python library to interrogate emoncms API"
HOMEPAGE = "https://github.com/Open-Building-Management/pyemoncms"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3f0dba5cebe196bfb187d0ec585e02cc"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "4a2323cacce64de833897d2659d1ba5aba2b03077db89c843f5620dd838dfdd3"

inherit pypi python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} += " python3-aiohttp"

PYPI_PACKAGE = "pyemoncms"
