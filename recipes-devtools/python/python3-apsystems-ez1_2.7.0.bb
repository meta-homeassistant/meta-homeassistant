SUMMARY = "The APsystems EZ1 Python library offers a streamlined interface for interacting with the local API of APsystems EZ1 Microinverters."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=705eda28b40f65a9325c00bd169c2c0d"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "6d97959d487bce657bf4b296837197df09537eb406ad2f629d6063cf25f880b8"

inherit pypi python_poetry_core

PYPI_PACKAGE = "apsystems_ez1"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
RDEPENDS:${PN} = "python3-aiohttp"
