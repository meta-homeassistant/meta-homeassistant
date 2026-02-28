SUMMARY = "Python bindings to Rust's UUID library."
HOMEPAGE = "https://github.com/thedrow/fastuuid/"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=73a37d981c6a860934883c0ca46cce90"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

require ${BPN}-crates.inc

DEPENDS = "python3-maturin-native"
SRC_URI[sha256sum] = "178947fc2f995b38497a74172adee64fdeb8b7ec18f2a5934d037641ba265d26"

inherit pypi python_maturin cargo-update-recipe-crates ptest-python-pytest

RDEPENDS:${PN}-ptest:append = "\
    python3-hypothesis \
    python3-pytest-benchmark \
    python3-uuid7 \
    python3-misc \
"

PYPI_PACKAGE = "fastuuid"
