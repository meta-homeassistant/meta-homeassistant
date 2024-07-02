DESCRIPTION = "Rule-based number formatting using Unicode CLDR data"
HOMEPAGE = "https://github.com/rhasspy/unicode-rbnf"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=2aa2bed6f8750823223a2c11d7bc90c5"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "unicode_rbnf"
PYPI_SRC_URI = "git://github.com/rhasspy/unicode-rbnf;protocol=https;branch=master"

SRCREV = "f0010272f1076cfc5abc179e21c418ed689857d5"

S = "${WORKDIR}/git"
