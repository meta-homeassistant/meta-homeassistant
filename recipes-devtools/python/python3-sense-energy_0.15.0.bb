
SUMMARY = "API for the Sense Energy Monitor"
HOMEPAGE = "https://github.com/scottbonline/sense"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=a16ded088d7b140bcb0b8a7a23a87288"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "c50f59c1467d4a0735e190fd54620203f88d85d637ed42c55bdc5511e961ca34"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-aiohttp \
    python3-async-timeout (>=3.0.1) \
    python3-ciso8601 \
    python3-kasa-crypt (>=0.2.0) \
    python3-msgpack \
    python3-orjson \
    python3-requests \
    python3-websocket-client \
    python3-websockets \
"
