SUMMARY = "Asynchronous Python client for the AdGuard Home API."
HOMEPAGE = "https://github.com/frenck/python-adguardhome"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=e9781798cd53ef5cc35225d21c15f5ea"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "e3b79ac5d63824490b3bac53f31b7f4d59ca9ca5e5c90ff79858ce81f8e80047"

inherit pypi python_poetry_core

PYPI_PACKAGE = "adguardhome"

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.0.0) \
    python3-core (>=3.11) \
    python3-yarl (>=1.6.0) \
"
