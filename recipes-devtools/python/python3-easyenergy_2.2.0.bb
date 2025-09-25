SUMMARY = "Asynchronous Python client providing energy/gas prices from easyEnergy"
HOMEPAGE = "https://github.com/klaasnicolaas/python-easyenergy"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b248c7449204ac62e20885f38e385888"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "da4abfede30816f01eb9e5243b3e753d41dd486abbf68d4615a40a87fcc0e5c4"

inherit pypi python_poetry_core

PYPI_PACKAGE = "easyenergy"
RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.0.0) \
    python3-yarl (>=1.6.0) \
"
