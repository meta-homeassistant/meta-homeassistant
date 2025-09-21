SUMMARY = "Asynchronous Python client for LetPot hydroponic gardens."
HOMEPAGE = "https://github.com/jpelgrom/python-letpot"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=fb80d45742c18943f532290c2c8c9d96"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "0b98b69f590c12c4622e5753103712910f4d47a7207f2818284d2588875ba260"

inherit pypi python_poetry_core

PYPI_PACKAGE = "letpot"

RDEPENDS:${PN} = "\
    python3-aiohttp \
    python3-aiomqtt \
"
