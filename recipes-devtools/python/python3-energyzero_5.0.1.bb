SUMMARY = "Asynchronous Python client providing energy/gas prices from EnergyZero"
HOMEPAGE = "https://github.com/klaasnicolaas/python-energyzero"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a369d15b03074464523ec50eb0b7e190"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "44628ebfcabd8c137d493f5ed2154574715d93d571738a2f691a354db9e70b4a"

inherit pypi python_poetry_core

PYPI_PACKAGE = "energyzero"
RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.0.0) \
    python3-yarl (>=1.6.0) \
"
