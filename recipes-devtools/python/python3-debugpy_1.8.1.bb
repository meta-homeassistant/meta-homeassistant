SUMMARY = "An implementation of the Debug Adapter Protocol for Python"
HOMEPAGE = "https://github.com/microsoft/debugpy/"
LICENSE = "MIT & MIT"
LIC_FILES_CHKSUM = "\
    file://LICENSE;md5=7b6b095fe2a2e2b66cb08d295b605789 \
    file://src/debugpy/_vendored/pydevd/_pydevd_frame_eval/vendored/bytecode-0.13.0.dev0.dist-info/COPYING;md5=e5c0e2e0aeeb3e06da2c420ede1eefa8 \
"

SRC_URI[sha256sum] = "f696d6be15be87aef621917585f9bb94b1dc9e8aced570db1b8a6fc14e8f9b42"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE_EXT = "zip"
