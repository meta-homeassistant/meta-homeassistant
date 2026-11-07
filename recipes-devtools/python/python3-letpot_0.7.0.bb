SUMMARY = "Asynchronous Python client for LetPot hydroponic gardens."
HOMEPAGE = "https://github.com/jpelgrom/python-letpot"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=fb80d45742c18943f532290c2c8c9d96"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "6c042d3c249b3d8465cb5e35ae1df1744c45506e65cc8c5cd90a27d0bd5c3f08"

inherit pypi python_poetry_core


RDEPENDS:${PN} = "\
    python3-aiohttp \
    python3-aiomqtt \
"
