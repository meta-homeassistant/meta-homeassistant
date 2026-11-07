SUMMARY = "A python library for speaking to fjäråskupan"
HOMEPAGE = "https://github.com/elupus/fjaraskupan"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=11afde19ff9d72b16eafac777ea8ca32"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "3f67384b686bf798fc9af9cba6515eed30860ac8804553a60ee69223cd6077a6"

DEPENDS += "python3-wheel-native"

inherit pypi python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN}-ptest += "\
	python3-mock \	
"

RDEPENDS:${PN} += "\
	python3-bleak (>=0.19) \
	python3-bleak-retry-connector (>=4.4.3) \
"
