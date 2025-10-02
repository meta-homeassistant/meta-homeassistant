SUMMARY = "Deebot client library in python 3"
HOMEPAGE = "https://github.com/DeebotUniverse/client.py"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=d32239bcb673463ab874e80d47fae504"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "9ab1684265583bc89a0e2bbcae3212be5aaef4236c7bcb6a639a84e59221ee40"

require ${BPN}-crates.inc

inherit pypi python_maturin cargo-update-recipe-crates

RDEPENDS:${PN} += "\
	python3-aiohttp (>=3.10) \
	python3-aiomqtt (>=2.0.0) \
	python3-cachetools (>=5.0.0) \
	python3-defusedxml (>=0.7.1) \
"
PYPI_PACKAGE = "deebot_client"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
