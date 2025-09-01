SUMMARY = "Engine.IO server"
HOMEPAGE = "http://github.com/bdraco/python-engineio-v3/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=42d0a9e728978f0eeb759c3be91536b8"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "b58ae2ffe38a2090165b37a28c5c2063d3caeba947e7ce1dbd99e8056cb3685c"

inherit pypi setuptools3

PACKAGECONFIG ?= "asyncio-client client"
PACKAGECONFIG[asyncio-client] = ",,,python3-aiohttp"
PACKAGECONFIG[client] = ",,,python3-requests python3-websocket-client"

RDEPENDS:${PN} += "python3-six (>=1.9.0)"

PYPI_PACKAGE = "python-engineio-v3"
