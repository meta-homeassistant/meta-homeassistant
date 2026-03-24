SUMMARY = "Python Daikin HVAC appliances interface"
HOMEPAGE = "https://github.com/fredrike/pydaikin"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI = "git://github.com/fredrike/pydaikin;protocol=https;tag=v${PV};branch=master"
SRCREV = "a165a43f6420322d3c90efd1b989f2b2f830aabf"

SRC_URI += "file://run-ptest"

inherit python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-netifaces \
    python3-aiohttp \
    python3-urllib3 \
    python3-tenacity \
"

RDEPENDS:${PN}-ptest += "\
    python3-freezegun \
    python3-pytest-asyncio \
    python3-pytest-cov \
    python3-aresponses \
"

PYPI_PACKAGE = "pydaikin"
