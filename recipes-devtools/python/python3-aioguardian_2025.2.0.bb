SUMMARY = "A Python3 library for Elexa Guardian water valves and sensors"
HOMEPAGE = "https://github.com/bachya/aioguardian"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a91f9b07cce597b2a12f27ca09d89895"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "4e3e7890cf063f73957da872af9a1bbe2e0fa3d7352cc21b5833903315bb4b10"

inherit pypi python_poetry_core

RDEPENDS:${PN} += "\
    python3-aiohttp (>=3.9.0) \
    python3-asyncio-dgram (=2.0.0) \
    python3-certifi (>=2023.07.22) \
    python3-frozenlist (=1.5.0) \
    python3-typing-extensions (=4.8.0) \
    python3-voluptuous (>=0.11.7) \
    python3-yarl (>=1.9.2) \
"

PYPI_PACKAGE = "aioguardian"
