SUMMARY = "Fast, correct Python JSON library supporting dataclasses, datetimes, and numpy"
HOMEPAGE = "https://pypi.org/project/orjson/"
LICENSE = "Apache-2.0 | MIT"
LIC_FILES_CHKSUM = "file://LICENSE-APACHE;md5=1836efb2eb779966696f473ee8540542"

# require ${BPN}-crates.inc

PYPI_PACKAGE = "orjson"

SRC_URI[sha256sum] = "0a78bbda3aea0f9f079057ee1ee8a1ecf790d4f1af88dd67493c6b8ee52506ff"
SRC_URI:append = " \
    file://0001-Fix-compilation-error-for-orjson.patch \
"

inherit pypi python_maturin
