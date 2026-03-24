SUMMARY = "A library to communicate with Switchbot"
HOMEPAGE = "https://github.com/sblibs/pySwitchbot"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5d503272f52c35147ec960cb56a03bf4"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI = "git://github.com/sblibs/pySwitchbot.git;protocol=https;branch=master"
SRCREV = "735f7113e57704ceec6066337782149fcb311ae2"

inherit python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-aiohttp (>=3.9.5)  \
    python3-bleak (>=0.19.0) \
    python3-bleak-retry-connector (>=3.4.0) \
    python3-cryptography (>=39.0.0) \
    python3-pyopenssl (>=23.0.0) \
"

RDEPENDS:${PN}-ptest:append = "\
    python3-pytest-asyncio \
    python3-pytest-cov \
"
