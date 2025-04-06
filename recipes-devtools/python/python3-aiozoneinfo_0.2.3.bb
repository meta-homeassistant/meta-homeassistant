SUMMARY = "Tools to fetch zoneinfo with asyncio"
HOMEPAGE = "https://github.com/bluetooth-devices/aiozoneinfo"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9fd9da0eba9bb27343ae47cb3fb6cde8"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "987ce2a7d5141f3f4c2e9d50606310d0bf60d688ad9f087aa7267433ba85fff3"

inherit pypi python_poetry_core

PYPI_PACKAGE = "aiozoneinfo"
RDEPENDS:${PN} = "python3-tzdata (>= 2024.1)"
