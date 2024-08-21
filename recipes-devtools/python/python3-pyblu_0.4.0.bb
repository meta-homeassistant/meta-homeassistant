SUMMARY = "BluOS API client"
HOMEPAGE = "https://github.com/LouisChrist/pyblu"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1e9cdf4214388e44c780f384315d4730"

SRC_URI[sha256sum] = "a8c6f0ad10fb654b071ce2c5f723ef031893989f2f257d5cc875fee0e36db10f"

inherit pypi python_poetry_core

PYPI_PACKAGE = "pyblu"

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.9.5) \
    python3-xmltodict (>=0.13.0) \
"
