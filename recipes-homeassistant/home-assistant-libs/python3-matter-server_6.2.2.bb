SUMMARY = "Python server to interact with Matter"
HOMEPAGE = "https://github.com/home-assistant-libs/python-matter-server"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c5a0d917e64171a83d11a738274272f6"

SRC_URI[sha256sum] = "5ccbc2fe9281d13f32e7fbbc9fd3f6ebdbb319c54b9136620350e76ab03d5bec"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "python_matter_server"

RDEPENDS:${PN} += "\
    python3-aiohttp (>=3.9.5) \
    python3-aiorun (=2024.5.1) \
    python3-async-timeout (=4.0.3) \
    python3-coloredlogs (=15.0.1) \
    python3-core (>= 3.11) \
    python3-cryptography (>=42.0.8) \
    python3-home-assistant-chip-clusters (=2024.7.0) \
    python3-orjson (>=3.10.5) \
    python3-zeroconf (=0.132.2) \
"
