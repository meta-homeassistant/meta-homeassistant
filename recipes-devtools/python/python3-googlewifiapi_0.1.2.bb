SUMMARY = "Asynchronous Python wrapper for the local Google Wifi JSON API"
DESCRIPTION = "An asynchronous Python client for reading status from the local \
    JSON API exposed by Google Wifi routers. The package is designed \
    for integrations such as Home Assistant, but can be used by any \
    Python application that needs router status data."
HOMEPAGE = "https://github.com/EReaso/GoogleWifiApi"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=a0bdafec73074322ab764f1817909cdb"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

# The PyPI sdist lacks tests/conftest.py, which the tests import.
SRC_URI = "git://github.com/EReaso/GoogleWifiApi.git;protocol=https;branch=main;tag=v${PV}"
SRCREV = "c3456fdf63670e679cc88c4a8224006c06760736"

inherit python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-aiohttp \
    python3-mashumaro \
    python3-yarl \
"

RDEPENDS:${PN}-ptest += "\
    python3-aioresponses \
    python3-pytest-asyncio \
"

# The pytest configuration lives in pyproject.toml.
do_install_ptest:append() {
    install -m 0644 ${S}/pyproject.toml ${D}${PTEST_PATH}/
}
