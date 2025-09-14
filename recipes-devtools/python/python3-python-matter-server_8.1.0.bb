SUMMARY = "Python server to interact with Matter"
HOMEPAGE = "https://github.com/home-assistant-libs/python-matter-server"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c5a0d917e64171a83d11a738274272f6"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "e3ec9b8d33232ac06a8bb32192a197d48d381be8f9ecd2f64aad36c60525c70c"

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
