SUMMARY = "Api wrapper for Asuswrt https://www.asus.com/ASUSWRT/"
HOMEPAGE = "https://github.com/kennedyshead/aioasuswrt"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=04d72ec5ee971fa029c23c36d1fc0e64"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "e9644ae713e6ee8b16916367857d2bfc097586aa597d0ef5b01736610097fa08"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-asyncssh \
"

PYPI_PACKAGE = "aioasuswrt"
