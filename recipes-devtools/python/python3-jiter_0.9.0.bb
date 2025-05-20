SUMMARY = "Fast iterable JSON parser."
HOMEPAGE = "https://github.com/pydantic/jiter/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://crates/jiter/LICENSE;md5=aa97bb3778992892e226b4504b83b60c"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "aadba0964deb424daa24492abc3d229c60c4a31bfee205aedbf1acc7639d7893"

inherit pypi python_maturin cargo-update-recipe-crates

require ${BPN}-crates.inc

PYPI_PACKAGE = "jiter"
