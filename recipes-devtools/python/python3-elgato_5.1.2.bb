SUMMARY = "Asynchronous Python client for Elgato Lights."
HOMEPAGE = "https://github.com/frenck/python-elgato"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=6;endline=6;md5=8227180126797a0148f94f483f3e1489"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "4ee180ee50dbefd20900ded2690f3b253133529e5a2842c458d115ae21ed7a7b"

inherit pypi python_poetry_core

PYPI_PACKAGE = "elgato"
RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.0.0) \
    python3-mashumaro (>=3.10) \
    python3-orjson (>=3.9.8) \
    python3-yarl (>=1.6.0) \
"
