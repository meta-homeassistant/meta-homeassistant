SUMMARY = "BluOS API client"
HOMEPAGE = "https://github.com/LouisChrist/pyblu"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1e9cdf4214388e44c780f384315d4730"

SRC_URI[sha256sum] = "f2609aedb56d323fafa068bb93b2b716376a844452e2828c5f4e10d2888bbf8e"

inherit pypi python_poetry_core

PYPI_PACKAGE = "pyblu"

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.10.8) \
    python3-core (>=3.11) \
    python3-lxml (>=5.0.0) \
"
