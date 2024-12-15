DESCRIPTION = "Rule-based number formatting using Unicode CLDR data"
HOMEPAGE = "https://github.com/rhasspy/unicode-rbnf"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=2aa2bed6f8750823223a2c11d7bc90c5"

inherit python_setuptools_build_meta

SRC_URI = "git://github.com/rhasspy/unicode-rbnf;protocol=https;branch=master"

SRCREV = "6a84331e8a63244e9ac550fbb9a1345fe23f63db"

S = "${WORKDIR}/git"
