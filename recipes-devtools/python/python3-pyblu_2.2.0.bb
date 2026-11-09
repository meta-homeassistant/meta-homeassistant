SUMMARY = "BluOS API client"
HOMEPAGE = "https://github.com/LouisChrist/pyblu"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1e9cdf4214388e44c780f384315d4730"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "edcfff3d7596f7567c4bf7c6f07d2476deb23d61504360ad96f5aad4f29c2af3"

inherit pypi python_hatchling

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.10.8) \
    python3-core (>=3.11) \
    python3-lxml (>=5.0.0) \
    python3-yarl \
"
