SUMMARY = "Watch for DHCP packets with asyncio"
HOMEPAGE = "https://github.com/bdraco/aiodhcpwatcher"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9162e57b23bfbab5d0cd9e24c0bfb450"

SRC_URI[sha256sum] = "0e5e6acbe34928eacaa85c5598aae0116ac13c5c796d7f44bc4859fe4903f570"

inherit pypi python_poetry_core

RDEPENDS:${PN} = "\
    python3-core (>=3.10) \
    python3-scapy (>=2.5.0) \
"
