SUMMARY = "Tools to fetch zoneinfo with asyncio"
HOMEPAGE = "https://github.com/bluetooth-devices/aiozoneinfo"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9fd9da0eba9bb27343ae47cb3fb6cde8"

SRC_URI[sha256sum] = "457e2c665a2c7e093119efb87cc5e0da29e6f59aac504a544bec822c5be1cb6b"

inherit pypi python_poetry_core

PYPI_PACKAGE = "aiozoneinfo"
RDEPENDS:${PN} = "python3-tzdata (>= 2024.1)"
