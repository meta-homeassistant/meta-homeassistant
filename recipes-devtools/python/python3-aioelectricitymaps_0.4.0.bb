SUMMARY = "Async Python 3 wrapper for Electricity maps"
HOMEPAGE = "https://github.com/jpbede/aioelectricitymaps"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9647659b324628f18a7bc41e3f7bfbf7"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "93c7f73df2fae97cffd661bef7a2397788ac582d63cedb45af0f81a5b2062676"

inherit pypi python_poetry_core

PYPI_PACKAGE = "aioelectricitymaps"
RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.8.0) \
    python3-mashumaro (>=3.11) \
    python3-orjson (>=3.9.8) \
"
