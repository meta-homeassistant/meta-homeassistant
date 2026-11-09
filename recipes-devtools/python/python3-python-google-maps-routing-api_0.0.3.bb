SUMMARY = "A python client library for Google Maps Routes API"
DESCRIPTION = "A python client library for Google Maps Routes API."
HOMEPAGE = "https://github.com/tronikos/python-google-maps-routing-api"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

# The PyPI sdist lacks tests/conftest.py, which the tests import.
SRC_URI = "git://github.com/tronikos/python-google-maps-routing-api.git;protocol=https;branch=main;tag=v${PV}"
SRCREV = "f6b97fa1ef456e4520f34df500b9f8f3e44554fc"

inherit python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-aiohttp \
    python3-mashumaro \
"

RDEPENDS:${PN}-ptest += "\
    python3-pytest-asyncio \
    python3-pytest-cov \
"

# The pytest configuration lives in pyproject.toml.
do_install_ptest:append() {
    install -m 0644 ${S}/pyproject.toml ${D}${PTEST_PATH}/
    # Coverage of the installed package is not a test result.
    sed -i "/^addopts = .*--cov/d" ${D}${PTEST_PATH}/pyproject.toml
}
