SUMMARY = "http client/server for asyncio"
HOMEPAGE = "https://github.com/KeepSafe/aiohttp/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=d4ae7def6b740abc020a2700493fef4e"

inherit pypi setuptools3

SRC_URI += "file://0001-Improve-make-clean-compatibility.patch"

SRC_URI[md5sum] = "fac473aa71b5e49a6978b5bcc393a7ef"
SRC_URI[sha256sum] = "cd14a45da385b5e860849ffaff3ecee56f9b37bf9e7f3f7bc5ce3f17556cf842"

RDEPENDS_${PN} = "${PYTHON_PN}-async-timeout ${PYTHON_PN}-chardet ${PYTHON_PN}-multidict ${PYTHON_PN}-yarl"
