SUMMARY = "Discover, connect and control Gree based minisplit systems"
HOMEPAGE = "https://github.com/cmroche/greeclimate"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=e49f4652534af377a713df3d9dec60cb"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "fc97f70cf96006ae3f2bbf187a3a9251bcbd25c4c2a7bbf294fa2caf2f88bc57"

inherit pypi setuptools3 ptest-python-pytest

RDEPENDS:${PN} += "python3-netifaces python3-pycryptodome"

PYPI_PACKAGE = "greeclimate"
