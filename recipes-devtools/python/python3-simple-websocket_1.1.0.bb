SUMMARY = "Simple WebSocket server and client for Python"
HOMEPAGE = "https://github.com/miguelgrinberg/simple-websocket"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9d272c9fe2437531b5bbecf4fcc82e24"

SRC_URI[sha256sum] = "7939234e7aa067c534abdab3a9ed933ec9ce4691b0713c78acb195560aa52ae4"

inherit pypi python_setuptools_build_meta ptest-python-pytest

PYPI_PACKAGE = "simple_websocket"

RDEPENDS:${PN} = "python3-wsproto"

RDEPENDS:${PN}-ptest = "\
    python3-pytest-cov \
    python3-wsproto \
"
