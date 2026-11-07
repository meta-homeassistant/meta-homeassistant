SUMMARY = "Python library for EDL21 smart meters using Smart Message Language (SML)"
HOMEPAGE = "https://github.com/mtdcr/pysml"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1d47ee609473f8daf8d7749baae1d496"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "f783446ce1206864a066f24336e6fe0a2e673d72ecf6ac4a16496f8a42af976c"

inherit pypi python_poetry_core

RDEPENDS:${PN} = "\
    python3-serialx \
    python3-aiohttp (>=3.8.4) \
    python3-bitstring (>=3.1) \
"
