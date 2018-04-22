SUMMARY = "http client/server for asyncio"
HOMEPAGE = "https://github.com/KeepSafe/aiohttp/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=c76b717025e9f23e50092cd39a213d56"

inherit pypi setuptools3

SRC_URI += "file://0001-Improve-make-clean-compatibility.patch"

SRC_URI[md5sum] = "973b1b845a5f91e90403e1978c898068"
SRC_URI[sha256sum] = "9fcef0489e3335b200d31a9c1fb6ba80fdafe14cd82b971168c2f9fa1e4508ad"

RDEPENDS_${PN} = "\
    ${PYTHON_PN}-async-timeout \
    ${PYTHON_PN}-chardet \
    ${PYTHON_PN}-idna-ssl \
    ${PYTHON_PN}-multidict \
    ${PYTHON_PN}-yarl \
    "
