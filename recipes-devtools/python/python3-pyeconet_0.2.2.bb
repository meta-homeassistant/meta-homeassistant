SUMMARY = "Interface to the unofficial EcoNet API"
HOMEPAGE = "https://github.com/w1ll1am23/pyeconet"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c9b0b1affa7ca50f6b2fedc2a65d7c10"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "0c07c942a809fc17d638eee3d37c1e8ab4fc2778935f6786861be1a6b88ff84f"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} += "\
    python3-aiohttp (>=3.11.11) \
    python3-paho-mqtt (>=2.1.0) \
"

PYPI_PACKAGE = "pyeconet"
