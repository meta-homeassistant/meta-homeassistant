SUMMARY = "Yet another URL library"
HOMEPAGE = "https://github.com/aio-libs/yarl/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e3fc50a88d0a364313df4b21ef20c29e"

inherit pypi setuptools3

SRC_URI[md5sum] = "055d1386dfc269c37785508b07d82665"
SRC_URI[sha256sum] = "a7818b0654265623525b56e78b901315a9ffb7ef0bf21b4af7e0e27572d54dec"

RDEPENDS_${PN} = "${PYTHON_PN}-multidict"
