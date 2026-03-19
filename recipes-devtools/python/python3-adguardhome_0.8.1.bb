SUMMARY = "Asynchronous Python client for the AdGuard Home API."
HOMEPAGE = "https://github.com/frenck/python-adguardhome"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=0789b59a6ea5842c0bf47837431adb5d"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "468207e568686a3f749cf0ae78f3e20a549a4197616d65286d207f726b68ab30"

inherit pypi python_poetry_core

PYPI_PACKAGE = "adguardhome"

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.0.0) \
    python3-core (>=3.11) \
    python3-yarl (>=1.6.0) \
"
