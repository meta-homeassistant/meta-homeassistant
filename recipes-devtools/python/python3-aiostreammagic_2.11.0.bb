SUMMARY = "An async python package for interfacing with Cambridge Audio / Stream Magic compatible streamers."
HOMEPAGE = "https://github.com/noahhusby/aiostreammagic"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5b3223feaf2e8e65e8724a6b73fb9eed"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "21c4a079b79acc816ff7b7a1ffbf3ea4c5f4cc2cae74f31949bf5e2e77da02e6"

inherit pypi python_poetry_core

PYPI_PACKAGE = "aiostreammagic"
RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.11.7) \
    python3-mashumaro (>=3.11) \
    python3-orjson (>=3.9.0) \
    python3-yarl (>=1.6.0) \
"
