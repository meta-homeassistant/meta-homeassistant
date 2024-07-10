SUMMARY = "Tools to fetch zoneinfo with asyncio"
HOMEPAGE = "https://github.com/bluetooth-devices/aiozoneinfo"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9fd9da0eba9bb27343ae47cb3fb6cde8"

SRC_URI[sha256sum] = "958b3152ef3e8f0b1b661563e68388431a0950ac7d5778b08353e94155924e70"

inherit pypi python_poetry_core

PYPI_PACKAGE = "aiozoneinfo"
RDEPENDS:${PN} = "python3-tzdata (>= 2024.1)"
