SUMMARY = "Asyncio response mocking. Similar to the responses library used for 'requests'"
HOMEPAGE = "https://github.com/aresponses/aresponses"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ca879580c64495f9230fff6bdd8d6a5"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "8731d0609fe4c954e21f17753dc868dca9e2e002b020a33dc9212004599b11e7"

SRC_URI += "file://run-ptest"

inherit pypi setuptools3 ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-aiohttp \
    python3-pytest-asyncio \
"

RDEPENDS:${PN}-ptest += "\
    python3-pytest-asyncio \
    python3-pytest-aiohttp \
    python3-pytest-cov \
"

PYPI_PACKAGE = "aresponses"
