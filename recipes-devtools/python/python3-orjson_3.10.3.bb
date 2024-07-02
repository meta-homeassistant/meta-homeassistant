SUMMARY = "Fast, correct Python JSON library supporting dataclasses, datetimes, and numpy"
HOMEPAGE = "https://pypi.org/project/orjson/"
LICENSE = "Apache-2.0 | MIT"
LIC_FILES_CHKSUM = "file://LICENSE-APACHE;md5=1836efb2eb779966696f473ee8540542"

PYPI_PACKAGE = "orjson"

DEPENDS += "\
    python3-maturin-native \
    python3-setuptools-rust \
    python3-setuptools-rust-native \
"

require ${BPN}-crates.inc

SRC_URI[sha256sum] = "2b166507acae7ba2f7c315dcf185a9111ad5e992ac81f2d507aac39193c2c818"
SRC_URI:append = " \
    file://0001-Fix-compilation-error-for-orjson.patch \
"

inherit pypi python_pyo3 python_setuptools_build_meta

do_configure() {
    python_pyo3_do_configure
    cargo_common_do_configure
    python_pep517_do_configure
}
