SUMMARY = "Python library to control Comelit Simplehome"
HOMEPAGE = "https://github.com/chemelli74/aiocomelit"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fadb4c1a30a15a1ee80a4dafcd77b3e0"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "ae12c2ddd4e6f53d08be5821d1199b068012f01121ac65668369db388eb47379"

inherit pypi python_poetry_core

PYPI_PACKAGE = "aiocomelit"

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.12.7) \
    python3-colorlog \
    python3-flexcache \
    python3-flexparser \
    python3-pint \
"
