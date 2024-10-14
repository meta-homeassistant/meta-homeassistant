SUMMARY = "Retrieve values from public API at the Swedish Transport Administration (Trafikverket)."
HOMEPAGE = "https://github.com/gjohansson-ST/pytrafikverket"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d1b94612955aac1df750a14de9ce3381"

SRC_URI[sha256sum] = "aaf25b004e42d7d452839a7cdb7b0227f7562070520f8909af0fe9f0f1761e42"

inherit pypi python_poetry_core

PYPI_PACKAGE = "pytrafikverket"

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.9.2) \
    python3-aiozoneinfo (>=0.2.1) \
    python3-core (>=3.11) \
    python3-lxml (>=5.1.0) \
    python3-yarl (>=1.9.4) \
"
