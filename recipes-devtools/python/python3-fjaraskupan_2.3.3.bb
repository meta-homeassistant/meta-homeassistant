SUMMARY = "A python library for speaking to fjäråskupan"
HOMEPAGE = "https://github.com/elupus/fjaraskupan"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=11afde19ff9d72b16eafac777ea8ca32"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "9647f5f40029de1c087ad8342baef5d875fae30b5be38de9654cbdac12ac06a1"

inherit pypi python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN}-ptest += "\
	python3-mock \	
"

RDEPENDS:${PN} += "\
	python3-bleak (>=0.19) \
	python3-bleak-retry-connector (>=4.4.3) \
"

PYPI_PACKAGE = "fjaraskupan"
