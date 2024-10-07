SUMMARY = "BluOS API client"
HOMEPAGE = "https://github.com/LouisChrist/pyblu"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1e9cdf4214388e44c780f384315d4730"

SRC_URI[sha256sum] = "a7e683bb70d60e4bdc15f899849bd6f482c021a5f88912151e9ea57dc9624121"

inherit pypi python_poetry_core

PYPI_PACKAGE = "pyblu"

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.9.0) \
    python3-core (>=3.11) \
    python3-lxml (>=5.0.0) \
"
