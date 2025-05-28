SUMMARY = "Python server to interact with Matter"
HOMEPAGE = "https://github.com/home-assistant-libs/python-matter-server"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c5a0d917e64171a83d11a738274272f6"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "867fe6b39c2aebf0ee99c87f5d2300ae041b1737eb3e05a7cb90e8d6124c7d9e"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "python_matter_server"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"

RDEPENDS:${PN} += "\
    python3-aiohttp (>=3.10.5) \
    python3-aiorun (>=2024.8.1) \
    python3-async-timeout (=4.0.3) \
    python3-coloredlogs (=15.0.1) \
    python3-core (>= 3.11) \
    python3-cryptography (>=43.0.1) \
    python3-home-assistant-chip-clusters (=2024.11.4) \
    python3-orjson (>=3.10.7) \
    python3-zeroconf (>=0.134.0) \
"
