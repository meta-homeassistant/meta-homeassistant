SUMMARY = "Offers a Python API for the EHEIM Digital smart aquarium devices."
HOMEPAGE = "https://codeberg.org/autinerd/eheimdigital"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8addaa1c6ef4e78a2c320750041e629b"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "713440ae1c1f69f34bec19e4add83b5cddb2eb4dc74d7cc04f341d2d78ad5758"

inherit pypi python_hatchling ptest-python-pytest

RDEPENDS:${PN} += "\
	python3-aiohttp \
	python3-yarl \
"

PYPI_PACKAGE = "eheimdigital"
