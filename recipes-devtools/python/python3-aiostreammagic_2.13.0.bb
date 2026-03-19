SUMMARY = "An async python package for interfacing with Cambridge Audio / Stream Magic compatible streamers."
HOMEPAGE = "https://github.com/noahhusby/aiostreammagic"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5b3223feaf2e8e65e8724a6b73fb9eed"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "3c101fac17d5881d66b700b935790aa93e63425fca8796acccdd3535e7787058"

inherit pypi python_poetry_core

PYPI_PACKAGE = "aiostreammagic"
RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.12.14) \
    python3-mashumaro (>=3.17) \
    python3-orjson (>=3.11.0) \
    python3-yarl (>=1.20.1) \
"
