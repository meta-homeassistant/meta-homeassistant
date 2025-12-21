SUMMARY = "A library to communicate with Switchbot"
HOMEPAGE = "https://github.com/sblibs/pySwitchbot"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5d503272f52c35147ec960cb56a03bf4"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI = "git://github.com/sblibs/pySwitchbot.git;protocol=https;branch=master"
SRC_URI[sha256sum] = "36eed884a7dcdfaa3a18bdf08c4d8530c4b59168ab02aa9585fbcefcfd53fd75"
SRCREV = "36a3ecaef0232c5d9e72fae9e01eac4e385b888f"

inherit setuptools3 ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-aiohttp (>=3.9.5)  \
    python3-bleak (>=0.19.0) \
    python3-bleak-retry-connector (>=3.4.0) \
    python3-cryptography (>=39.0.0) \
    python3-pyopenssl (>=23.0.0) \
"
