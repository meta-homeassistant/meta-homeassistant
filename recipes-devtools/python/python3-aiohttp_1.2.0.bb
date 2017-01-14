SUMMARY = "http client/server for asyncio"
HOMEPAGE = "https://github.com/KeepSafe/aiohttp/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=d4ae7def6b740abc020a2700493fef4e"

inherit pypi setuptools3

SRC_URI[md5sum] = "a7b25d51bf887ec4f9b87463a6bff6d4"
SRC_URI[sha256sum] = "8ce0ab4301bf38db2ae13e4921bdb3841507919c9121373405a43c7bd0a07f78"

RDEPENDS_${PN} = "${PYTHON_PN}-async-timeout ${PYTHON_PN}-chardet ${PYTHON_PN}-multidict ${PYTHON_PN}-yarl"
