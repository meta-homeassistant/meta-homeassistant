SUMMARY = "A Python client library for A. O. Smith water heaters"
HOMEPAGE = "https://github.com/bdr99/py-aosmith"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=8afcf31bd10bbe304f13798fbb1feb3b"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "96f1a533af802db42761a37771dcb84ee16979c42ba88629dbe431801ab20be9"

inherit pypi python_poetry_core


RDEPENDS:${PN} = "\
    python3-aiohttp (>= 3.8.6) \
    python3-tenacity (>=8.2.3) \
"
