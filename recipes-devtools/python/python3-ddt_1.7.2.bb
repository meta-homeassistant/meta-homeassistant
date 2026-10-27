SUMMARY = "Data-Driven/Decorated Tests"
DESCRIPTION = "A library for data-driven testing with Python unittest."
HOMEPAGE = "https://github.com/datadriventests/ddt"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=31d3abdb5983f06c0f7c19f4b9f61830"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "d215d6b083963013c4a19b1e4dcd6a96e80e43ab77519597a6acfcf2e9a3e04b"

inherit pypi setuptools3 ptest-python-pytest

PTEST_PYTEST_DIR = "test"

RDEPENDS:${PN} += "python3-json"

RDEPENDS:${PN}-ptest += "\
    python3-aiounittest \
    python3-pyyaml \
    python3-six \
"
