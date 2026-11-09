SUMMARY = "Retrieve values from public API at the Swedish Transport Administration (Trafikverket)."
HOMEPAGE = "https://github.com/gjohansson-ST/pytrafikverket"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d1b94612955aac1df750a14de9ce3381"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "8921d1a90e2ca5fc971dea58549e9d702e5f1fb030d9894a1409e2a7757c80d4"

inherit pypi python_poetry_core


RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.9.2) \
    python3-aiozoneinfo (>=0.2.1) \
    python3-core (>=3.11) \
    python3-lxml (>=5.1.0) \
    python3-yarl (>=1.9.4) \
"
