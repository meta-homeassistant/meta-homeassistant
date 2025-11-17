SUMMARY = "Pure-python FinTS 3.0 (formerly known as HBCI) implementation"
HOMEPAGE = "https://github.com/raphaelm/python-fints"
LICENSE = "LGPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=e6a600fd5e1d9cbde2d983680233ad02"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "9ce2adc84a34d61fca89d695aafffd7b07f537c4c16015139a29c3706cc36591"

inherit pypi python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} += "\
	python3-bleach \
	python3-enum-tools \
	python3-mt-940 \
	python3-requests \
	python3-sepaxml (>=2.1) \
"

PYPI_PACKAGE = "fints"
