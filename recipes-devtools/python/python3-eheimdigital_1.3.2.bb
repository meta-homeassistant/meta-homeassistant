SUMMARY = "Offers a Python API for the EHEIM Digital smart aquarium devices."
HOMEPAGE = "https://codeberg.org/autinerd/eheimdigital"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8addaa1c6ef4e78a2c320750041e629b"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "40eee365955f42841fad90e84e140330a4f45536a96328bad4f9eba24925a279"

inherit pypi python_hatchling ptest-python-pytest

RDEPENDS:${PN} += "\
	python3-aiohttp \
	python3-yarl \
"

PYPI_PACKAGE = "eheimdigital"
