SUMMARY = "http client/server for asyncio"
HOMEPAGE = "https://github.com/KeepSafe/aiohttp/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=60dd5a575c9bd4339411bdef4a702d46"

inherit pypi setuptools3

SRC_URI += "file://0001-Improve-make-clean-compatibility.patch file://0002-downgrade-multidict-to-2.9.6.patch"

SRC_URI[md5sum] = "b8683d16f4e45fbb5a28bae5d7dc1ea7"
SRC_URI[sha256sum] = "0111b4c71d1121bfcbd392bbabd573d20f133f491161b87718a07976e0459c32"

RDEPENDS_${PN} = "${PYTHON_PN}-async-timeout ${PYTHON_PN}-chardet ${PYTHON_PN}-multidict ${PYTHON_PN}-yarl"
