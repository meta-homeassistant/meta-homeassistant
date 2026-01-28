SUMMARY = "Python implementation of Aurora Protocol"
HOMEPAGE = "https://gitlab.com/energievalsabbia/aurorapy"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=ed3143bc9b0ea9d087466e385dd393b0"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "9905d05f5eb866b20dadf1eb1763cf46b4109ff080f0964145c1e562544a2ab5"

inherit pypi setuptools3 ptest-python-pytest

RDEPENDS:${PN} += "python3-future python3-pyserial"

RDEPENDS:${PN}-ptest:append = "\
    python3-six \
"

PTEST_PYTEST_DIR = "test"

PYPI_PACKAGE = "aurorapy"
