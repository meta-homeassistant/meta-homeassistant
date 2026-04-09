SUMMARY = "An extremely fast Python package and project manager, written in Rust."
HOMEPAGE = "https://pypi.org/project/uv/"
LICENSE = "Apache-2.0 & BSD-2-Clause & MIT"
LIC_FILES_CHKSUM = "file://LICENSE-APACHE;md5=86d3f3a95c324c9479bd8986968f4327 \
                    file://LICENSE-MIT;md5=45674e482567aa99fe883d3270b11184 \
                    file://crates/uv-build-frontend/src/pipreqs/LICENSE;md5=e3fc50a88d0a364313df4b21ef20c29e \
                    file://crates/uv-extract/src/vendor/LICENSE;md5=4001698e3c1bdee9cfbf361f55a32a1c \
                    file://crates/uv-pep440/License-Apache;md5=e23fadd6ceef8c618fc1c65191d846fa \
                    file://crates/uv-pep440/License-BSD;md5=ef7a6027dc4c2389b9afad7e690274c7 \
                    file://crates/uv-pep508/License-Apache;md5=e23fadd6ceef8c618fc1c65191d846fa \
                    file://crates/uv-pep508/License-BSD;md5=ef7a6027dc4c2389b9afad7e690274c7 \
                    file://crates/uv-python/python/packaging/LICENSE.APACHE;md5=2ee41112a44fe7014dce33e26468ba93 \
                    file://crates/uv-python/python/packaging/LICENSE.BSD;md5=7bef9bf4a8e4263634d0597e7ba100b8"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

require ${BPN}-crates.inc

DEPENDS = "python3-maturin-native"
SRC_URI[sha256sum] = "e3b21b7e80024c95ff339fcd147ac6fc3dd98d3613c9d45d3a1f4fd1057f127b"

inherit pypi python_maturin cargo-update-recipe-crates

PYPI_PACKAGE = "uv"

INSANE_SKIP:${PN} = "already-stripped"
