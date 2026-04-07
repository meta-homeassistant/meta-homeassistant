SUMMARY = "Library, implementing websocket connection to ZWave-Me"
HOMEPAGE = "https://github.com/Z-Wave-Me/zwave-me-ws"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=6;endline=6;md5=8227180126797a0148f94f483f3e1489"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "cdac9602054fb677c2227c8f47429fd785b29278d7a5ca033af4e37c7d17e247"

inherit pypi python_poetry_core

PYPI_PACKAGE = "zwave_me_ws"

RDEPENDS:${PN} = "\
    python3-core (>=3.8) \
    python3-requests (>=2.28.1) \
    python3-websocket-client (>=1.2.1) \
"
