SUMMARY = "Get your EBox consumption (wwww.ebox.ca)"
HOMEPAGE = "http://github.com/titilambert/pyebox"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=9a6ea5b6c346a830f54cc95f6a2a9245"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "baeb63634064257963131eb0b801a3891903c8525b128a359873df2166671aa1"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-aiohttp python3-beautifulsoup4 python3-bs4"

PYPI_PACKAGE = "pyebox"
