SUMMARY = "Asynchronous Python client for Spotify."
HOMEPAGE = "https://github.com/joostlek/python-spotify"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=42c844fd316a2f541bc0bf347feb003c"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "5391842ba12e4f56240c96e4a0df32cd9d635e1cacbbd34b25b6b82ae1e944af"

inherit pypi python_poetry_core

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.0.0) \
    python3-mashumaro (>=3.11) \
    python3-orjson (>=3.9.10) \
    python3-yarl (>=1.6.0) \
"
