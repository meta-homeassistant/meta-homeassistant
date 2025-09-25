SUMMARY = "An asyncio wrapper for the UK Environment Agency Flood Monitoring API"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a844d70ecade3a2538ffaf80d0e480b9"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI += "file://0001-use-poetry-core.patch"
SRC_URI[sha256sum] = "3b54ad33a60fc7a050945dc5b9bd006d6039a5944f31e45b8ebc66ddf33863ad"

inherit pypi python_poetry_core

RDEPENDS:${PN} += "python3-aiohttp"

PYPI_PACKAGE = "aioeafm"
