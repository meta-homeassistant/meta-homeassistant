SUMMARY = "Asynchronous Python client for LetPot hydroponic gardens."
HOMEPAGE = "https://github.com/jpelgrom/python-letpot"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=fb80d45742c18943f532290c2c8c9d96"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "9ecff9dda23bd65cff67fb83d4fbca2ea13cfe64257a1734925e62ac7cd96dc7"

inherit pypi python_poetry_core

PYPI_PACKAGE = "letpot"

RDEPENDS:${PN} = "\
    python3-aiohttp \
    python3-aiomqtt \
"
