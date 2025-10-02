SUMMARY = "Fast, correct Python JSON library supporting dataclasses, datetimes, and numpy"
HOMEPAGE = "https://github.com/ijl/orjson"
LICENSE = "Apache-2.0 | MIT"
LIC_FILES_CHKSUM = "file://LICENSE-APACHE;md5=1836efb2eb779966696f473ee8540542"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

require ${BPN}-crates.inc

PYPI_PACKAGE = "orjson"

SRC_URI[sha256sum] = "1c0603b1d2ffcd43a411d64797a19556ef76958aef1c182f22dc30860152a98a"
SRC_URI:append = " \
    file://0001-Fix-compilation-error-for-orjson.patch \
"

RDEPENDS:${PN} += "\
    python3-zoneinfo \
"

inherit pypi python_maturin ptest-python-pytest

PTEST_PYTEST_DIR = "test"
