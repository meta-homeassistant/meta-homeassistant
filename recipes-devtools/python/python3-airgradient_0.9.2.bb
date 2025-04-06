SUMMARY = "Asynchronous Python client for AirGradient."
HOMEPAGE = "https://github.com/airgradienthq/python-airgradient"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=3cbad2730435ed9eb7dd28aa6f638767"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "ffd5494df3c1166d92abe28d17dc8d6c3d83b185e1064d3b1d5670277718d1ca"

inherit pypi python_poetry_core

PYPI_PACKAGE = "airgradient"

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.0.0) \
    python3-mashumaro (>=3.11) \
    python3-orjson (>=3.9.0) \
    python3-yarl (>=1.6.0) \
"
