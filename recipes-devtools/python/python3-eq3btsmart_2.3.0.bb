SUMMARY = "Python library to interact with eQ-3 Bluetooth Smart thermostats"
HOMEPAGE = "https://github.com/eulemitkeule/eq3btsmart"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=bf5fb2a10583f6fee2a78fd69b9452ae"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "19b30a17e7302a32f3f5900a721e060c1990f67bbe2d344e6c6ad0806f70f50a"

inherit pypi python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} += "\
	python3-bleak \
	python3-bleak-retry-connector \
	python3-construct-typing \
"

PYPI_PACKAGE = "eq3btsmart"
