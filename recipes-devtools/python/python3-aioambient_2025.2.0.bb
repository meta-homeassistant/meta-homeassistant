SUMMARY = "A clean, async-friendly library for the Ambient Weather API"
HOMEPAGE = "https://github.com/bachya/aioambient"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=54f0a03d1f0386cedfc691fdb5edb93a"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "07ab9f36e4e3d3ebd8f4ee9c75f0ab9b87ad09cf1d9e4515e238c9353328f7c8"

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
