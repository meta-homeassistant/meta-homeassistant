SUMMARY = "Asynchronous Python client for Peblar EV chargers."
HOMEPAGE = "https://github.com/frenck/python-peblar"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=18f35d2afe9cbfecca08a503be617daf"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS = "python3-hatchling-native"
SRC_URI[sha256sum] = "b490b4c979e704a036e682f5a26edf2bc4a88ebb42dbd8df372e56b6e2adc61e"

inherit pypi python_hatchling ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-aiohttp (>=3.0.0) \
    python3-awesomeversion (>=22.8.0) \
    python3-backoff (>=2.2.1) \
    python3-mashumaro (>-3.10) \
    python3-orjson (>=3.9.8) \
    python3-yarl (>=1.6.0) \
"

PYPI_PACKAGE = "peblar"

RDEPENDS:${PN}-ptest += "\
    python3-coverage \
"

