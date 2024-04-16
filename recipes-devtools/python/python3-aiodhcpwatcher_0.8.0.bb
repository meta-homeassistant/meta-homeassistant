SUMMARY = "Watch for DHCP packets with asyncio"
HOMEPAGE = "https://github.com/bdraco/aiodhcpwatcher"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9162e57b23bfbab5d0cd9e24c0bfb450"

SRC_URI[sha256sum] = "3f01b66334178accbbdd8d38c749607fc40c296eb6b043784d90005dd0e08042"

inherit pypi python_poetry_core

RDEPENDS:${PN} = "\
    python3-scapy \
"
