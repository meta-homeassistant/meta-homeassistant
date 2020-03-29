SUMMARY = "http client/server for asyncio"
HOMEPAGE = "https://github.com/KeepSafe/aiohttp/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=cf056e8e7a0a5477451af18b7b5aa98c"

inherit pypi setuptools3

#SRC_URI += "file://0001-Improve-make-clean-compatibility.patch"

SRC_URI[md5sum] = "a3706ef8dc9128ed98dcb6bfe1c8e116"
SRC_URI[sha256sum] = "fc55b1fec0e4cc1134ffb09ea3970783ee2906dc5dfd7cd16917913f2cfed65b"

RDEPENDS_${PN} = "\
    ${PYTHON_PN}-attrs (>=17.3.0) \
    ${PYTHON_PN}-chardet (>=2.0) \
    ${PYTHON_PN}-multidict (>=4.0) \
    ${PYTHON_PN}-async-timeout (>=3.0) \
    ${PYTHON_PN}-yarl (>=1.0) \
"
