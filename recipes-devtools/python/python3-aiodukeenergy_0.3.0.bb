SUMMARY = "Asyncio Duke Energy"
HOMEPAGE = "https://github.com/hunterjm/aiodukeenergy"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b1d5bc515bcc043c6622fceeb3cdd82f"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "d78dfed4c582d43a08bd1f059d31b038d0bbe45be54744e562dc550561b2b79c"

inherit pypi python_poetry_core

PYPI_PACKAGE = "aiodukeenergy"
RDEPENDS:${PN} = "python3-aiohttp (>=3.9.0) python3-yarl (>=1.9.0)"
