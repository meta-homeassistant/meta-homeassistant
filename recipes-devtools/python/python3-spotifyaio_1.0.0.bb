SUMMARY = "Asynchronous Python client for Spotify."
HOMEPAGE = "https://github.com/joostlek/python-spotify"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=07576f74d58a2dbfd9911ed7a72b8c76"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "830063af7875292ac973754b293ec8937f647f759e902b3efbb43b2902fa87ae"

inherit pypi python_poetry_core

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.0.0) \
    python3-mashumaro (>=3.11) \
    python3-orjson (>=3.9.10) \
    python3-yarl (>=1.6.0) \
"
