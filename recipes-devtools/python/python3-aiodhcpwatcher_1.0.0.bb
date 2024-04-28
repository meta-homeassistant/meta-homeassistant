SUMMARY = "Watch for DHCP packets with asyncio"
HOMEPAGE = "https://github.com/bdraco/aiodhcpwatcher"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9162e57b23bfbab5d0cd9e24c0bfb450"

SRC_URI[sha256sum] = "73fd94c08ebe56d616abc8d66a10cef28a2bd6a109b04237ab72bb815adecb63"

inherit pypi python_poetry_core

RDEPENDS:${PN} = "\
    python3-core (>=3.10) \
    python3-scapy (>=2.5.0) \
"
