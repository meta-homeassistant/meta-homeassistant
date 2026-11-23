SUMMARY = "Asynchronous Python client providing energy/gas prices from easyEnergy"
HOMEPAGE = "https://github.com/klaasnicolaas/python-easyenergy"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a369d15b03074464523ec50eb0b7e190"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "54b4a32f177040df60590f48eab600adbea5ec03cdcac9fb9ac56bb3da5df272"

inherit pypi python_poetry_core

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.0.0) \
    python3-mashumaro \
    python3-yarl (>=1.6.0) \
"
