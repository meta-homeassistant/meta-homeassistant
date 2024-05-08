SUMMARY = "Python server to interact with Matter"
HOMEPAGE = "https://github.com/home-assistant-libs/python-matter-server"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c5a0d917e64171a83d11a738274272f6"

SRC_URI[sha256sum] = "de4944bfeabf7ad3a28e20a1db9b62b1a9414a2a5cfc41d6dbee2867d088cb6a"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "python_matter_server"

RDEPENDS:${PN} += "\
    python3-aiohttp \
    python3-aiorun \
    python3-async-timeout \
    python3-core (>= 3.10) \
    python3-coloredlogs \
    python3-dacite \
    python3-home-assistant-chip-clusters (=2024.3.2) \
    python3-orjson \
"
