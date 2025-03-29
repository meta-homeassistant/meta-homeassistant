SUMMARY = "Library implementing EZSP"
HOMEPAGE = "https://github.com/zigpy/bellows"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS += "\
    python3-setuptools-git-versioning-native \
"

SRC_URI:append = " file://0001-Allow-setuptools-git-versioning-3.patch"
SRC_URI[sha256sum] = "15c427e98262e48c23c3f057fff5faeb3674264c3af5f3790886bd637452f4b0"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "bellows"

RDEPENDS:${PN} = "\
    python3-click \
    python3-click-log (>=0.2.1) \
    python3-pure-pcapy3 (>=1.0.1) \
    python3-voluptuous \
    python3-zigpy (>=0.70.0) \
"
