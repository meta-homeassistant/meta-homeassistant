SUMMARY = "BluOS API client"
HOMEPAGE = "https://github.com/LouisChrist/pyblu"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1e9cdf4214388e44c780f384315d4730"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "8f330cd87425adbc9bb37a32ebb14a7e4bad18afc8ffe5a22c4a5f0ad51c447f"

inherit pypi python_hatchling

PYPI_PACKAGE = "pyblu"

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.10.8) \
    python3-core (>=3.11) \
    python3-lxml (>=5.0.0) \
"
