SUMMARY = "A Python-based socket client for Global Cache GC100 digital I/O interface"
HOMEPAGE = "https://github.com/davegravy/python-gc100"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=f0a3e4a2554ebb89c046c93d45d8e4bc"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "b61b8098951ccd3a4acbfc99b95a866372b77f28a6c363d6feb1a2ca2edbc02e"

inherit pypi setuptools3

PYPI_PACKAGE = "python-gc100"
