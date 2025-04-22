SUMMARY = "A python3 library to communicate with Adax"
HOMEPAGE = "https://github.com/Danielhiversen/pyAdax"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2736a6a8b58491968000c6e0130f0471"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "6129fea4bf13bc49146bfb9b4e7465dfef8590c04b0202988e24f273247a7d3d"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-aiohttp (>=3.0.6) \
    python3-async-timeout (>=3.0.0) \
"

PYPI_PACKAGE = "adax"
