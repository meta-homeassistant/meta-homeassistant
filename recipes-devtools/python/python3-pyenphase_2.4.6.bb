SUMMARY = "Library to control enphase envoy"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1f7f6fd04439f6b7575b1f1fc4185b76"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "020f6443ef0ba167ea24c81b5085a6d8e9461f504c7879a572ebfb55eeffc6cb"

inherit pypi python_poetry_core

PYPI_PACKAGE = "pyenphase"
RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.12.8) \
    python3-awesomeversion (>=22.9.0) \
    python3-envoy-utils (>=0.0.1) \
    python3-lxml (>=4.9.2) \
    python3-orjson (>=3.10) \
    python3-pyjwt (>=2.7.0) \
    python3-tenacity (>=8.2.2) \
"
