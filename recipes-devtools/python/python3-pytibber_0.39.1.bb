SUMMARY = "A python3 library to communicate with Tibber"
HOMEPAGE = "https://github.com/Danielhiversen/pyTibber"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

# The PyPI sdist omits test/conftest.py and test/__init__.py, which the
# tests import from; build from the release tag so the ptest is complete.
SRC_URI = "git://github.com/Danielhiversen/pyTibber.git;protocol=https;branch=master;tag=${PV}"
SRCREV = "34bb1557175b666fe3eba6b38805a92f32ffd01d"

inherit python_setuptools_build_meta ptest-python-pytest

SRC_URI:append = " \
    file://run-ptest \
"

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.0.6) \
    python3-gql (>=4.0.0) \
    python3-tenacity (>=9.0.0) \
    python3-websockets (>=14.0) \
"

RDEPENDS:${PN}-ptest += "\
    python3-pytest-asyncio \
"

PTEST_PYTEST_DIR = "test"

do_install_ptest:append() {
    # asyncio_mode and the fixture loop scope come from pyproject.toml
    install -m 0644 ${S}/pyproject.toml ${D}${PTEST_PATH}/
}
