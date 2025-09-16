SUMMARY = "Structured logging for Python"
HOMEPAGE = "https://github.com/hynek/structlog"
LICENSE = "Apache-2.0 | MIT"
LIC_FILES_CHKSUM = "file://LICENSE-APACHE;md5=2ee41112a44fe7014dce33e26468ba93 \
                    file://LICENSE-MIT;md5=0473cdcf9c6ed3f81c08d886870daea5"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "186cd1b0a8ae762e29417095664adf1d6a31702160a46dacb7796ea82f7409e4"

DEPENDS += "\
	python3-hatch-vcs-native \
	python3-hatch-fancy-pypi-readme-native \
"

inherit pypi python_hatchling ptest-python-pytest

RDEPENDS:${PN}-ptest += "\
	python3-freezegun \
	python3-pretend \
	python3-pytest-asyncio \
	python3-simplejson \
" 

PYPI_PACKAGE = "structlog"
