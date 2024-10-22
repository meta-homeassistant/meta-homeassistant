SUMMARY = "BluOS API client"
HOMEPAGE = "https://github.com/LouisChrist/pyblu"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1e9cdf4214388e44c780f384315d4730"

SRC_URI[sha256sum] = "c66baf056d1e124d728e5850b1006d3816a524c5245b128c20d8b6b80abd2b23"

inherit pypi python_poetry_core

PYPI_PACKAGE = "pyblu"

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.10.8) \
    python3-core (>=3.11) \
    python3-lxml (>=5.0.0) \
"
