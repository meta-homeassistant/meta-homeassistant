SUMMARY = "http client/server for asyncio"
HOMEPAGE = "https://github.com/KeepSafe/aiohttp/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=c76b717025e9f23e50092cd39a213d56"

inherit pypi setuptools3

SRC_URI += "file://0001-Improve-make-clean-compatibility.patch"

SRC_URI[md5sum] = "cd85befc78bb54594974fb932dc3949c"
SRC_URI[sha256sum] = "5b588d21b454aaeaf2debf3c4a37f0752fb91a5c15b621deca7e8c49316154fe"

RDEPENDS_${PN} = "\
    ${PYTHON_PN}-async-timeout \
    ${PYTHON_PN}-chardet \
    ${PYTHON_PN}-idna-ssl \
    ${PYTHON_PN}-multidict \
    ${PYTHON_PN}-yarl \
    "
