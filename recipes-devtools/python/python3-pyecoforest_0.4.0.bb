SUMMARY = "Python library for ecoforest local device."
HOMEPAGE = "https://github.com/pjanuario/pyecoforest"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7ef3a336aa66fb5f9cd7af98a0bb306a"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "e24e42847cd155d45d16994b3b9b45e9ba57952258a6db53374b38a03b9b4fa9"

inherit pypi python_poetry_core

PYPI_PACKAGE = "pyecoforest"
RDEPENDS:${PN} = "python3-httpx (>=0.24.0)"
