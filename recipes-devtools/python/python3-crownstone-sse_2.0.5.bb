SUMMARY = "Asynchronous Python library that listens to Crownstone SSE events."
HOMEPAGE = "https://github.com/Crownstone-Community/crownstone-lib-python-sse"
LICENSE = "LGPL-3.0-only & MIT & Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE-APACHE;md5=ee74614898feab20d6ab5bc151a9b20d \
                    file://LICENSE-LGPL;md5=e6a600fd5e1d9cbde2d983680233ad02 \
                    file://LICENSE-MIT;md5=417c5f11876a875e4b041c01250ab49d"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "454aa8ebc50054657e2666ae2ac1a5a7b746f05ce2c470439ebdde868fc841d6"

inherit pypi setuptools3 ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-aiohttp (>=3.7) \
    python3-certifi \
"

PYPI_PACKAGE = "crownstone_sse"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
