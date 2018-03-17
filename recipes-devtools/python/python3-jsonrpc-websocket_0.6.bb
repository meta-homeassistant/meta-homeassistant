SUMMARY = "A JSON-RPC websocket client library for asyncio"
HOMEPAGE = "http://github.com/armills/jsonrpc-websocket"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=9535ae79c9d2a6e803c0603c6e004747"

inherit pypi setuptools3

SRC_URI[md5sum] = "d71261b0cd63e58525d5a9968bbea5af"
SRC_URI[sha256sum] = "cf349bee4ab96db2e457b6a71a45380e1a9cf3e1ceb08260ecfd9928040ebe71"

RDEPENDS_${PN} = "\
    ${PYTHON_PN}-jsonrpc-base \
    ${PYTHON_PN}-aiohttp \
    "
