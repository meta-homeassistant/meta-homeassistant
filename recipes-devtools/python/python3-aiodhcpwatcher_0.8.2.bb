SUMMARY = "Watch for DHCP packets with asyncio"
HOMEPAGE = "https://github.com/bdraco/aiodhcpwatcher"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9162e57b23bfbab5d0cd9e24c0bfb450"

SRC_URI[sha256sum] = "a887f89ca7b802ba8cecdb3b2643f3a4794d05d9ba2a567582ab770184d0a5ad"

inherit pypi python_poetry_core

RDEPENDS:${PN} = "\
    python3-core (>=3.10) \
    python3-scapy (>=2.5.0) \
"
