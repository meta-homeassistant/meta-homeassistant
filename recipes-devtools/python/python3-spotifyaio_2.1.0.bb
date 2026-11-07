SUMMARY = "Asynchronous Python client for Spotify."
HOMEPAGE = "https://github.com/joostlek/python-spotify"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=42c844fd316a2f541bc0bf347feb003c"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "d2d3a802f081b5a41f74812f84d9376c40a151b9beff2fe960a2450c310ed77f"

inherit pypi python_poetry_core

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.0.0) \
    python3-mashumaro (>=3.11) \
    python3-orjson (>=3.9.10) \
    python3-yarl (>=1.6.0) \
"
