SUMMARY = "Asynchronous Python client for Internet Printing Protocol (IPP)"
DESCRIPTION = "Asynchronous Python client for the Internet Printing Protocol (IPP), \
    a maintained fork of pyipp."
HOMEPAGE = "https://github.com/brianegge/aioipp"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4a8a03ceb18c4f191643ef270d79452c"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

# The PyPI sdist does not contain the test suite.
SRC_URI = "git://github.com/brianegge/aioipp.git;protocol=https;branch=main;tag=${PV}"
SRCREV = "23048456513886726a2c816c561fda9c8dc2d6a6"

inherit python_poetry_core ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-aiohttp \
    python3-awesomeversion \
    python3-deepmerge \
    python3-yarl \
"

RDEPENDS:${PN}-ptest += "\
    python3-aresponses \
    python3-pytest-asyncio \
    python3-syrupy \
"

# The pytest configuration lives in pyproject.toml.
do_install_ptest:append() {
    install -m 0644 ${S}/pyproject.toml ${D}${PTEST_PATH}/
    # Coverage needs the covdefaults plugin and is not a test result.
    sed -i '/^addopts = "--cov"$/d' ${D}${PTEST_PATH}/pyproject.toml
}

# The release workflow sets the version; the tagged pyproject.toml says 0.0.0.
do_configure:prepend() {
    sed -i 's/^version = "0.0.0"/version = "${PV}"/' ${S}/pyproject.toml
}
