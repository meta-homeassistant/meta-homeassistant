SUMMARY = "Watch for DHCP packets with asyncio"
HOMEPAGE = "https://github.com/bdraco/aiodhcpwatcher"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9162e57b23bfbab5d0cd9e24c0bfb450"

SRC_URI[sha256sum] = "9b5f8bd0361455714e400dbc8ecfe2a9cdf7d3e26292f4fa2433aa3111c9fa43"

inherit pypi python_poetry_core

RDEPENDS:${PN} = "\
    python3-core (>=3.10) \
    python3-scapy (>=2.5.0) \
"
