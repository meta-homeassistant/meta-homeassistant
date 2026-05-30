SUMMARY = "A Python3 library for Elexa Guardian water valves and sensors"
HOMEPAGE = "https://github.com/bachya/aioguardian"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=483e9bb16c37c4cca4752306cfba6f0a"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI += "file://0001-Update-poetry-core-dependency-to-allow-for-newer-ver.patch"
SRC_URI[sha256sum] = "c0b722db2aff4c8e0053615d50d6e274b57f238e5bafd50e255fcd75ef94f567"

inherit pypi python_poetry_core

RDEPENDS:${PN} += "\
    python3-aiohttp (>=3.9.0) \
    python3-asyncio-dgram (>=2.0.0) \
    python3-certifi (>=2023.07.22) \
    python3-frozenlist (>=1.5.0) \
    python3-typing-extensions (>=4.8.0) \
    python3-voluptuous (>=0.11.7) \
    python3-yarl (>=1.9.2) \
"

PYPI_PACKAGE = "aioguardian"
