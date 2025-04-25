SUMMARY = "Simple python wrapper over wirelesstags REST API"
HOMEPAGE = "https://github.com/sergeymaysak/wirelesstagpy/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f41ae89e0ff8515325f6df23b0809b2a"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS = "\
    python3-requests-native \
"

SRC_URI[sha256sum] = "025f897c46f54b76b3fb0ca861f4176389edca96f0d49131732e2796c0e10aa9"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-requests (>=2.18.4)"

PYPI_PACKAGE = "wirelesstagpy"
