SUMMARY = "Python bindings for mypy AST serialization"
DESCRIPTION = "Parser for Python source code that serializes the abstract syntax \
    tree in the binary format mypy reads, implemented in Rust."
HOMEPAGE = "https://github.com/mypyc/ast_serialize"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=dc12afd29b3bf645cc59f9ae0d9c6700"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

require ${BPN}-crates.inc

DEPENDS += "python3-maturin-native"
SRC_URI[sha256sum] = "5285a390caf1c44368ae270f037f797b91427d138b7d43cad0f1fda4c83518d9"

SRC_URI += "file://run-ptest"

inherit pypi python_maturin cargo-update-recipe-crates ptest

do_install_ptest() {
    install -m 0644 ${S}/test_ast_serialize.py ${D}${PTEST_PATH}/
}
