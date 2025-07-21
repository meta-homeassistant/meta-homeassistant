SUMMARY = "Simple Arve library"
HOMEPAGE = "https://github.com/arvetech/asyncarve"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=6;endline=6;md5=8227180126797a0148f94f483f3e1489"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "e61e7a4abd243cbacd3d4ef45bdd16b239966b1fcdf74751309ea5239320f3a1"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-aiohttp (>=3.9.3) \
    python3-mashumaro (>=3.12) \
    python3-orjson (>=2.0.1) \
    python3-yarl (>=1.9.4) \
"

PYPI_PACKAGE = "asyncarve"
