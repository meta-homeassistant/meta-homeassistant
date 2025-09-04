SUMMARY = "iCalendar parser/generator"
HOMEPAGE = "https://icalendar.readthedocs.io/"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.rst;md5=1b2957cd26c589d0defcb357be630e80"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "a697ce7b678072941e519f2745704fc29d78ef92a2dc53d9108ba6a04aeba466"

DEPENDS = "python3-hatch-vcs-native"

inherit pypi python_hatchling

RDEPENDS:${PN} += "\
	python3-dateutil \
	python3-tzdata \
"

PYPI_PACKAGE = "icalendar"
