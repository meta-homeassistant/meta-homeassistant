SUMMARY = "isal support for aiohttp"
HOMEPAGE = "https://github.com/bdraco/aiohttp-isal"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9fd9da0eba9bb27343ae47cb3fb6cde8"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI = "git://github.com/bdraco/aiohttp-isal.git;protocol=https;branch=main"
SRC_URI[sha256sum] = "5fa3ab3ebaff80ba3d39cafecf5916e9c8a1117178d2085ad1d0123d13d8bf71"
SRCREV = "698b3ead9131e09b782d2fce8efa60697c107887"

inherit python_poetry_core ptest-python-pytest

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.9.0) \
    python3-isal \
"
