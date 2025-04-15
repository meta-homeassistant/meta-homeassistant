SUMMARY = "Watch for DHCP packets with asyncio"
HOMEPAGE = "https://github.com/bdraco/aiodhcpwatcher"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=732518afbb3ba92dbf606e49f9045cc9"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "d9c74f627a1f0426dadba9c80bdf83c29a962741f6a97565136aaf17cc3f2ae7"

inherit pypi python_poetry_core

RDEPENDS:${PN} = "\
    python3-core (>=3.10) \
    python3-scapy (>=2.5.0) \
"
