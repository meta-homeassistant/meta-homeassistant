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

SRC_URI[sha256sum] = "7a5baef8a4284405d96c90c7c62b755e9ef1ada84c2406c24a9ebec86b89f46d"
SRC_URI:append = " \
    file://0001-Fix-compilation-error-for-orjson.patch \
"

inherit pypi python_pyo3 python_setuptools_build_meta

do_configure() {
    python_pyo3_do_configure
    cargo_common_do_configure
    python_pep517_do_configure
}
