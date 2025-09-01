SUMMARY = "Python library to control Comelit Simplehome"
HOMEPAGE = "https://github.com/chemelli74/aiocomelit"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fadb4c1a30a15a1ee80a4dafcd77b3e0"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "a5e5e3338505b163f3363d7df9717a612202af915a56217cfc699665fc6144ae"

inherit pypi python_poetry_core

PYPI_PACKAGE = "aiocomelit"

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.12.7) \
    python3-colorlog \
    python3-pint \
"
