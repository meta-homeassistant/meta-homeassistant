SUMMARY = "Python 3 asyncio package for interacting with Control4 systems"
HOMEPAGE = "https://github.com/lawtancool/pyControl4"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "cc96a17c8e5a085bd843d1d64e3d5e8506c77ebedc73c9f61a8f484baffa1a86"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-aiohttp \
    python3-python-socketio-v4 \
    python3-websocket-client \
    python3-xmltodict \
"

PYPI_PACKAGE = "pycontrol4"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
