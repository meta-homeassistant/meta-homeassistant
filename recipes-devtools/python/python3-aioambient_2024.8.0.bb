SUMMARY = "A clean, async-friendly library for the Ambient Weather API"
HOMEPAGE = "https://github.com/bachya/aioambient"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=54f0a03d1f0386cedfc691fdb5edb93a"

SRC_URI[sha256sum] = "a11643343db382ba9c5a79c70a9394dbf2ae6b1d4a28c4ef43b7c69618b237da"

inherit pypi python_poetry_core

RDEPENDS:${PN} += "\
    python3-aiohttp (>=3.9.0b0) \
    python3-certifi (>=2023.07.22) \
    python3-engineio (>=3.13.1) \
    python3-socketio (>=4.6) \
    python3-websockets (>=11.0.1) \
    python3-yarl (>=1.9.2) \
"

PYPI_PACKAGE = "aioambient"
