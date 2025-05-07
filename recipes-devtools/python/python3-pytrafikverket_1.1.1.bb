SUMMARY = "Retrieve values from public API at the Swedish Transport Administration (Trafikverket)."
HOMEPAGE = "https://github.com/gjohansson-ST/pytrafikverket"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d1b94612955aac1df750a14de9ce3381"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "c9fa37e9f0150b62daadeb10d50717ab6106846b6457335b5af0fa9729e1bac4"

inherit pypi python_poetry_core

PYPI_PACKAGE = "pytrafikverket"

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.9.2) \
    python3-aiozoneinfo (>=0.2.1) \
    python3-core (>=3.11) \
    python3-lxml (>=5.1.0) \
    python3-yarl (>=1.9.4) \
"
