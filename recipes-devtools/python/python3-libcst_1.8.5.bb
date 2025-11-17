SUMMARY = "A concrete syntax tree with AST-like properties"
HOMEPAGE = "https://github.com/Instagram/LibCST"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "\
    file://LICENSE;md5=bb0bb1a5e064e5019d855a2d28147544 \
    file://native/libcst/LICENSE;md5=bb0bb1a5e064e5019d855a2d28147544 \
    file://native/libcst/src/tokenizer/core/LICENSE;md5=baa042022c799cfd984b3354c4c1ccc1 \
    file://native/libcst_derive/LICENSE;md5=bb0bb1a5e064e5019d855a2d28147544 \
"

SRC_URI[sha256sum] = "e72e1816eed63f530668e93a4c22ff1cf8b91ddce0ec53e597d3f6c53e103ec7"

DEPENDS += "python3-setuptools-scm-native"

require ${BPN}-crates.inc

inherit pypi python_setuptools3_rust cargo-update-recipe-crates

PYPI_PACKAGE = "libcst"
