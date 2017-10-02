SUMMARY = "A asyncio library for handling android ipcam"
HOMEPAGE = "https://github.com/pvizeli/pydroid-ipcam"
LICENSE = "BSD-3-Clause"
# TODO: https://github.com/pvizeli/pydroid-ipcam/pull/3
LIC_FILES_CHKSUM = "file://setup.cfg;md5=d19a419ea98ae93d7a7b66b189aa5052"

inherit pypi setuptools3

SRC_URI[md5sum] = "7edc3478bdd89496d3def3f3243be5f7"
SRC_URI[sha256sum] = "3c352528315eee292241a5aa1b42c9c3535b88e1208d1aff57f1ed196e6366db"

RDEPENDS_${PN} = "${PYTHON_PN}-async-timeout ${PYTHON_PN}-aiohttp ${PYTHON_PN}-multidict ${PYTHON_PN}-yarl"
