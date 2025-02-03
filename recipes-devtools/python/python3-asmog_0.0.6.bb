SUMMARY = "Python API for Ampio Smog Sensors"
HOMEPAGE = "https://github.com/kstaniek/python-ampio-smog-api"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=2b42edef8fa55315f34f2370b4715ca9"

SRC_URI[sha256sum] = "93c742de0da863f6f8c389bb63f1d4cbfebfdd39b5927b71f6d8e8c97a836891"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-aiohttp \
    python3-async-timeout \
"

PYPI_PACKAGE = "asmog"
