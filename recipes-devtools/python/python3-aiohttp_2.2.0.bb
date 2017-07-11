SUMMARY = "http client/server for asyncio"
HOMEPAGE = "https://github.com/KeepSafe/aiohttp/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=60dd5a575c9bd4339411bdef4a702d46"

inherit pypi setuptools3

SRC_URI += "file://0001-Improve-make-clean-compatibility.patch"

SRC_URI[md5sum] = "e50ea3d70f2d821b7e40442fb470e8ef"
SRC_URI[sha256sum] = "1558ba6896c2ed4e1b3cbdc4ba479b4a03a0c1433af2fe23704d2959a0c5191e"

RDEPENDS_${PN} = "${PYTHON_PN}-async-timeout ${PYTHON_PN}-chardet ${PYTHON_PN}-multidict ${PYTHON_PN}-yarl"
