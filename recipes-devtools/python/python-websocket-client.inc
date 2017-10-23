SUMMARY = "WebSocket client for python. hybi13 is supported."
HOMEPAGE = "https://github.com/websocket-client/websocket-client.git"
LICENSE = "LGPL"
LIC_FILES_CHKSUM = "file://LICENSE;md5=18b09a20dd186af4fd60f1a08311628c"

inherit pypi

SRC_URI = "https://pypi.python.org/packages/06/19/f00725a8aee30163a7f257092e356388443034877c101757c1466e591bf8/websocket_client-0.44.0.tar.gz"
SRC_URI[md5sum] = "73d87aa16a2212da448b30aca9c5bf3b"
SRC_URI[sha256sum] = "15f585566e2ea7459136a632b9785aa081093064391878a448c382415e948d72"

S = "${WORKDIR}/websocket_client-${PV}"


