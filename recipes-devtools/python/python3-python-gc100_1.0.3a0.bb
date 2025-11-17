SUMMARY = "A Python-based socket client for Global Cache GC100 digital I/O interface"
HOMEPAGE = "https://github.com/davegravy/python-gc100"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=9;endline=9;md5=845e560ecc39395e8f142a154032aec7"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "b61b8098951ccd3a4acbfc99b95a866372b77f28a6c363d6feb1a2ca2edbc02e"

inherit pypi setuptools3

PYPI_PACKAGE = "python-gc100"
