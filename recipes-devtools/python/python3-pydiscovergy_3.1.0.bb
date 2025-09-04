SUMMARY = "Async Python 3 library for interacting with Discovergy smart meters API"
HOMEPAGE = "https://github.com/jpbede/pydiscovergy"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4922bbae8194a4c2f4ac64a8752b6a8a"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "28c3478d50c9926f1016db0366f33a27c6c701d51951f9dadba47178b798103c"

inherit pypi python_poetry_core

PYPI_PACKAGE = "pydiscovergy"
RDEPENDS:${PN} = "\
    python3-httpx (>=0.24) \
    python3-mashumaro (>=3.11) \
    python3-orjson (>=3.9.0) \
    python3-authlib (>=0.15) \
"
