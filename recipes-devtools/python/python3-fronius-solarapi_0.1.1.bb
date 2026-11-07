SUMMARY = "Async Python library for the Fronius Solar API (v0 and v1), built on aiohttp"
DESCRIPTION = "Async Python library for the Fronius Solar API, the JSON interface \
    of Fronius Datamanager, Datalogger Web, Symo Hybrid and \
    GEN24/Tauro/Verto devices. Built on aiohttp."
HOMEPAGE = "https://github.com/farmio/fronius-solarapi"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

# The PyPI sdist does not contain the test suite.
SRC_URI = "git://github.com/farmio/fronius-solarapi.git;protocol=https;branch=main;tag=${PV}"
SRCREV = "de024eb0f12e8e2876a302fede98e068ad4fe239"

inherit python_hatchling ptest-python-pytest

DEPENDS += "python3-hatch-vcs-native"

RDEPENDS:${PN} += "\
    python3-aiohttp \
"

RDEPENDS:${PN}-ptest += "\
    python3-pytest-asyncio \
    python3-syrupy \
"

# The pytest configuration lives in pyproject.toml.
do_install_ptest:append() {
    install -m 0644 ${S}/pyproject.toml ${D}${PTEST_PATH}/
}
