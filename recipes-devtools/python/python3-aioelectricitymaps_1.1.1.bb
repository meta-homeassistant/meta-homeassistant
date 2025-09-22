SUMMARY = "Async Python 3 wrapper for Electricity maps"
HOMEPAGE = "https://github.com/jpbede/aioelectricitymaps"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9647659b324628f18a7bc41e3f7bfbf7"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "50c2329bc9daed3daa8870e5a8fb4f64d8ef62766071d0364bb8d958478c980c"

inherit pypi python_poetry_core

PYPI_PACKAGE = "aioelectricitymaps"
RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.8.0) \
    python3-mashumaro (>=3.11) \
    python3-orjson (>=3.9.8) \
"
