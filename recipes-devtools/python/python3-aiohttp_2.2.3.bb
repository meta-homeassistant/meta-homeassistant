SUMMARY = "http client/server for asyncio"
HOMEPAGE = "https://github.com/KeepSafe/aiohttp/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=60dd5a575c9bd4339411bdef4a702d46"

inherit pypi setuptools3

SRC_URI += "file://0001-Improve-make-clean-compatibility.patch"

SRC_URI[md5sum] = "7793829c8c2fed46f798e9c75bb68869"
SRC_URI[sha256sum] = "997d89e884c6b90a7a891b676f65ca30ca331ceab0b2db6810210b4a984c87f8"

RDEPENDS_${PN} = "${PYTHON_PN}-async-timeout ${PYTHON_PN}-chardet ${PYTHON_PN}-multidict ${PYTHON_PN}-yarl"
