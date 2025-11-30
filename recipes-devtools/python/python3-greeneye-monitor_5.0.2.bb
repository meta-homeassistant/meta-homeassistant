SUMMARY = "Receive data packets from GreenEye Monitor (http://www.brultech.com/greeneye/)"
HOMEPAGE = "https://github.com/jkeljo/greeneye-monitor"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=79b49a88b07267a066bdfdd03f064190"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "d855e2b7bdd9f73b12bab02e682c44a438ccade9385c7c4f521695cd00c7f483"

inherit pypi python_poetry_core

RDEPENDS:${PN} = "\
	python3-aiohttp (>=3.8.5) \
	python3-siobrultech-protocols (>=0.13) \
"

PYPI_PACKAGE = "greeneye_monitor"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
