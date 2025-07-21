SUMMARY = "This is a fork of pubnub when it still had an MIT license"
HOMEPAGE = "https://github.com/bdraco/freenub"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=075824fb5a6827c1707eff27a4b6a621"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "56961826ba6ace9cb4b41747014b1b1443884443f6008857397d6ce44757f88b"

inherit pypi python_poetry_core

PYPI_PACKAGE = "freenub"
RDEPENDS:${PN} = "\
    python3-pycryptodomex (>=3.3) \
    python3-requests (>=2.4) \
    python3-cbor2 (>=5.6.4) \
    python3-aiohttp (>=3.9.5) \
"
