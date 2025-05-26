SUMMARY = "Asynchronous Python client for LetPot hydroponic gardens."
HOMEPAGE = "https://github.com/jpelgrom/python-letpot"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=fb80d45742c18943f532290c2c8c9d96"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "f5a6859e060057599c8e225e81d82a640edc40d2ec27896ba2f156f0a2428ddd"

inherit pypi python_poetry_core

PYPI_PACKAGE = "letpot"

RDEPENDS:${PN} = "\
    python3-aiohttp \
    python3-aiomqtt \
"
