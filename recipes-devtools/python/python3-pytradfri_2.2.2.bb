SUMMARY = "A python library for communicating with the Tradfri Gateway"
HOMEPAGE = "https://github.com/ggravlingen/pytradfri"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=126820a16b0ae85f4bc6d60023fa0894"

inherit pypi setuptools3

SRC_URI[md5sum] = "61ee61d08a9842b674bbc811156a2354"
SRC_URI[sha256sum] = "72b9de800622cf6663228d1ffa473cd0c060508a83ff409a492e2c65ee5755d4"

RDEPENDS_${PN} = "${PYTHON_PN}-aiocoap"
