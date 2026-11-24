SUMMARY = "An async python package for interfacing with Cambridge Audio / Stream Magic compatible streamers."
HOMEPAGE = "https://github.com/noahhusby/aiostreammagic"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5b3223feaf2e8e65e8724a6b73fb9eed"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "43b404b176b7b9bb943c29bbd2433fd6e3030c80d3e6a508a8b6b7b94bfd6b5c"

inherit pypi python_poetry_core

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.12.14) \
    python3-mashumaro (>=3.17) \
    python3-orjson (>=3.11.0) \
    python3-yarl (>=1.20.1) \
"
