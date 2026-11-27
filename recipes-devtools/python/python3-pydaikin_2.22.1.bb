SUMMARY = "Python Daikin HVAC appliances interface"
HOMEPAGE = "https://github.com/fredrike/pydaikin"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI = "\
    git://github.com/fredrike/pydaikin;protocol=https;tag=v${PV};branch=master \
    file://run-ptest \
"
SRCREV = "e8ecca00ff2bb23334c2f52f002955dd76a90625"

inherit python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-aiohttp \
    python3-psutil \
    python3-tenacity \
    python3-urllib3 \
"

RDEPENDS:${PN}-ptest += "\
    python3-aresponses \
    python3-freezegun \
    python3-pytest-asyncio \
    python3-pytest-cov \
"
