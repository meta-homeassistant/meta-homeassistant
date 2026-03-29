SUMMARY = "An extremely fast Python linter and code formatter, written in Rust."
HOMEPAGE = "https://github.com/astral-sh/ruff"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e679ca4f742cbfa29ab6a499529c2d39"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "995f11f63597ee362130d1d5a327a87cb6f3f5eae3094c620bcc632329a4d26e"

inherit pypi python_maturin cargo-update-recipe-crates

require python3-ruff-crates.inc

# until we figured out how to trick cargo from bitbake
# to NOT ******** attempt to refresh git dependencies
# we need to enable networking in compile
do_compile[network] = "1"

PYPI_PACKAGE = "ruff"

INSANE_SKIP:${PN} += "already-stripped"
