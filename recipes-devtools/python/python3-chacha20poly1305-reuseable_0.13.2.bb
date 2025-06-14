SUMMARY = "ChaCha20Poly1305 that is reuseable for asyncio"
HOMEPAGE = "https://github.com/bdraco/chacha20poly1305-reuseable"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=89361b011ca9139ce569202482825464"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "dd8be876e25dfc51909eb35602b77a76e0d01a364584756ab3fa848e2407e4ec"

inherit pypi python_poetry_core

PYPI_PACKAGE = "chacha20poly1305_reuseable"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"

RDEPENDS:${PN} = "python3-cryptography (>=43.0.0)"
