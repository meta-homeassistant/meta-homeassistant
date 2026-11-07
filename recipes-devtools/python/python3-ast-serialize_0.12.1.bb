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

# The sdist does not contain upstream's smoke test; fetch it from the release
# commit (v0.12.1), pinned by commit and checksum.
SRC_URI += "\
    https://raw.githubusercontent.com/mypyc/ast_serialize/8d0a5c6d1c87e29aa37c7292149086b514ccac93/test_ast_serialize.py;name=smoketest;subdir=smoketest;downloadfilename=ast-serialize-${PV}-test_ast_serialize.py \
    file://run-ptest \
"
SRC_URI[smoketest.sha256sum] = "000eb0b26048e9066c1ae11bb4e24712f356b7a5c6c2bead79393240381a9705"

inherit pypi python_maturin cargo-update-recipe-crates ptest

do_install_ptest() {
    install -m 0644 ${UNPACKDIR}/smoketest/ast-serialize-${PV}-test_ast_serialize.py ${D}${PTEST_PATH}/test_ast_serialize.py
}
