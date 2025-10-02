SUMMARY = "Python library for EDL21 smart meters using Smart Message Language (SML)"
HOMEPAGE = "https://github.com/mtdcr/pysml"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1d47ee609473f8daf8d7749baae1d496"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "753eba9b8be2006d16d6cf276dd2fdf4b0005cb4f0f537dc26458e9f11ae36c9"

inherit pypi python_poetry_core

PYPI_PACKAGE = "pysml"
RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.8.4) \
    python3-pyserial-asyncio-fast (>=0.16) \
    python3-bitstring (>=3.1) \
"
