SUMMARY = "Official Python lib for Crownstone: Crownstone Unified System Bridge, or Crownstone USB implementation."
HOMEPAGE = "https://github.com/crownstone/crownstone-lib-python-uart"
LICENSE = "Apache-2.0 & LGPL-3.0-only & MIT"
LIC_FILES_CHKSUM = "\
    file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302 \
    file://${COMMON_LICENSE_DIR}/LGPL-3.0-only;md5=bfccfe952269fff2b407dd11f2f3083b \
    file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10 \
"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI += "file://0001-Fix-compilation.patch"
SRC_URI[sha256sum] = "4e426559d82cc67b57fbaea4a59699eba6812c187f9bedd8d36874c093964c84"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-crownstone-core (>=3.2) \
    python3-pyserial (>=3.4) \
"

PYPI_PACKAGE = "crownstone-uart"
