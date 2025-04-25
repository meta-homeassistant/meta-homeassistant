SUMMARY = "Library implementing EZSP"
HOMEPAGE = "https://github.com/zigpy/bellows"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS += "\
    python3-setuptools-git-versioning-native \
"

SRC_URI = "git://github.com/zigpy/bellows.git;protocol=https;branch=dev \
           file://0001-Relax-gitversioning-version.patch \
           "
SRC_URI[sha256sum] = "15c427e98262e48c23c3f057fff5faeb3674264c3af5f3790886bd637452f4b0"
SRCREV = "1f61e0b0a37c9a81d628683c9748878b5c0aa30d"

inherit python_setuptools_build_meta ptest-python-pytest

S = "${WORKDIR}/git"

RDEPENDS:${PN} = "\
    python3-click \
    python3-click-log (>=0.2.1) \
    python3-pure-pcapy3 (>=1.0.1) \
    python3-voluptuous \
    python3-zigpy (>=0.70.0) \
"

RDEPENDS:${PN}-ptest += "\
    python3-pytest-asyncio \
    python3-pytest-timeout \
"
