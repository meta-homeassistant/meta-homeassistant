SUMMARY = "Yet another URL library"
HOMEPAGE = "https://github.com/aio-libs/yarl/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e3fc50a88d0a364313df4b21ef20c29e"

inherit pypi setuptools3

SRC_URI[md5sum] = "f109f3e2fc5d1a09309afa714591921f"
SRC_URI[sha256sum] = "d92947434946bf47e3ee2123f4ea785ea4c7d5ba37c93fd2142470868dc2a01b"

RDEPENDS_${PN} = "${PYTHON_PN}-multidict"
