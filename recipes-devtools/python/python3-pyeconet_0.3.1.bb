SUMMARY = "Interface to the unofficial EcoNet API"
HOMEPAGE = "https://github.com/w1ll1am23/pyeconet"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c9b0b1affa7ca50f6b2fedc2a65d7c10"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "cdc1741dc93bf642ef2b892c9c1bb2cd512cb75e896296f13df88db971ea31ac"

DEPENDS = "python3-wheel-native"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} += "\
    python3-aiohttp (>=3.11.11) \
    python3-paho-mqtt (>=2.1.0) \
"
