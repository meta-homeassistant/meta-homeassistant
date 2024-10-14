SUMMARY = "Fast, correct Python JSON library supporting dataclasses, datetimes, and numpy"
HOMEPAGE = "https://pypi.org/project/orjson/"
LICENSE = "Apache-2.0 | MIT"
LIC_FILES_CHKSUM = "file://LICENSE-APACHE;md5=1836efb2eb779966696f473ee8540542"

PYPI_PACKAGE = "orjson"

SRC_URI[sha256sum] = "75ef0640403f945f3a1f9f6400686560dbfb0fb5b16589ad62cd477043c4eee3"
SRC_URI:append = " \
    file://0001-Fix-compilation-error-for-orjson.patch \
"

inherit pypi cargo-update-recipe-crates python_maturin
