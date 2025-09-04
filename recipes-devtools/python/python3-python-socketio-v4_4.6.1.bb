SUMMARY = "Socket.IO server"
HOMEPAGE = "http://github.com/bdraco/python-socketio-v4/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=42d0a9e728978f0eeb759c3be91536b8"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "dd5ccb3d84f8a78521d94e03329c6eea4ab534f65794ea963a58cb39ed1b338d"

inherit pypi setuptools3

PACKAGECONFIG ?= "asyncio-client client"
PACKAGECONFIG[asyncio-client] = ",,,python3-aiohttp (>=3.4) python3-websockets (>=7.0)"
PACKAGECONFIG[client] = ",,,python3-requests (>=2.21.0) python3-websocket-client (>=0.54.0)"

RDEPENDS:${PN} += "\
    python3-python-engineio-v3 (>=3.13.0) \
    python3-six (>=1.9.0) \
"

PYPI_PACKAGE = "python-socketio-v4"
