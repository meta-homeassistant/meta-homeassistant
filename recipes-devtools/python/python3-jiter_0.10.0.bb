SUMMARY = "Fast iterable JSON parser."
HOMEPAGE = "https://github.com/pydantic/jiter/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://crates/jiter/LICENSE;md5=aa97bb3778992892e226b4504b83b60c"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "07a7142c38aacc85194391108dc91b5b57093c978a9932bd86a36862759d9500"

inherit pypi python_maturin cargo-update-recipe-crates

require ${BPN}-crates.inc

PYPI_PACKAGE = "jiter"
