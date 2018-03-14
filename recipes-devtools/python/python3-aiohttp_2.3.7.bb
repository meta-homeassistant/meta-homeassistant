SUMMARY = "http client/server for asyncio"
HOMEPAGE = "https://github.com/KeepSafe/aiohttp/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=60dd5a575c9bd4339411bdef4a702d46"

inherit pypi setuptools3

SRC_URI += "file://0001-Improve-make-clean-compatibility.patch"

SRC_URI[md5sum] = "c78ea2441fb3e9dc817d31d19447c88c"
SRC_URI[sha256sum] = "fe294df38e9c67374263d783a7a29c79372030f5962bd5734fa51c6f4bbfee3b"

RDEPENDS_${PN} = "\
    ${PYTHON_PN}-async-timeout \
    ${PYTHON_PN}-chardet \
    ${PYTHON_PN}-multidict \
    ${PYTHON_PN}-yarl \
    "
