SUMMARY = "A run function for asyncio-based apps that does all the boilerplate."
HOMEPAGE = "https://github.com/cjrh/aiorun"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e3fc50a88d0a364313df4b21ef20c29e"

SRC_URI[sha256sum] = "c9911e414b6eb4f32ed50c964c4b8fded072dfd09b7fae6b953b9694bf7d0deb"

inherit pypi python_flit_core

PYPI_PACKAGE = "aiorun"
