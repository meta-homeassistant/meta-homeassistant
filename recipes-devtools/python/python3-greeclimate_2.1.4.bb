SUMMARY = "Discover, connect and control Gree based minisplit systems"
HOMEPAGE = "https://github.com/cmroche/greeclimate"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=e49f4652534af377a713df3d9dec60cb"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI = "git://github.com/cmroche/greeclimate;protocol=https;tag=v${PV};branch=master"
SRCREV = "fc259dfe1dd0acf84a67ed370cbcf3fa299a0452"

inherit setuptools3 ptest-python-pytest

RDEPENDS:${PN} += "python3-netifaces python3-pycryptodome"

RDEPENDS:${PN}-ptest:append = " \
    python3-pytest-asyncio \
"

PYPI_PACKAGE = "greeclimate"
