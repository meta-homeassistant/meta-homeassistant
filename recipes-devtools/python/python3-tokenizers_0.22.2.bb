SUMMARY = "Provides an implementation of today's most used tokenizers, with a focus on performance and versatility."
HOMEPAGE = "https://github.com/huggingface/tokenizers"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://tokenizers/LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

require ${BPN}-crates.inc

DEPENDS = "python3-maturin-native"
SRC_URI[sha256sum] = "473b83b915e547aa366d1eee11806deaf419e17be16310ac0a14077f1e28f917"

inherit pypi python_maturin cargo-update-recipe-crates

RDEPENDS:${PN}:append = " \
    python3-huggingface-hub \
"

PYPI_PACKAGE = "tokenizers"
