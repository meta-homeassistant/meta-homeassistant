SUMMARY = "Asynchronous Python client for the Autarco Inverters"
HOMEPAGE = "https://github.com/klaasnicolaas/python-autarco"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b248c7449204ac62e20885f38e385888"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "94d7dc1e4ddbad24167638fe012f5e8b0dacb688c297f75a2d3ca29ab6768271"

inherit pypi python_poetry_core

PYPI_PACKAGE = "autarco"

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.0.0) \
    python3-mashumaro (>=3.12) \
    python3-orjson (>=3.9.14) \
    python3-yarl (>=1.6.0) \
"
