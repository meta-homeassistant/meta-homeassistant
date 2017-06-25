SUMMARY = "A JSON-RPC websocket client library for asyncio"
HOMEPAGE = "http://github.com/armills/jsonrpc-websocket"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=9535ae79c9d2a6e803c0603c6e004747"

inherit pypi setuptools3

SRC_URI[md5sum] = "7d7fa81ff1a71c9b89fb8d31cad1c5d0"
SRC_URI[sha256sum] = "04c30808f9dd21713f9b77e357418a5751d31e90baf8a45bc131ededd0c23232"

RDEPENDS_${PN} = "${PYTHON_PN}-jsonrpc-base ${PYTHON_PN}-aiohttp"
