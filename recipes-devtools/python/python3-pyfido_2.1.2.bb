SUMMARY = "Get your Fido consumption (wwww.fido.ca)"
HOMEPAGE = "http://github.com/titilambert/pyfido"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=b896a8549bbd6d5a504c62d1462c320b"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "861da0e3a1950a488c1c49443fa31c63c15dcc6373655ee9800e43421a1d3f6d"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-aiohttp"

PYPI_PACKAGE = "pyfido"
