DESCRIPTION = "End-to-End encryption with SNI proxy on top of a TCP multiplexer."
HOMEPAGE = "https://github.com/NabuCasa/snitun"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

inherit pypi python_setuptools_build_meta

SRC_URI[sha256sum] = "fadbe447eea786291d5c52e67eae0658f53a1f68c4b97425e17a9579df503d7e"

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.9.3) \
    python3-async-timeout (>=3.0.1) \
    python3-attrs (>=18.2.0) \
    python3-cryptography (>=2.5) \
"
