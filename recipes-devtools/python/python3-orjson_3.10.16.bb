SUMMARY = "Fast, correct Python JSON library supporting dataclasses, datetimes, and numpy"
HOMEPAGE = "https://pypi.org/project/orjson/"
LICENSE = "Apache-2.0 | MIT"
LIC_FILES_CHKSUM = "file://LICENSE-APACHE;md5=1836efb2eb779966696f473ee8540542"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

require ${BPN}-crates.inc

PYPI_PACKAGE = "orjson"

SRC_URI[sha256sum] = "d2aaa5c495e11d17b9b93205f5fa196737ee3202f000aaebf028dc9a73750f10"
SRC_URI:append = " \
    file://0001-Fix-compilation-error-for-orjson.patch \
"

inherit pypi python_maturin
