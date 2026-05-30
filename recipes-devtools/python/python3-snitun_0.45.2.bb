DESCRIPTION = "End-to-End encryption with SNI proxy on top of a TCP multiplexer."
HOMEPAGE = "https://github.com/NabuCasa/snitun"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

inherit pypi python_setuptools_build_meta

SRC_URI[sha256sum] = "ca1768833bd8d2e97f3986d2bc0230ad3ac8a28f12eae2c0ba163a8f23fcd512"

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.9.3) \
    python3-cryptography (>=2.5) \
"
