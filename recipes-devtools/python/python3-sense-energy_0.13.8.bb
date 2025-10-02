
SUMMARY = "API for the Sense Energy Monitor"
HOMEPAGE = "https://github.com/scottbonline/sense"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=a16ded088d7b140bcb0b8a7a23a87288"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "ad95fb674f6407116cedeedceba594d0d9e3daf3f80a3024815a13ea8789c8be"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-aiohttp \
    python3-async-timeout (>=3.0.1) \
    python3-ciso8601 \
    python3-kasa-crypt (>=0.2.0) \
    python3-orjson \
    python3-requests \
    python3-websocket-client \
    python3-websockets \
"

PYPI_PACKAGE = "sense_energy"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
