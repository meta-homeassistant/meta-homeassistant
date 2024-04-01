SUMMARY = "Python server to interact with Matter"
HOMEPAGE = "https://github.com/home-assistant-libs/python-matter-server"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c5a0d917e64171a83d11a738274272f6"

SRC_URI[sha256sum] = "01208e2f7cb8f624f77a2246e1a4645b73c8bcac81d2f6feb4d2494c8f7ea21e"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "python-matter-server"

RDEPENDS:${PN} += "\
    python3-aiohttp \
    python3-aiorun \
    python3-async-timeout \
    python3-core (>= 3.10) \
    python3-coloredlogs \
    python3-dacite \
    python3-home-assistant-chip-clusters (=2024.1.0) \
    python3-orjson \
"
