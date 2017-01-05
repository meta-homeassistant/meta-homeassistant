SUMMARY = "http client/server for asyncio"
HOMEPAGE = "https://github.com/KeepSafe/aiohttp/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=d4ae7def6b740abc020a2700493fef4e"

inherit pypi setuptools3

SRC_URI[md5sum] = "dc080616b14155a202288bb3dbf07f8b"
SRC_URI[sha256sum] = "0742feb9759a5832aa4a30abf64e53055e139ed41e26f79b9558d08e05c74d60"

RDEPENDS_${PN} = "${PYTHON_PN}-async-timeout ${PYTHON_PN}-chardet ${PYTHON_PN}-multidict ${PYTHON_PN}-yarl"
