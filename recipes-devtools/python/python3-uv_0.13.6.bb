SUMMARY = "An extremely fast Python package and project manager, written in Rust."
HOMEPAGE = "https://pypi.org/project/uv/"
LICENSE = "Apache-2.0 AND BSD-2-Clause AND MIT"
LIC_FILES_CHKSUM = "file://LICENSE-APACHE;md5=86d3f3a95c324c9479bd8986968f4327 \
                    file://LICENSE-MIT;md5=45674e482567aa99fe883d3270b11184 \
                    file://crates/uv-build-frontend/src/pipreqs/LICENSE;md5=e3fc50a88d0a364313df4b21ef20c29e \
                    file://crates/uv-extract/src/vendor/LICENSE;md5=4001698e3c1bdee9cfbf361f55a32a1c \
                    file://crates/uv-netrc/LICENSE;md5=cf9e7952aebfc4ac2db048a50263afaa \
                    file://crates/uv-pep440/License-Apache;md5=e23fadd6ceef8c618fc1c65191d846fa \
                    file://crates/uv-pep440/License-BSD;md5=ef7a6027dc4c2389b9afad7e690274c7 \
                    file://crates/uv-pep508/License-Apache;md5=e23fadd6ceef8c618fc1c65191d846fa \
                    file://crates/uv-pep508/License-BSD;md5=ef7a6027dc4c2389b9afad7e690274c7 \
                    file://crates/uv-python-interpreter/python/packaging/LICENSE.APACHE;md5=2ee41112a44fe7014dce33e26468ba93 \
                    file://crates/uv-python-interpreter/python/packaging/LICENSE.BSD;md5=7bef9bf4a8e4263634d0597e7ba100b8"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

require ${BPN}-crates.inc

# The uv-python-managed build script compresses its metadata with the zstd
# crate, so zstd-sys is built for the build host as well. zstd-sys links the
# library from pkg-config statically, and the libzstd.a of zstd-native is not
# built position independent, so the build script fails to link. Let zstd-sys
# build its bundled zstd (1.5.7, the same version as OE-Core's) for host and
# target instead of using the system library.
do_compile:prepend() {
    unset ZSTD_SYS_USE_PKG_CONFIG
}

SRC_URI[sha256sum] = "d762215478854f6cf20c3faed8f1eb30c8101d568e7bc32a3abafc063929d5c5"

inherit pypi python_maturin cargo-update-recipe-crates pkgconfig

INSANE_SKIP:${PN} = "already-stripped"
