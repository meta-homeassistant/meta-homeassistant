DESCRIPTION = "End-to-End encryption with SNI proxy on top of a TCP multiplexer."
HOMEPAGE = "https://github.com/NabuCasa/snitun"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

inherit pypi python_setuptools_build_meta

SRC_URI[sha256sum] = "eabac3f32cd9e0e2e2decb2d98405341236914133d6a36b7396f018f0dc04c00"

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.9.3) \
    python3-async-timeout (>=3.0.1) \
    python3-attrs (>=18.2.0) \
    python3-cryptography (>=2.5) \
"
