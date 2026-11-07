SUMMARY = "Asynchronous Python client providing energy/gas prices from EnergyZero"
HOMEPAGE = "https://github.com/klaasnicolaas/python-energyzero"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a369d15b03074464523ec50eb0b7e190"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "bbb755bd60763690a6aad4cc691eb18693a4c5bbe2e3cc873b9795b2420393ab"

inherit pypi python_uv_build

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.0.0) \
    python3-yarl (>=1.6.0) \
"
