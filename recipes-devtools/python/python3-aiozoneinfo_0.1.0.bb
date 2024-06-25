SUMMARY = "Tools to fetch zoneinfo with asyncio"
HOMEPAGE = "https://github.com/bluetooth-devices/aiozoneinfo"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9fd9da0eba9bb27343ae47cb3fb6cde8"

SRC_URI[sha256sum] = "ed2e8f28d50026aaa6fe201336f3150fdd38c3eb0cda45c59589891132446a99"

inherit pypi python_poetry_core

PYPI_PACKAGE = "aiozoneinfo"
RDEPENDS:${PN} = "python3-tzdata (>= 2024.1)"
