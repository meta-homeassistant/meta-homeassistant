SUMMARY = "A library for interacting with the PECO outage map to gain the numbers from it."
HOMEPAGE = "https://IceBotYT.github.io/peco-outage-api"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a744b5db69f59a2cc2a223bfc51b8cdc"

SRC_URI[sha256sum] = "c56eb9b442fce9e70e7c621b9c68929cab6aed298a4315b678c4d5aecfe7c4d7"

inherit pypi python_poetry_core

RDEPENDS:${PN} += "\
    python3-aiohttp (>=3.9.5) \
    python3-pydantic (>=1.8) \
"

PYPI_PACKAGE = "peco"
