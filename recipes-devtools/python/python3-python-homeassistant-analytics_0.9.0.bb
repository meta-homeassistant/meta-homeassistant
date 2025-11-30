SUMMARY = "Asynchronous Python client for Homeassistant Analytics."
HOMEPAGE = "https://github.com/joostlek/python-homeassistant-analytics"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=f9194f30309472c13bf3c3269903172f"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "a067c7eea53036787ac47d9a8f43571c6cde3593ff3eea25ac52be58a615b231"

inherit pypi python_poetry_core

PYPI_PACKAGE = "python_homeassistant_analytics"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.0.0) \
    python3-mashumaro (>=3.11) \
    python3-orjson (>=3.9.0) \
    python3-yarl (>=1.6.0) \
"
