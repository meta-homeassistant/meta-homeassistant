SUMMARY = "Asynchronous Python client providing energy/gas prices from EnergyZero"
HOMEPAGE = "https://github.com/klaasnicolaas/python-energyzero"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b248c7449204ac62e20885f38e385888"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "03bd77d1e8ff42d95f70ba9c979cbde224ff088aca34229cc0a78f97f826edb5"

inherit pypi python_poetry_core

PYPI_PACKAGE = "energyzero"
RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.0.0) \
    python3-yarl (>=1.6.0) \
"
