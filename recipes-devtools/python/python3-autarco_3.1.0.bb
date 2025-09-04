SUMMARY = "Asynchronous Python client for the Autarco Inverters"
HOMEPAGE = "https://github.com/klaasnicolaas/python-autarco"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e084133c151457768acdd53a7582fec9"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "efdf1a85014545aeee161a595db243e89579043316811cf097bc27564ce036e4"

inherit pypi python_poetry_core

PYPI_PACKAGE = "autarco"

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.0.0) \
    python3-mashumaro (>=3.12) \
    python3-orjson (>=3.9.14) \
    python3-yarl (>=1.6.0) \
"
